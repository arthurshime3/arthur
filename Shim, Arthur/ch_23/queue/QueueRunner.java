package queue;

public class QueueRunner {
	
	public static void main(String[] args)
	{
		Provider p = new Provider();
		Consumer c = new Consumer();
		//Queue q = new Queue();
		
		Thread t1 = new Thread(p);
		Thread t2 = new Thread(c);
		
		t1.start();
		t2.start();
	}
}
