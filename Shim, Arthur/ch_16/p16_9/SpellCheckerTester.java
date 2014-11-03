package p16_9;

import java.util.ArrayList;

public class SpellCheckerTester {

	public static void main(String[] args) {
		ArrayList<String> a = new ArrayList<String>();
		a.add("a");
		a.add("b");
		a.add("c");
		a.add("d");
		a.add("e");
		a.add("f");
		a.add("g");
		a.add("h");
		
		System.out.println(wordFound(a, "d"));
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
