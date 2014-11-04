package queue;

import java.sql.Date;
import java.util.ArrayList;

public class Provider implements Runnable
{
	private ArrayList<String> dates = new ArrayList<String>();

	public void run() {
		for (int x = 0; x < 100; x ++)
			dates.add(new Date(0).toString());
	}
	
	
}
