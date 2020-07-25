package end_proj;
import java.io.*;

import end_proj.HuffmanMaxHeap.Node;

public class Decode {
	/*
	 * We load the encoded file using the MaxHeap (BST) we will traverse left if the char is 0 and right is the char is 1.
	 * When we rech the root leaf we will print the char in the node.
	 */
        String Out;
        //The read function will read the encoded file and store it as a String 
    	public String read(String loc) throws IOException {
    		String a="";
    		BufferedReader br = new BufferedReader(new FileReader(loc));
    		String nextLine = br.readLine();
    		
    		while (nextLine!=null) {
    			a+=nextLine;   
    			nextLine = br.readLine();
    		}
    		br.close();
    		return a;
    	}
    	
    	public void write(String loc) throws FileNotFoundException {   //when the file is not available it throws file not found exception 
    		PrintStream ps = new PrintStream(new FileOutputStream(loc));
    		ps.println(Out);
    		ps.close();
    	}
    	
    	
    
    /*
     * We load the encoded String in the decode and Use the MaxHeap created in the encoding process..
     * We traverse right if 1 and left if 0
     * The output will be a String which will be stored in a global variable.	
     */

    
	public void decode(String S,HuffmanMaxHeap.Node[] heap) {
		HuffmanMaxHeap.Node current = heap[0];
		String o ="";
		
	    while (!S.isEmpty()){
	    if (S.charAt(0) == '1'){
	    	current = current.right;
	    	S = S.substring(1);
	    }
	    else {
	    	current = current.left;
	    	S = S.substring(1);
	    }
	    if (current.left == null && current.right == null){
	    	o+=current.chr;
	  		current = heap[0];
	  	}
	  }
	     Out=o;
	}
 
    // We call the above functions ..
    public void decodeFile(Node[] a,String e) throws IOException {
    	 decode(read("/Users/rohith/Desktop/proj_output/"+e+"_Encoded.txt"),a);
 	     write("/Users/rohith/Desktop/proj_output/"+e+"_Decoded.txt");
    }
    
    public void decodeFile_1(String e,Node_D c) throws IOException {
   	 	 decode_1(read("/Users/rohith/Desktop/proj_output/"+e+"_Encoded.txt"),c);
	     write("/Users/rohith/Desktop/proj_output/"+e+"_Decoded_1.txt");
   }
    
 //Test Functions Under Development: ---------------------------------------------------------------------------------------
    
    class Node_D {
		double frq;
		char chr;
		Node_D left;
		Node_D right;

		public Node_D(double f, char string) {
			frq = f;
			chr = string;
			left = right = null;
		}
	};
	
	Node_D root_1 =new Node_D(0,'~');
	public Node_D read_tree(BufferedReader br) throws IOException {
		int a = br.read();
		
	    if ((char)a=='0') {
	        root_1 = new Node_D(0,(char)br.read());
	        System.out.println(root_1.chr);
	        }
	    
	    else if((char)a == '1') {
	    	root_1 = new Node_D(0,'~');
	        root_1.left = read_tree(br);
	        root_1.right = read_tree(br);
	        
	        }
	
		return root_1;
	    }
	
	public void decode_1(String S,Node_D root) {
			String o ="";
			Node_D current=root;
		    while (!S.isEmpty()){
		    if (S.charAt(0) == '1'){
		    	current = current.right;
		    	S = S.substring(1);
		    }
		    else {
		    	current = current.left;
		    	S = S.substring(1);
		    }
		    if (current.left == null && current.right == null){
		    	o+=current.chr;
		  		current = root;
		  	}
		  }
		     Out=o;
	}

//---------------------------------------------------------------------------------------- : Test Functions Under Development

	public static void main(String[] args) throws IOException {
		Read n = new Read(0);
	    long startTime = System.currentTimeMillis();
		String l = "/Users/rohith/Desktop/proj_output/Case1.txt";
		System.out.println("Huffman Codes : ");
	    HuffmanMaxHeap.Node[] a = n.Encode(l); 
	    String o = n.write_tree(a[0]);
	    System.out.println(("Runtime for Encoding : " + (System.currentTimeMillis() - startTime)+ " ms"));
	    long startTime_1 = System.currentTimeMillis();
	    System.out.println(o);
	    Decode f = new Decode();
	    f.decodeFile(a,n.loc());   
	    System.out.println(("Runtime for Decoding : " + (System.currentTimeMillis() - startTime_1)+ " ms"));
	    
	    /*  -------Test-Functions-Under-Development----
	    BufferedReader br = new BufferedReader(new FileReader("/Users/rohith/Desktop/proj_output/key.txt"));
	    f.decodeFile_1(n.loc(),f.read_tree(br));
	    */
	    
	    

	}
}