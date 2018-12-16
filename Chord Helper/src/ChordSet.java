import java.util.ArrayList;
import java.util.HashMap;

public class ChordSet
{
	private int root;
	
	private int[] major;
	
	private int[] minor;

	private HashMap<String, int[]> chords;
	
	public ChordSet(int r)
	{
		root = r;
		setChords();
	}
	
	public int getRootNumber()
	{
		return root;
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
		chords.put("diminished", setDiminished());
		chords.put("augmented", setAugmented());
		chords.put("sus2", setSus2());
		chords.put("sus4", setSus4());
		chords.put("dominantSeven", setDominantSeventh());
		chords.put("majorSeven", setMajorSeventh());
		chords.put("minorSeven", setMinorSeventh());
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
	
	public int[] setDiminished()
	{
		int[] diminished = new int[3];
		diminished[0] = root;
		diminished[1] = minor[1]; // minor third
		diminished[2] = (minor[2] - 1) % 12; // flat fifth
		return diminished;
	}
	
	public int[] setAugmented()
	{
		int[] augmented = new int[3];
		augmented[0] = root;
		augmented[1] = major[1]; // major third
		augmented[2] = (major[2] + 1) % 12; // sharp fifth
		return augmented;
	}
	
	public int[] setSus2()
	{
		int[] sus2 = new int[3];
		sus2[0] = root;
		sus2[1] = (root + 2) % 12; // major second
		sus2[2] = major[2]; // perfect fifth
		return sus2;
	}
	
	public int[] setSus4()
	{
		int[] sus4 = new int[3];
		sus4[0] = root;
		sus4[1] = (major[1] + 1) % 12; // perfect fourth
		sus4[2] = major[2]; // perfect fifth
		return sus4;
	}
	
	public int[] setDominantSeventh()
	{
		int[] dominantSeventh = new int[4];
		dominantSeventh[0] = root;
		dominantSeventh[1] = major[1]; // major third
		dominantSeventh[2] = major[2]; // perfect fifth
		dominantSeventh[3] = (root - 2) % 12; // minor seventh
		return dominantSeventh;
	}
	
	public int[] setMajorSeventh()
	{
		int[] majorSeventh = new int[4];
		majorSeventh[0] = root;
		majorSeventh[1] = major[1]; // major third
		majorSeventh[2] = major[2]; // perfect fifth
		majorSeventh[3] = (root - 1) % 12; // major seventh
		return majorSeventh;
	}
	
	public int[] setMinorSeventh()
	{
		int[] minorSeventh = new int[4];
		minorSeventh[0] = root;
		minorSeventh[1] = minor[1]; // minor third
		minorSeventh[2] = minor[2]; // perfect fifth
		minorSeventh[3] = (root - 2) % 12; // minor seventh
		return minorSeventh;
	}
}