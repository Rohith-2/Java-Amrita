package hash;

public class HashTable {
	
	class Data {
		int key;
		String value;
		
		public Data(String v){
			key=v.hashCode();
			value=v;
		}
		
		public boolean equals(Data that) {
			return (this.key==that.key);
		}
		
	};
	
	class Node{
		Data data;
		Node next,prev;
		
		public Node(Data d) {
			data = d;
			next=prev=null;
		}
	};
	
	Node[] map;
	
	public HashTable(int size) {
		map=new Node[size];
	}
	
	public int hash(Data n) {
		return n.hashCode() % map.length;
	}
	
	public void put(String v) {
		Data d = new Data (v);
		int h = hash(d);
		Node n = new Node(d);
		
		if (map[h]==null)
			map[h]=n;
		else {
			Node ptr = map[h];
			for(;ptr.next!=null;ptr=ptr.next); 
			ptr.next = n;
			n.prev=ptr;
		}
	}
	public String get(String v) {
		int k = v.hashCode();
		int h = v.hashCode() % map.length;
		
		Node ptr = map[h];
		while(ptr!=null && ptr.data.key!=k) {
			ptr = ptr.next;
		}
		return (ptr==null) ? null:ptr.data.value; //else is a colon,? is a then
	}
	
	public String[] getAll(String v) {
		int k = v.hashCode() & 0x7FFFFFFF;
		int h = k%map.length;
		String vals="";
		String delim = ",";
		Node ptr = map[h];
		while(ptr!=null) {
			if(ptr.data.key==k) vals=ptr.data.value+delim+vals;
			ptr = ptr.next;
		}
		return vals.split(delim); //else is a colon,? is a then
	}
	
	public static void main(String[] args) {
		HashTable h = new HashTable(10);
		h.put("12");
		h.put("Eight");
		h.put("Twelve");
		h.put("Hix");
		h.put("tone");
		h.put("One_two");
		String[]A=h.getAll("12");
		for(int i=0;i<A.length;i++) System.out.println(A[i]);
		
	}
}
