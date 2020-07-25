package linklists;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Stringlist {
	class Node {
		String data;
		Node next;
		int pos;
		String time;

		public Node(String a) {
			data = a;
			next = null;
			pos = 0;
		}
	};

	Node start = null;
	Node last = null;
	int size = 0;
	int pos = 0;

	public void append(String n) {
		Node a = new Node(n);
		if (start == null) {
			start = a;
			size++;
			this.pos = 1;
		} else {
			Node s = start;
			while (s.next != null) {
				s = s.next;
			}
			s.next = a;
			size++;
			this.pos = size;
		}
	}

	public void print() {
		for (Node p = start; p != null; p = p.next) {
			System.out.println(p.data);
		}
	}

	public void search(String a) {
		for (Node p = start; p != null; p = p.next) {
			if (p.data.contains(a)) {
				System.out.println(p.data);
				// System.out.println(p.pos);
			}
		}
	}

	public void TimeExtraction() throws IOException {
		String[] str = new String[1000000];
		int[] str1 = new int[1000000];
		for (Node p = start; p != null; p = p.next) {
			p.time = (p.data.substring(9, 11)) + p.data.substring(12, 14) + p.data.substring(15, 17);
			int result = Integer.parseInt(p.time);
			BufferedReader br = new BufferedReader(new FileReader("/Users/rohith/Downloads/logsample.txt"));
			String nextLine = br.readLine();
			while (nextLine != null) {
				for (int x = 0; x < str.length; x++) {
					str[result] = nextLine;
					str1[x] = result;
					nextLine = br.readLine();

				}

			}
			br.close();
		}

		Arrays.sort(str1);
		for (int x1 = 0; x1 < str.length; x1++) {
			if (str[str1[x1]] != null) {
				System.out.println(str[str1[x1]]);
			}
		}

	}
	// CB.EN.U4AIE19052

	public static void main(String[] args) throws IOException {
		Stringlist n = new Stringlist();
		BufferedReader br = new BufferedReader(new FileReader("/Users/rohith/Downloads/logsample.txt"));
		String nextLine = br.readLine();
		while (nextLine != null) {
			n.append(nextLine);
			nextLine = br.readLine();
		}
		br.close();
		n.print();
		System.out.println("INFO");
		n.search("INFO");
		System.out.println(" ");
		System.out.println("WARN");
		n.search("WARN");
		System.out.println(" ");
		System.out.println("ERROR");
		n.search("ERROR");
		System.out.println(" ");
		n.TimeExtraction();
	}

}
