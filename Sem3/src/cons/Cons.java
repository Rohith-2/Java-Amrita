package cons;

public class Cons extends Conslist {

	int head;
	Conslist tail;
	
	//Creating a Nil object extending ConsList
	public final static Conslist Nil = new Conslist() {

		@Override
		public int head() {
			throw new NullPointerException("Nil has no head");
		}

		@Override
		public Conslist tail() {
			return Nil; //return this;
		}

		@Override
		public Conslist reverse() {
			return null;
		}

		@Override
		public int reduce(ReduceClosure f) {
			return 0;
		}
	};
	
	public Cons(int head,Conslist tail) {
		this.head = head;
		this.tail = tail;
	}
	
	public static Conslist lists(int... lists) {
		//return new Cons(lists[0],make(1, lists));
		return make_tr(Nil, lists.length-1,lists);
	}
	/*
	private static Conslist make(int i,int...lists) {
		if(i>=lists.length) return Nil;
		else return new Cons(lists[i], make(++i, lists));
	}
	*/
	private static Conslist make_tr(Conslist a,int i,int...lists) {
		if(i<0) return a;
		else return make_tr(new Cons(lists[i],a),--i,lists);
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
	
	public Conslist map(MapClosure funct) {
		return new Cons(funct.lambda(head),tail.map(funct));
	}
	public int length() {
		return tail.length()+1;
	}
	
	public Conslist reverse() {
		return reverse(Nil,this);
	}
	
	private static Conslist reverse(Conslist acc,Conslist current) {
		if(current==Nil)return acc;
		else return reverse(new Cons(current.head(),acc),current.tail());

	}
	@Override
	public int reduce(ReduceClosure funct) {
		return reduce_tr(this.head(),this.tail(),funct);
	}
	 
	private int reduce_tr(int acc, Conslist c, ReduceClosure f) {
		if(c==Nil)return acc;
		else return reduce_tr(f.lambda(acc,c.head()),c.tail(), f);
	}
	

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		Conslist b = Cons.lists(2,3,4,5,6,7,8,9,10);
		b.print();
		MapClosure f = new MapClosure() {public int lambda (int e) {return e*e;}};
		ReduceClosure r = new ReduceClosure() {public int lambda(int acc, int e) {return acc+e;}};
		ReduceClosure r1 = new ReduceClosure() {
			public int lambda(int acc, int e) { 
				if(e % 2 == 0) return acc * e;
				else return (acc % 2 != 0) ? 1 : 0 ; 
		                // This is a ternary operator just like 'if(condition) then(?) else(:)'
			}
		};
		System.out.println();
		Conslist c = b.map(f);
		c.print();
		System.out.println(" ");
		System.out.println(b.reduce(r1));
		/*
		Conslist aa=b.reverse();
		aa.print();
		*/
		
	}

	
	 
}
