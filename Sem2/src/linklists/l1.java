package linklists;

public class l1 {
	class Node{
		String name;
		double data;
		Node next;
		public Node(double a,String n) {
			name = n;
			data = a;
			next = null;
		}
		public Node(double a) {
			data = a;
			next = null;
		}
		public Node() {
			name = null;
			data=0;
			next=null;
		}
	}
		
	
	Node start = null;
	Node last = null;
	
	public void append(double a,String na) {
		String name = na;
		double data = a;
		if(start==null) {
		start=last= new Node();
		Node n = new Node(data,name);
		last.next=n;
		last = n;
		}
		else {
			Node n = new Node(a,name);
			last.next=n;
			last=n;	
		}

	}
	public void print() {
		for(Node p =start;p!=null;p=p.next) {
			System.out.println(p.data);
		}
	}

	public void insert(int a,Node pos) {
		Node i = new Node(a);
		for(Node p =start; p!=pos;p=p.next) {
			 p = new Node(p.data);
		}
		i.next=pos;
		for(Node p =pos; p==last;p=p.next) {
			 p = new Node(p.data);
		}
	}
	public void replace(int a,Node p) {
		p.data=a;
	}
	public void delete(Node pos) {
		for(Node p =start; p!=pos;p=p.next) {
			 p = new Node(p.data);
		}
		pos = pos.next;
		for(Node p =pos.next.next; p==last;p=p.next) {
			 p = new Node(p.data);
		}
	}
	

	
	public static void main(String[] args) {
		l1 n = new l1();
		n.append(2,"2");
		n.append(3,"3");
		n.append(4,"4");
		n.print();
		
		
	}
}
