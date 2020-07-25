package mathfunc;

public class Pi implements Runnable {

	int rank;
	static int size = 0;

public static class Thr implements Runnable {
	int f;
	int t;

	public Thr(int a, int b) {
		f = a;
		t = b;

	}

	public void run() {
		String concat = "";
		synchronized (concat) {
			for (int i1 = f; i1 < t; i1++) {
				concat += i1 + "+";
			}
			System.out.print(concat);
		}

	}


public static void main(String[] args) {
		Runnable r = new Thr(101, 110);
		Runnable r1 = new Thr(111, 120);
		Runnable r2 = new Thr(121, 130);
		Runnable r3 = new Thr(131, 140);
		Runnable r4 = new Thr(141, 150);
		r.run();
		r1.run();
		r2.run();
		r3.run();
		r4.run();
	}
}

	double dx;
	private static Object monitor = new Object();

	static double pi = 0;

	public Pi(int pres) {
		rank = size++;
		dx = java.lang.Math.pow(10, pres * -1);
	}

	@Override
	public void run() {

		double sum = 0;
		double L = (double) rank / (double) size;
		double U = (double) (rank + 1) / (double) size;

		for (double x = L + dx; x <= U; x += dx) {

			sum = sum + 1.0 / (1.0 + x * x);
		}
		synchronized (monitor) {
			pi = pi + sum * dx * 4;
			monitor.notify();
		}
	}

	public void start() {

		Thread container = new Thread(this);
		container.start();
	}

	public static void compute(int pres, int numThreads) {

		Pi[] arraythrreads = new Pi[numThreads];

		for (int t = 0; t < arraythrreads.length; t++) {

			arraythrreads[t] = new Pi(pres);

		}

		for (int s = 0; s < arraythrreads.length; s++) {
			arraythrreads[s].start();

		}

	}

	public static void main(String args[]) throws InterruptedException {

		Pi.compute(11, 10);
		int i = 0;

		while (i < 100) {
			System.out.println(Pi.pi);
			Thread.sleep(100);
		}

	}

}
