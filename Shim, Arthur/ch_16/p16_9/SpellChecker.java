package p16_9;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class SpellChecker {

	public static void main(String[] args)   {
		
		
		try{
			
			FileReader library = new FileReader("ch_16/p16_9/dictionary");
			ArrayList<String> notWords = new ArrayList<String>();
			ArrayList<String> lib = new ArrayList<String>();
			
			Scanner in = new Scanner(library); 
			
			System.out.println(laterInAlphabet("arthur", "shim"));
			
			try{ 
				Scanner input = new Scanner(System.in);
				System.out.println("Enter file path");
				FileReader file = new FileReader(input.nextLine());
				input.close();
				
				while (in.hasNext())
					lib.add(in.next());
				
				in = new Scanner(file);
				while(in.hasNext())
				{
					String word = in.next();
				
					if (!wordFound(lib, word)) notWords.add(word);
				}
				
				for (String a : notWords)
					System.out.println(a);
			}
			finally
			{
				in.close();
			}
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File was not Found");
		}
	
	}
	
	public static boolean wordFound(ArrayList<String> libs, String word)
	{
		int min = 0, max = libs.size();
		word.toLowerCase();
		while (min < max)
		{
			int mid = (int)((min + max) / 2);
			
			String temp = libs.get(mid);
			temp.toLowerCase();
			
			if (temp.equals(word))
				return true;
			else if (laterInAlphabet(temp, word))
				max = mid - 1;
			else
				min = mid + 1;
		}
		return false;
	}
	
	/**
	 * Returns if word 1 is later in the alphabet than word 2
	 * @param word1 first word
	 * @param word2 second word
	 * @return true if word 1 is later in the alphabet than word 2
	 */
	public static boolean laterInAlphabet(String word1, String word2)
	{
		word1.toLowerCase();
		word2.toLowerCase();
		while (word1.length() > 0 && word2.length() > 0)
		{
			if (word1.charAt(0) == word2.charAt(0))
			{
				word1 = word1.substring(1,word1.length());
				word2 = word2.substring(1,word2.length());
			}
			else if (word1.charAt(0) > word2.charAt(0))
				return true;
			else
				return false;
		}
		return word1.length() != 0;
	}
}
