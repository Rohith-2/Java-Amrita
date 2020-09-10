package cons;
@SuppressWarnings({"unchecked","rawtypes","unused"})
public class Cons_T<T> extends Conslist_T<T> {

	T head;
	Conslist_T<T> tail;
	
	//Creating a Nil object extending ConsList
	public final static  Conslist_T<Object> Nil = new Conslist_T<Object>() {

		@Override
		public Object head() {
			throw new NullPointerException("Nil has no head");
		}

		@Override
		public Conslist_T<Object> tail() {
			return Nil; //return this;
		}

		@Override
		public Conslist_T<Object> reverse() {
			return null;
		}

		@Override
		public Object reduce(ReduceClosure_T<Object> f) {
			return 0;
		}
	};
	
	public Cons_T(T head,Conslist_T<T> tail) {
		this.head = head;
		this.tail = tail;
	}
	
	public static<T> Conslist_T<T> lists(T... lists) {
		//return new Cons(lists[0],make(1, lists));
		return make_tr((Conslist_T<T>)Nil, lists.length-1,lists);
	}
	
	private static<T> Conslist_T<T> make(int i,T...lists) {
		if(i>=lists.length) return (Conslist_T<T>) Nil;
		else return new Cons_T<T>(lists[i], make(++i, lists));
	}
	
	private static<T> Conslist_T<T> make_tr(Conslist_T<T> a,int i,T...lists) {
		if(i<0) return a;
		else return make_tr(new Cons_T<T>(lists[i],a),--i,lists);
	} 

	public T head() {
		return head;
	}

	public Conslist_T<T> tail() {
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
	
	public Conslist_T<?> map(MapClosure_T<T,?> funct) {
		return new Cons_T(funct.lambda(head),tail.map(funct);
	}
	public int length() {
		return tail.length()+1;
	}
	
	
	public Conslist_T<T> reverse() {
		return reverse((Conslist_T<T>)Nil,this);
	}
	
	private static<T> Conslist_T<T> reverse(Conslist_T<T> acc,Conslist_T<T> current) {
		if(current==Nil)return acc;
		else return reverse(new Cons_T<T>(current.head(),acc),current.tail());

	}
	
	public T reduce(ReduceClosure_T<T> funct) {
		return reduce_tr(this.head(),this.tail(),funct);
	}
	 
	private static<T> T reduce_tr(T acc, Conslist_T<T> c, ReduceClosure_T<T> f) {
		if(c==Nil)return acc;
		else return reduce_tr(f.lambda(acc,c.head()),c.tail(), f);
	}
	

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		Conslist_T<Integer> b = Cons_T.lists(2,3,4,5,6,7,8,9,10);
		b.print();
		MapClosure_T<Integer,Integer> f = new MapClosure_T<Integer,Integer>() {
		public Integer lambda(Integer e) {
			// TODO Auto-generated method stub
			return e*e;
		}};
		ReduceClosure_T<Integer> r = new ReduceClosure_T<Integer>() {

			@Override
			public Integer lambda(Integer acc, Integer e) {
				return acc+e;
			}
		};
	
		System.out.println();
		Conslist_T<?> c = b.map(f);
		c.print();
		System.out.println(" ");
		/*
		Conslist aa=b.reverse();
		aa.print();
		*/
		
	}


	
	 
}

