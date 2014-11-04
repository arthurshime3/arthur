package queue;

import java.util.ArrayList;

public class Consumer implements Runnable{
	private ArrayList<String> dates;
	
	public void getDates(ArrayList<String> d)
	{
		for (String a : d)
			dates.add(a);
	}
	public void run() {
		if (dates.size() > 0)
			System.out.println(dates.remove(0));
	}

}
