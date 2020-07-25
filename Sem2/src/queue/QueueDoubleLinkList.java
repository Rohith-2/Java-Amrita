package queue;


public class QueueDoubleLinkList implements Queue{
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
	public void enque(int d) {
		Node a = new Node(d);
		if (isEmpty()) {
			start=last=a;
			size++;
		}
		else {
			Node s = start;
			while(s.next!=null) {
				s=s.next;
			}
			s.next=a;
			a.prev=s;
			size++;
		}
	}
	public void print() {
		Node node = start;

		while (node.next != null) {
			System.out.println(node.data);
			node = node.next;
		}
		System.out.println(node.data);
	}
	

		public int deque() {
			if(isEmpty()) {
				System.out.println("Undeflow");
			}
			int t=start.data;
			start=start.next;
			return t;
		}

	public boolean isEmpty() {
		return start==last;
	}

	public static void main(String[] args) {
		QueueDoubleLinkList s = new QueueDoubleLinkList();
		 s.enque(1);
		 s.enque(2);
		 s.enque(3);
		 s.enque(4);
		 s.enque(5);
		 s.print();
	
		 System.out.println("Deleting: "+s.deque());
		 System.out.println("Deleting: "+s.deque());
		 System.out.println("Deleting: "+s.deque());
		 s.print();
		
		
	  }

}
