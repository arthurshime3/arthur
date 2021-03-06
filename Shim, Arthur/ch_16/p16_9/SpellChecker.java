package p16_9;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class SpellChecker {

	public static void main(String[] args)   {
		//ch_16/p16_9/words
		//ch_16/p16_9/test
		
		try{
			
			FileReader library = new FileReader("ch_16/p16_9/dictionary");
			ArrayList<String> notWords = new ArrayList<String>();
			ArrayList<String> lib = new ArrayList<String>();
			
			Scanner in = new Scanner(library); 
			
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
					word = word.toLowerCase();
					
					while (word.length() > 0 && (word.charAt(0) > 122 || word.charAt(0) < 97))
						word = word.substring(1);

					while (word.length() > 1 && (word.charAt(word.length() - 1 ) > 122 || word.charAt(word.length() - 1) < 97))
						word = word.substring(0, word.length() - 1);
			
					if (wordFound(lib, word) == -1) notWords.add(word);
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
	
	public static int wordFound(ArrayList<String> libs, String word)
	{
		int found = -1;
		int min = 0, max = libs.size();
		word = word.toLowerCase();
		while (min < max)
		{
			int mid = (int)((min + max) / 2);
			
			String temp = libs.get(mid);
			temp = temp.toLowerCase();
			
			if (temp.equals(word))
				return 0;
			else if (temp.compareTo(word) > 0)
				max = mid - 1;
			else
				min = mid + 1;
		}
		if (libs.get(min).equals(word))
			return 0;
		return found;
	}
	
	
}
