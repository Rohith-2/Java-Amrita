package end_proj;

import java.io.*;
/*
 * This BST will store the results of the Huffman Compression for iterating and Encoding..
 */
public class BSTNode {
	class BNode {
		String value;
		int key;
		BNode left;
		BNode right;

		public BNode(String f, int c) {
			key = c;
			value = f;
		}

	};

	BNode root = null;

	public BNode insert(char key, String value) {
		Character c1 = Character.valueOf(key);
		int k = c1.hashCode();
		return root = insertReccursion(root, k, value);
	}

	private BNode insertReccursion(BNode root, int key, String value) {
		if (root == null) {
			root = new BNode(value, key);
			return root;
		}
		if (key < root.key)
			root.left = insertReccursion(root.left, key, value);
		else
			root.right = insertReccursion(root.right, key, value);
		return root;
	}

	private String searchRec(BNode root, char c) {
		Character c1 = Character.valueOf(c);
		int key = c1.hashCode();
		while (root != null) {
			if (key > root.key)
				root = root.right;
			else if (key < root.key)
				root = root.left;
			else {
				return root.value;
			}
		}
		return null;
	}
	public String search(char c) {
		return searchRec(root,c);
	}
	
			/*
			 *  The encode funtion will use the initial created char[] and a output file location
			 *  Using the BST we call the search function to search for the char in the BST and write the huffman code to a new-file.
			 */

	public void encode(char[] c, String f) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(f));
		for (int i = 0; i < c.length; i++) {
			String v = search(c[i]);
			if (v != null){
				writer.write(v);
				
			}
		}
		writer.close();

	}
}