package queue;

import java.util.ArrayList;

public class Consumer implements Runnable{
	private ArrayList<String> dates = new ArrayList<String>();
	
	public void getDates(ArrayList<String> d)
	{
		for (String a : d)
			dates.add(a);
	}
	public void run() {
		for (int x = 0; x < 100; x ++)
			System.out.println(dates.remove(0));
	}

}
