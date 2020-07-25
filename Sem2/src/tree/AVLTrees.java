package tree;

public class AVLTrees {
	// Node Structure for the Binary Search Tree ... 
	class TNode {
		int data, height;
		TNode right, left;
		
		public TNode(int e) {
			data = e;
			height = 1;
			right = left = null;
		}
		
		public boolean isLeaf() {
			return (right == null && left == null);
		}
		
	};
	
	TNode root = null;
	
	// returns the height of a Tree Node ...
	public int height(TNode n) {
		if( n == null)
			return 0;
		
		return n.height; 
	}
	
	public int max (int x, int y) {
		return (x > y) ?x : y;  //Ternary Operator
	}
	
	// return the balance state of a node ...
	public int getbalance(TNode n) {
		if (n == null)
			return 0;
		
		return height(n.left) - height(n.right);
	}
	
	// Right Rotate ...
	public TNode rightRotate (TNode z) {
		TNode y = z.left;
		TNode T3 = y.right;
		
		// Performing Right Rotation ...
		z.left = T3;
		y.right = z;
		
		// Updating heights
		z.height = 1 + max(height(z.left), height(z.right));
		y.height = 1 + max(height(y.left), height(y.right));
		
		return y;
		
	}
	
	// Left Rotate ...
	public TNode leftRotate (TNode z) {
		TNode y = z.right;
		TNode T2 = y.left;
		
		// Performing Left Rotation ...
		z.right = T2;
		y.left = z;
		
		// Updating heights
		z.height = 1 + max(height(z.left), height(z.right));
		y.height = 1 + max(height(y.left), height(y.right));
		
		return y;
		
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	// Insert into BST
	private TNode insert_rec(int e, TNode r) {
		// returning a new node with the data ...
		if(r==null) return (new TNode(e) ) ;
		
		else {
			if(e < r.data) 
				r.left = insert_rec(e,r.left);
			else if( e > r.data) 
				r.right = insert_rec(e, r.right);	
			else 
				return r;
			
			// Update height of current node...
			// This node is compromised by an insertion ...
			r.height = 1+ max(height(r.left), height(r.right));
			
			// Check is the node is in balance ...
			// that is ... the height difference between the left and right is 1
			int balance = getbalance(r);
			
			// Left Left case ... 
			if(balance > 1 && e < r.left.data)
				return rightRotate(r);
			
			// Right Right case ...
			if(balance < -1 && e > r.right.data) 
				return leftRotate(r);
			
			// Left Right case ...
			if(balance > 1 && e > r.left.data) {
				r.left = leftRotate(r.left);
				return rightRotate(r);
			}
			
			// Left Right case ...
			if(balance > 1 && e > r.left.data) {
				r.right = rightRotate(r.right);
				return leftRotate(r);
			}
			return r;
		
		}
		
	}
	
	public void insert(int e) {
		root = insert_rec(e,root);
	}
	
	// Recursive insert and balance for AVL Tree ...
	private void inorder_rec(TNode r) {
		if (r == null) System.out.print('-'); 
		else {
				System.out.print(" (");
			inorder_rec(r.left);
				System.out.print(r.data+" ");
			inorder_rec(r.right);
				System.out.print(") ");
		}
	}
	
	public void inorder() {
		inorder_rec(root);
		System.out.println();
	}
	
	private void preorder_rec(TNode r) {
		if (r == null) { }
		else {
				System.out.print(r.data+" ");
			preorder_rec(r.left);
			preorder_rec(r.right);	
		}
	}
	
	public void preorder() {
		preorder_rec(root);
		System.out.println();
	}
	
	public TNode delete_rec(int key, TNode r) {
		// When the deletion key is not found
		if(r == null) return r;
		else {
			if(key < r.data)
				r.left  = delete_rec(key,r.left);
			else if(key > r.data) 
				r.right  = delete_rec(key,r.right);
			else {
				if(r.left == null) 
					return r.right;
				else if (r.right == null)
					return r.left;
				
				r.data = minRValue(r.right);
				r.right = delete_rec(r.data,r.right);
			}
		}
			r.height = 1+max(height(r.left),height(r.right));
			int balance = getbalance(r);
			
			//Left-Left 
			if(balance>1 && getbalance(r.left)>=0)
				return rightRotate(r);
			
			//Left Right 
			if (balance >1 && getbalance(r.right)<0) {
				r.left = leftRotate(r.left);
				return rightRotate(r);
			}
			
			//Right-Right
			if(balance<-1 && getbalance(r.right)<=0)
				return leftRotate(r);
			
			//Right Left
			if (balance < -1 && getbalance(r.left)>0) {
				r.right = rightRotate(r.left);
				return leftRotate(r);
			}
			
			return r;
		}
	
	private int minRValue(TNode r) {
		
		while(r.left !=null) r = r.left;
		
		return r.data;
	}
	
	public void delete(int key) {
		root = delete_rec(key,root);
	}
	
	public static void main(String [] args) {
		//BST tree = new BST();
		AVLTrees tree = new AVLTrees();
		
		
		tree.insert(1);  tree.inorder();
		tree.insert(2);  tree.inorder();
		tree.insert(3);  tree.inorder();
		tree.insert(4);  tree.inorder();
		tree.insert(5);  tree.inorder();
		tree.insert(6);  tree.inorder();
		tree.insert(7);  tree.inorder();
		tree.insert(8);  tree.inorder();
		tree.insert(9);  tree.inorder();
		tree.insert(10);  tree.inorder();
		tree.insert(11);  tree.inorder();
		tree.insert(12);  tree.inorder();
		tree.insert(13);  tree.inorder();
		
		tree.delete(10); tree.inorder();
		tree.delete(15); tree.inorder();
		tree.delete(5); tree.inorder();
	}
	
}