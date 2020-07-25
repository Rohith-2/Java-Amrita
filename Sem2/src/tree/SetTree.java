package tree;

import java.util.*;


public class SetTree implements Set {
	public class Node {
		int data;
		Node l;
		Node r;

		public Node(int a) {
			data = a;
			l = r = null;
		}

		public boolean isLeaf() {
			return (r == null && l == null);
		}

	};

	int[] A = new int[100];
	int size = 0;
	Node root = null;

	public SetTree union(SetTree a) {
		for (int i = 0; i <= size; i++) {
			a.insert(A[i]);
		}
		return a;
	}

	private Node insertRecur(int e, Node r) {
		if (r == null) {
			r = new Node(e);
		} else {
			if (e == r.data) {
				return r;
			}
			if (e < r.data) {
				r.l = insertRecur(e, r.l);
			} else {
				r.r = insertRecur(e, r.r);

			}

		}
		return r;
	}

	public void insert(int e) {
		root = insertRecur(e, root);
	}

	public void delete(int key) {
		root = deleteRec(root, key);
	}

	private Node deleteRec(Node root, int key) {
		if (root == null) {
			return root;
		}

		if (key < root.data)
			root.l = deleteRec(root.l, key);
		else if (key > root.data)
			root.r = deleteRec(root.r, key);

		else {

			if (root.l == null)
				return root.r;
			else if (root.r == null)
				return root.l;
			root.data = minValue(root.r);
			root.r = deleteRec(root.r, root.data);
		}

		return root;
	}

	int minValue(Node root) {
		int minv = root.data;
		while (root.l != null) {
			minv = root.l.data;
			root = root.l;
		}
		return minv;
	}

	
	private Node preorderRecur(Node r) {
		if (r == null) {
			{}//System.out.print('-');
		} else {
			A[size++] = r.data;
			System.out.print(r.data+" ");
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

	public void BreadthFirstTraversal() {
		System.out.println("Breadth-First-Traversal:");
		Queue<Node> l = new LinkedList<Node>();
		l.add(root);
		while (!l.isEmpty()) {
			Node n = l.remove();
			System.out.print(n.data + " ");
			if (n.l != null) {
				l.add(n.l);
			}
			if (n.r != null) {
				l.add(n.r);
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		SetTree s = new SetTree();
		s.insert(10);s.insert(15);s.insert(5);
		s.insert(17);
		s.insert(3);
		s.insert(13);
		s.insert(7);
		s.insert(2);
		s.insert(4);
		s.insert(12);
		s.insert(14);
		s.insert(18);
		s.insert(10);
		s.preorder();
		SetTree s1 = new SetTree();
		s1.insert(10);
		s1.insert(15);
		s1.insert(5);
		s1.preorder();
		SetTree s11 = new SetTree();
		s11 = s1.union(s);
		s11.preorder();
		s11.BreadthFirstTraversal();

	}


}
