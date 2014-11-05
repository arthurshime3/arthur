

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Find {
	private File[] files;
	private String word; 
	private ArrayList<String> lines = new ArrayList<String>();
	
	/**
	 * Creates a new Find object with the given files to be searched and word to be found
	 * @param f files
	 * @param w word to be found
	 */
	public Find(File[] f, String w)
	{
		files = new File[f.length];
		System.arraycopy(f, 0, files, 0, f.length);
		word = w;
	}
	
	public void findLines() throws FileNotFoundException
	{
		Scanner in = null;
		for (int x = 0; x < files.length; x++)
		{
			in = new Scanner(files[x]);
			while(in.hasNext())
			{
				String line = in.nextLine();
				if (hasWord(line))
					lines.add(line);
			}
		}
		in.close();
	}
		
	public boolean hasWord(String line)
	{
		for (int x = 0; x < line.length() - word.length(); x++)
			if (word.equalsIgnoreCase(line.substring(x, x + word.length())))
				return true;
		
		return false;
	}
	
	public void showLines()
	{
		for (String a : lines)
			System.out.println(a);
	}
}
