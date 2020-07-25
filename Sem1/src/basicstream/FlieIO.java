package basicstream;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
public class FlieIO {
	
	public static void main(String[] args) throws IOException {
		//write();
		read();                 // First it will be write and then read
	}
	public static void read() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("Test.txt"));
		String nextLine = br.readLine();
		
		while (nextLine!=null) {
			System.out.println(nextLine);   
			nextLine = br.readLine();
		}
		br.close();
	}
	
public static void write() throws FileNotFoundException {   //when the file is not available it throws file not found exception 
	PrintStream ps = new PrintStream(new FileOutputStream("Test.txt"));
	ps.println("Hey how ya doing?!");
	ps.println("I am Batman!");
	ps.close();
}
}
