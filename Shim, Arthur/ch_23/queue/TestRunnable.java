package queue;

public class TestRunnable implements Runnable{
	private String s;
	
	public TestRunnable(String s)
	{
		this.s = s;
	}
	public void run() {
		for (int x = 0; x < 100; x ++)
		{
			System.out.println(s);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				System.out.println("uh oh");
			}
		}
	}

}
