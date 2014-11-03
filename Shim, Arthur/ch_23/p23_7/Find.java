package p23_7;

import java.io.File;

public class Find {
	private File[] files;
	private String word;
	
	/**
	 * Creates a new Find object with the given files to be searched and word to be found
	 * @param f files
	 * @param w word to be found
	 */
	public Find(File[] f, String w)
	{
		files = new File[f.length];
		System.arraycopy(f, 0, files, 0, files.length);
		word = w;
	}
	
	public String linesWithWord()
	{
		return null;
	}
}
