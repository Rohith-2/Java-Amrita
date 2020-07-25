package basicstream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Basic {
public static void main(String[] args) throws IOException{
	InputStream cin =System.in;
	InputStreamReader cr = new InputStreamReader(cin);
	BufferedReader in = new BufferedReader(cr);
	for(int i =0 ;i<3;i++) {
	String inputString = in.readLine();
	System.out.println("You typed: "+inputString);
	}
	in.close();
}
}
