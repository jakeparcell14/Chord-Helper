import java.util.ArrayList;
import java.util.HashMap;

public class Chord 
{
	private int root;
	
	private int[] major;
	
	private int[] minor;

	private int[] diminished;

	private int[] augmented;

	private int[] sus2;

	private int[] sus4;

	private int[] dominantSeventh;

	private int[] majorSeventh;
	
	private int[] minorSeventh;

	private HashMap<String, int[]> chords;
	
	public Chord(String r)
	{
		root = getNoteNumber(r);
		setChords();
	}
	
	public HashMap<String, int[]> getChords()
	{
		return chords;
	}
	
	private void setChords()
	{
		setMajor();
		setMinor();
		setDiminished();
		setAugmented();
		setSus2();
		setSus4();
		setDominantSeventh();
		setMajorSeventh();
		setMinorSeventh();
		
		fillChords();
	}
	
	private void fillChords()
	{
		chords.put("major", major);
		chords.put("minor", minor);
		chords.put("diminished", diminished);
		chords.put("augmented", augmented);
		chords.put("sus2", sus2);
		chords.put("sus4", sus4);
		chords.put("dominantSeven", dominantSeventh);
		chords.put("majorSeven", majorSeventh);
		chords.put("minorSeven", minorSeventh);
	}
	
	private int getNoteNumber(String n)
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
		
	public void setMajor()
	{
		major = new int[3];
		major[0] = root;
		major[1] = (root + 4) % 12; // major third
		major[2] = (root + 7) % 12; //perfect fifth
	}
	
	public void setMinor()
	{
		minor = new int[3];
		minor[0] = root;
		minor[1] = (major[1] - 1) % 12; // minor third
		minor[2] = major[2]; // perfect fifth
	}
	
	public void setDiminished()
	{
		diminished = new int[3];
		diminished[0] = root;
		diminished[1] = minor[1]; // minor third
		diminished[2] = (minor[2] - 1) % 12; // flat fifth
	}
	
	public void setAugmented()
	{
		augmented = new int[3];
		augmented[0] = root;
		augmented[1] = major[1]; // major third
		augmented[2] = (major[2] + 1) % 12; // sharp fifth
	}
	
	public void setSus2()
	{
		sus2 = new int[3];
		sus2[0] = root;
		sus2[1] = (root + 2) % 12; // major second
		sus2[2] = major[2]; // perfect fifth
	}
	
	public void setSus4()
	{
		sus4 = new int[3];
		sus4[0] = root;
		sus4[1] = (major[1] + 1) % 12; // perfect fourth
		sus4[2] = major[2]; // perfect fifth
	}
	
	public void setDominantSeventh()
	{
		dominantSeventh = new int[4];
		dominantSeventh[0] = root;
		dominantSeventh[1] = major[1]; // major third
		dominantSeventh[2] = major[2]; // perfect fifth
		dominantSeventh[3] = (root - 2) % 12; // minor seventh
	}
	
	public void setMajorSeventh()
	{
		majorSeventh = new int[4];
		majorSeventh[0] = root;
		majorSeventh[1] = major[1]; // major third
		majorSeventh[2] = major[2]; // perfect fifth
		majorSeventh[3] = (root - 1) % 12; // major seventh
	}
	
	public void setMinorSeventh()
	{
		minorSeventh = new int[4];
		minorSeventh[0] = root;
		minorSeventh[1] = minor[1]; // minor third
		minorSeventh[2] = minor[2]; // perfect fifth
		minorSeventh[3] = (root - 2) % 12; // minor seventh
	}


}
