package queue;

public class Cqueuelist implements Queue {
	public class Node {
		int data;
		Node next;
	};
	Node front,rear=null;
 
	public void enque(int i) {
		Node node = new Node(); 
		node.data = i;
		node.next = null;
		if (front == null) { 
			front =rear= node;
		}
		else {
			Node n = front;
			while (n.next != null) {  
				n = n.next;
			}
			n.next = node;
			rear=node;
		}
	}


	public void print() {
		Node node = front;
		while (node.next != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.println(node.data);
	}

	
	public int deque() {
		if(isEmpty()) {
			System.out.println("UnderFlow");
			return 0;
		}
		else {
		int temp = front.data;
		front = front.next;
		return temp;
	    }
	}

	public boolean isEmpty() {
			return front==null;
	}
	public static void main(String[] args) {
		 Cqueuelist s = new Cqueuelist();
		 s.enque(1);s.print();
		 s.enque(2);s.print();
		 s.enque(3);s.print();
		 s.enque(4);s.print();
		 s.enque(5);s.print();
	
		 System.out.println("Deleting: "+s.deque());
		 System.out.println("Deleting: "+s.deque());
		 System.out.println("Deleting: "+s.deque());
		 
		
		
	  }
}
