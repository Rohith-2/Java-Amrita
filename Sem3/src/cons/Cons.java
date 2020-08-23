package cons;

public class Cons extends Conslist {

	int head;
	Conslist tail;
	
	//Creating a Nil object extending ConsList
	public  final static Conslist Nil = new Conslist() {

		@Override
		public int head() {
			throw new NullPointerException("Nil has no head");
		}

		@Override
		public Conslist tail() {
			return Nil;
		}
		
	};
	
	public Cons(int head,Conslist tail) {
		this.head = head;
		this.tail = tail;
	}
	
	public static Conslist lists(int... lists) {
		return new Cons(lists[0],make(1, lists));
	}
	
	private static Conslist make(int i,int...lists) {
		if(i>=lists.length) return Nil;
		else return new Cons(lists[i], make(++i, lists));
	}

	public int head() {
		return head;
	}

	public Conslist tail() {
		return tail;
	}
	
	@Override
	public boolean isEmpty() {
		return false;
	}
	
	@Override
	public void print() {
		System.out.print(head+" ");
		//Tail is also a conslist so it keeps recursive.
		tail.print();
	}
	public static void main(String[] args) {
		Cons a = new Cons(4,new Cons(3,new Cons(2,new Cons(1,Nil))));
		a.print();
		System.out.println(" ");
		Conslist b = Cons.lists(1,2,3,4,5,6,7,8,9,10);
		b.print();
	}
	 
}
