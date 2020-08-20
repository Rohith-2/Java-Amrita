package cons;

public class Cons extends Conslist {

	int head;
	Conslist tail;
	
	//Craeting a Nil object extending ConsList
	public static Conslist Nil = new Conslist() {

		@Override
		public int head() {
			throw new NullPointerException("Nil has no head");
		}

		@Override
		public Conslist tail() {
			return this;
		}
		
	};
	
	public Cons(int head,Conslist tail) {
		this.head = head;
		this.tail = tail;
	}

	public int head() {
		return head;
	}

	public Conslist tail() {
		return tail;
	}
	
	public boolean isEmpty() {
		return false;
	}
	 
}
