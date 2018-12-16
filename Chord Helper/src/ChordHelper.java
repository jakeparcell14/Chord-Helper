import java.util.Scanner;

public class ChordHelper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Welcome to chord helper! What would you like to do?");
		System.out.println("1. Spell all chords with a given root");
		System.out.println("2. Show all chords in a given key");
		System.out.println("3. Exit");

		//System.out.println("Enter a root note and I will show you all chords with notes in that key");
		//System.out.println("(use capital letter, # for sharp, b for flat)");

		Scanner in = new Scanner(System.in);

		while(in.hasNext())
		{
			if(in.hasNextInt())
			{
				int userChoice = in.nextInt();

				if(userChoice == 1)
				{
					
				}
				else if(userChoice == 2)
				{

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
	
	public static void chordsWithRoot()
	{
		
	}
	
	public static void chordsInKey()
	{
		
	}
	
	public int getNoteNumber(String n)
	{		
		// default to C natural
		int noteNum = 0;
		
		if(n.contains("C"))
		{
			noteNum = 0;
		}
		else if(n.contains("D"))
		{
			noteNum = 2;
		}
		else if(n.contains("E"))
		{
			noteNum = 4;
		}
		else if(n.contains("F"))
		{
			noteNum = 5;
		}
		else if(n.contains("G"))
		{
			noteNum = 7;
		}
		else if(n.contains("A"))
		{
			noteNum = 9;
		}
		else if(n.contains("B"))
		{
			noteNum = 11;
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
	
	public int[] getMajorKey(int root)
	{
		//set intervals between notes
		int[] key = {0, 2, 4, 5, 7, 9, 11};

		for(int i = 0; i < 7; i++)
		{
			//maintain intervals but start at new root
			key[i] = (key[i] + root) % 12;
		}
		return key;
	}
	
	public int[] getMinorKey(int root)
	{
		//set intervals between notes
		int[] key = {0, 2, 3, 5, 7, 8, 10};

		for(int i = 0; i < 7; i++)
		{
			//maintain intervals but start at new root
			key[i] = (key[i] + root) % 12;
		}
		return key;
	}

}
