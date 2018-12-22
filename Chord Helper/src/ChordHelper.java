import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class ChordHelper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.print("Welcome to chord helper! ");

		ArrayList<ChordSet> allChords = getAllChords();

		Scanner in = new Scanner(System.in);

		while(true)
		{
			System.out.println("What would you like to do?");
			System.out.println("1. Spell all chords with a given root");
			System.out.println("2. Show all chords in a given key");
			System.out.println("3. Exit");

			if(in.hasNextInt())
			{
				int userChoice = in.nextInt();

				if(userChoice == 1)
				{
					chordsWithRoot(allChords);
				}
				else if(userChoice == 2)
				{
					chordsInKey(allChords);
				}
				else if(userChoice == 3)
				{
					//end program
					System.out.println("Goodbye");
					break;
				}
				else
				{
					System.out.println("Invalid Choice. Try Again");
				}
			}
			else
			{
				in.next();
				System.out.println("Invalid Choice. Try Again");
			}
		}
	}

	public static void chordsWithRoot(ArrayList<ChordSet> allChords)
	{
		System.out.println("Enter a root note and I will show you all chords with that root");
		System.out.println("(use capital letter, # for sharp, b for flat)");

		Scanner in = new Scanner(System.in);

		if(in.hasNext())
		{
			String userInput = in.next();

			String root = "";

			if(userInput.length() == 1)
			{
				root = userInput.substring(0, 1);
			}
			else if(userInput.length() == 2)
			{
				root = userInput.substring(0, 2);
			}

			int rootNumber = getNoteNumber(root);

			printAllChordTypes(allChords.get(rootNumber));
		}
	}

	public static void chordsInKey(ArrayList<ChordSet> allChords)
	{
		System.out.println("Enter a root note and I will show you all chords with notes in that key");
		System.out.println("(use capital letter, # for sharp, b for flat, M for major, m for minor)");

		Scanner in = new Scanner(System.in);

		if(in.hasNext())
		{
			String userInput = in.next();

			String root = "";

			int[] key = {};

			if(userInput.length() == 2)
			{
				root = userInput.substring(0, 1);

				if(userInput.substring(1, 2).equals("M"))
				{
					key = getMajorKey(root);
				}
				else if(userInput.substring(1, 2).equals("m"))
				{
					//key is minor
					key = getMinorKey(root);
				}
			}
			else if(userInput.length() == 3)
			{
				root = userInput.substring(0, 2);

				if(userInput.substring(2, 3).equals("M"))
				{
					key = getMajorKey(root);
				}
				else if(userInput.substring(2, 3).equals("m"))
				{
					//key is minor
					key = getMinorKey(root);
				}
			}

			printChordsInKey(root, key, allChords);
		}
	}

	public static int getNoteNumber(String n)
	{		
		// default to A natural
		int noteNum = 0;

		if(n.contains("A"))
		{
			noteNum = 0;
		}
		else if(n.contains("B"))
		{
			noteNum = 2;
		}
		else if(n.contains("C"))
		{
			noteNum = 3;
		}
		else if(n.contains("D"))
		{
			noteNum = 5;
		}
		else if(n.contains("E"))
		{
			noteNum = 7;
		}
		else if(n.contains("F"))
		{
			noteNum = 8;
		}
		else if(n.contains("G"))
		{
			noteNum = 10;
		}
		else
		{
			return -1;
		}


		if(n.contains("#"))
		{
			//note is sharp
			return (noteNum + 1) % 12;
		}
		else if(n.contains("b"))
		{
			//note is flat
			return (noteNum -1) % 12;
		}
		else
		{
			// note is natural
			return noteNum;
		}
	}

	public static int[] getMajorKey(String rootName)
	{
		int root = getNoteNumber(rootName);

		//set intervals between notes
		int[] key = {0, 2, 4, 5, 7, 9, 11};

		for(int i = 0; i < 7; i++)
		{
			//maintain intervals but start at new root
			key[i] = (key[i] + root) % 12;
		}
		
		Arrays.sort(key);
		
		return key;
	}

	public static int[] getMinorKey(String rootName)
	{
		int root = getNoteNumber(rootName);

		//set intervals between notes
		int[] key = {0, 2, 3, 5, 7, 8, 10};

		for(int i = 0; i < 7; i++)
		{
			//maintain intervals but start at new root
			key[i] = (key[i] + root) % 12;
		}
		return key;
	}

	public static ArrayList<ChordSet> getAllChords()
	{
		ArrayList<ChordSet> chords = new ArrayList<ChordSet>();

		for(int i = 0; i < 12; i++)
		{
			ChordSet c = new ChordSet(i);

			chords.add(c);
		}

		return chords;
	}

	/**
	 * print all chords types on a given key
	 * @param chords	given ChordSet
	 */
	public static void printAllChordTypes(ChordSet chords)
	{
		for(String chordType : chords.getChords().keySet())
		{
			//print each chord type
			printChord(chordType, chords.getChords().get(chordType));
		}
		System.out.println("");
	}

	public static void printChord(String chordType, int[] chord)
	{
		//print chord type
		System.out.print(chordType + ": ");
		for(int i = 0; i < chord.length; i++)
		{
			System.out.print(getNoteLetter(chord[i]) + " ");
		}
		//create new line after printing chord
		System.out.println();
	}

	public static String getNoteLetter(int note)
	{
		// default to A natural
		String noteLetter = "";

		//enforce needed note number range
		note = note % 12;

		switch(note)
		{
		case 0:
			return "A";
		case 2:
			return "B";
		case 3:
			return "C";
		case 5:
			return "D";
		case 7:
			return "E";
		case 8:
			return "F";
		case 10:
			return "G";
		}

		/*		if(flat)
		{
			//return the flat version of the note
			switch(note)
			{
			case 1:
				return "Bb";
			case 4:
				return "Db";
			case 6:
				return "Eb";
			case 9:
				return "Gb";
			case 11:
				return "Ab";
			}
		}
		else
		{*/
		//return the sharp version of the note
		switch(note)
		{
		case 1:
			return "A#";
		case 4:
			return "C#";
		case 6:
			return "D#";
		case 9:
			return "F#";
		case 11:
			return "G#";
		}
		//}

		return null;
	}

	public static void printChordsInKey(String root, int[] key, ArrayList<ChordSet> allChords)
	{
		System.out.println("Chords with notes in the key of " + root + "\n");

		for(ChordSet rootChords : allChords)
		{
			String chordRoot = getNoteLetter(rootChords.getRootNumber());

			System.out.println(chordRoot + ": ");

			// eliminate notes where the root is already ineligible
			if(noteInKey(rootChords.getRootNumber(), key))
			{
				LinkedHashMap<String, int[]> chords = rootChords.getChords();

				//check all chord types for eligible chords
				for(String chordType: chords.keySet())
				{
					if(chordInKey(key, chords.get(chordType)))
					{
						//all chord notes are in the given key
						printChord(chordType, chords.get(chordType));
					}
				}
			}
			System.out.println();
		}
	}

	/**
	 * Iterate through all notes in a chord and check if they are all within the given key
	 * @param key		given key signature
	 * @param chord		given chord
	 * @return			true if all chord notes are in key, false if one or more chord notes is not in key
	 */
	public static boolean chordInKey(int[] key, int[] chord)
	{
		for(int i = 0; i < chord.length; i++)
		{
			if(!noteInKey(chord[i], key))
			{
				// given note is not in key
				return false;
			}
		}

		// all notes are in the key
		return true;
	}

	public static boolean noteInKey(int note, int[] key)
	{
		int result =  Arrays.binarySearch(key, note);
		
		if(result < 0)
		{
			//key does not contains note
			return false;
		}
		else
		{
			//key contains note
			return true;
		}
	}


}
