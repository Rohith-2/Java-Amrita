package t8;

public class StringBuilder implements Runnable {
	int f;
	int t;
	static String concat = "";
	private Object monitor = new Object();

	public StringBuilder(int a, int b) {
		f = a;
		t = b;

	}

	public void run() {
		synchronized (monitor) {
			for (int i1 = f; i1 < t; i1++) {
				concat += i1 + "+";
			}
			System.out.print(concat);
			monitor.notify();
		}

	}

	public static void main(String[] args) {
		Runnable r  = new StringBuilder(101, 110);
		Runnable r1 = new StringBuilder(110, 120);
		Runnable r2 = new StringBuilder(120, 130);
		Runnable r3 = new StringBuilder(130, 140);
		Runnable r4 = new StringBuilder(140, 150);
		r.run();
		r1.run();
		r2.run();
		r3.run();
		r4.run();
	}
}
