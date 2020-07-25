package tree;

import java.util.*;

public class BST_2{
	
	public class Node {
		int frq;
		String chr;
		String key;
		Node l;
		Node r;

		public Node(int a,String b) {
			frq = a;
			chr = b;
			l = r = null;
		}

		public boolean isLeaf() {
			return (r == null && l == null);
		}

	};

	Node root = null;

	public boolean isEmpty() {
		return (root == null);
	}

	private Node insertRecur(String a,int e, Node r) {
		if (r == null) {
			r = new Node(e,a);
		} 
		else {
			if (e < r.frq) {
				r.l = insertRecur(a,e, r.l);
			} else {
				r.r = insertRecur(a,e, r.r);

			}

		}
		return r;
	}

	public void insert(String a,int e) {
		root = insertRecur(a,e, root);
	}

	private Node preorderRecur(Node r) {
		if (r == null) {
			{}//System.out.print('-');
		} else {
			System.out.print(r.frq+":"+r.chr+ " ");
			preorderRecur(r.l);
			preorderRecur(r.r);
		}
		return r;
	}

	public void preorder() {
		System.out.println("Preorder:");
		preorderRecur(root);
		System.out.println();
	}
	
	private Node inorderRecur(Node r) {
		if (r == null) {
			{}//System.out.print('-');
		} else {
			
			inorderRecur(r.l);
			System.out.print(r.chr+":"+r.frq+" ");
			inorderRecur(r.r);
			
		}
		return r;
	}

	public void inorder() {
		System.out.println("Inorder:");
		inorderRecur(root);
		System.out.println();
	}
	
    public void BreadthFirstTraversal() {
    	Queue <Node> l = new LinkedList<Node>();
    	l.add(root);
    	while(!l.isEmpty()) {
    		Node n=l.remove();
    		System.out.print(n.frq+":"+n.chr+ " ");
    		if(n.l!=null) {
    			l.add(n.l);
    		}
    	    if(n.r!=null){
    			l.add(n.r);
    		}
    	}
    	System.out.println();
		
    	}
	  
	    
	  
	    

	public static void main(String[] args) {
		BST_2 s = new BST_2();
		s.insert("a",45);
		s.insert("b",67);
		s.insert("c",30);
		s.insert("d",17);
		s.insert("r", 6);
		s.preorder();
		s.inorder();
		System.out.println("a".hashCode());
		System.out.println("b".hashCode());


	}
}