package queue;

public class Tester {

	public static void main(String[] args) {
		Thread t = new Thread(new TestRunnable("hi"));
		Thread t2 = new Thread(new TestRunnable("h"));
		t2.start();
		t.start();
	}

}
