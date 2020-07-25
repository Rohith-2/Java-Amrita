package ass8;

import java.io.*;

public class A8 {
	public static void rewrite() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("ObjectPoetry.txt"));

		String[] s = new String[200];
		String nextLine = br.readLine();
		int i = 0;
		while (nextLine != null) {
			nextLine = br.readLine();
			s[i++] = nextLine;
		}
		s[1] = s[1].replace("But", "Baba");
		br.close();
		for (int h = 0; h < 11; h++)
			System.out.println(s[h]);
		PrintStream s1 = new PrintStream(new FileOutputStream("ButtoBaba.txt"));
		for (int r = 0; r < 11; r++) {
			s1.print(s[r]);
		}
		s1.close();

	}

	public static void main(String[] args) throws IOException {
		write();
		read();
		int lineno = 4;
		display(lineno);
		rewrite();

	}

	public static  void display(int f) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("ObjectPoetry.txt"));

		String s[] = new String[11];
		String nextLine = br.readLine();
		int i = 0;
		while (nextLine != null) {
			nextLine = br.readLine();
			s[i++] = nextLine;

		}
		br.close();
		int a = f + 1;
		System.out.println("The " + a + " st/th line is: " + s[f]);

	}

	public static  void read() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("ObjectPoetry.txt"));

		String s[] = new String[11];
		String nextLine = br.readLine();
		int i = 0;
		while (nextLine != null) {
			nextLine = br.readLine();
			s[i++] = nextLine;

		}
		br.close();

		for (int h = 0; h < s.length; h++)
			System.out.println(s[h]);

	}

	public static void write() throws FileNotFoundException {
		PrintStream ps = new PrintStream(new FileOutputStream("ObjectPoetry.txt"));
		ps.println("");
		ps.println("Objects are made to make things simple,");
		ps.println("But people find it harder to do the imple,");
		ps.println("Tougher it is to deliver it to a crowd with the structured cripple,");
		ps.println("Since they keep asking 'How to map one to a Maple?");
		ps.println("Most of Nature's beauty that's outside, ");
		ps.println("Will be felt in this dimension; computer's inside,");
		ps.println("With software where Objects play side by side");
		ps.println("With precision that even atoms can't abide");
		ps.println("I wonder why people don't see,");
		ps.println("The intuitive logic that comes naturally");
		ps.close();
	}
}
