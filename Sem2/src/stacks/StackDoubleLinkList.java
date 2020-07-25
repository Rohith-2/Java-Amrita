package stacks;


public class StackDoubleLinkList implements Stacks {
	public class Node {
		int data;
		Node next;
		Node prev;
		public Node(int a) {
			data=a;
			next=null;
			last=null;
		}
	};
	Node start=null;
	Node last=null;
	int size=0;
	
	public void push(int d) {
		Node a = new Node(d);
		if (start==null) {
			start=last=a;
			size++;
		}
		else {
			Node s = start;
			while(s.next!=null) {
				s=s.next;
			}
			last=s.next=a;
			a.prev=s;
			size++;
		}
	}
	public void print() {
		Node node = start;

		while (node.next != last.next) {
			System.out.println(node.data);
			node = node.next;
		}
		System.out.println(node.data);
		System.out.println(" ");
	}
	
	
		public int pop() {
			int t = 0;
			if(start==last) {
				System.out.println("Underflow");
			}
			else {
				t=last.data;
				last=last.prev;
				
			}
			size--;
			return t;
		}
		public static void main(String[] args) {
			StackDoubleLinkList s = new StackDoubleLinkList ();
			s.push(1);
			s.push(2);
			s.push(3);
			s.print();
			s.pop();
			s.print();
		}


}
