package Thread;

public class RunnableThread implements Runnable {

	public RunnableThread(String n) {
		super();
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("1r" + i);

		}
	}

	public static void main(String[] args) {
		Runnable r = new RunnableThread("1r");
		Thread t = new Thread("r1");
		System.out.println("Invoking Thread");
		t.run();
		r.run();
		System.out.println("Back to main..");
	}
}

