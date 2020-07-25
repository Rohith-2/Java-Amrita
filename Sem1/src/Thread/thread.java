package Thread;

public class thread {

	public class BasicThread extends Thread {
		String name;

		public BasicThread(String a) {
			name = a;
		}

		public void run() {
			for (int i = 0; i < 1000; i++)
				System.out.println(name + i);
			try {
				Thread.sleep(5000);
			} catch (Exception e) {
			}
		}

		public void main(String[] args) {
			BasicThread t  = new BasicThread("1-T");
			BasicThread t1 = new BasicThread("2-T");
			BasicThread t2 = new BasicThread("3-T");
			System.out.println("Invoking thread..");
			t.start();
			t1.start();
			t2.start();
			System.out.println("Back to main..");
			for (int i = 0; i < 500; i++)
				System.out.println("Main " + i);

		}

	}
}
