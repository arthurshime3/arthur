package queue;

import java.util.concurrent.locks.Condition;

public class Queue {
	private Provider p = new Provider();
	private Consumer c = new Consumer();
	private Condition empty, full;
	
	private long sleepTime = 1;
	
	public synchronized void add() throws InterruptedException
	{
		System.out.println("Adding");
		p.run();
		Thread.sleep(sleepTime);
	}
	
	public synchronized void remove() throws InterruptedException
	{
		System.out.println("Removing");
		c.run();
		Thread.sleep(sleepTime);
	}

}
