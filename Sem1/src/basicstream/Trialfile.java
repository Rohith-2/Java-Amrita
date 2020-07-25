package basicstream;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class Trialfile {
public static void main(String[] args) throws IOException{
	read();
}
public static void read() throws IOException {
	BufferedReader a = new BufferedReader(new FileReader("Trial.txt")) ;
	String text = a.readLine();
	while(text!=null) {
	System.out.println(text);
	 text = a.readLine();
	}
	a.close();
	
}
public static void write() throws FileNotFoundException {
	PrintStream a = new PrintStream(new FileOutputStream("Trial.txt"));
	a.println("AS");
	a.println("FGH");
	a.close();
}
}
