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
		public Object reduce(ReduceClosure_T<Object> f) {
			return null;
		}

		@Override
		Conslist_T<Object> append(Conslist_T<Object> a) {
			return a;
		}

		@Override
		public String toString() {
			return "";
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
	public Conslist_T<?> map(MapClosure_T<T, ?> f) {
		return map_i(f);
	}
	
	public Conslist_T<?> map_r(MapClosure_T<T,?> funct) {
		return new Cons_T(funct.lambda(head),tail.map(funct)); 
	}
	
	private  <U>Conslist_T<U> map_i(MapClosure_T<T,U> f) {
		Conslist_T<U> list = new Cons_T<U>(
				f.lambda(head),
				(Conslist_T<U>)Nil
				);
			Conslist_T<T> thisList = this.tail;
			Conslist_T<U> newList = list;
			Conslist_T<U> newtail = (Conslist_T<U>) Nil;
			while(thisList != Nil) {
				 newtail = new Cons_T<U>(f.lambda(((Cons_T<T>)thisList).head), (Conslist_T<U>)Nil);
				 ((Cons_T<U>)newList).tail = newtail; 
				 newList=newtail;
				 thisList=((Cons_T<T>)thisList).tail;
			}
			return list;
		
	}
	public Conslist_T<T> filter(FilterPredicate<T> p) {
		if(p.lambda(head)) {
			return new Cons_T<T>(head,tail.filter(p));
		}
		else {
			return tail.filter(p);
		}
	}
	
	public Conslist_T<T> filter_i(FilterPredicate<T> p){
		Conslist_T<T> thisList = this;
		Conslist_T<T> newList = (Conslist_T<T>) Nil;
		while(thisList != Nil) {
			if(p.lambda(((Cons_T<T>)thisList).head)) {
				newList = new Cons_T<T>(((Cons_T<T>)thisList).head,newList);
			}
			thisList = ((Cons_T<T>)thisList).tail; 
		}
		return newList.reverse();
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
	
	public Conslist_T<T> append(Conslist_T<T> a) {
	    return new Cons_T(head,tail.append(a)); 
	}

	
	@Override
	public String toString() {
	        return head + " " + tail.toString();
	   }
	

	public static void main(String[] args) {
		
		Conslist_T<Integer> b = Cons_T.lists(2,3,4,5,6,7,8,9,10);
		b.print();
		MapClosure_T<Integer,Integer> f = new MapClosure_T<Integer,Integer>() {public Integer lambda(Integer e) {return e*e;}};
		ReduceClosure_T<Integer> r = new ReduceClosure_T<Integer>() {public Integer lambda(Integer acc, Integer e) {return acc+e;}};
		FilterPredicate<Integer> ff=new FilterPredicate<Integer>() {public boolean lambda(Integer e) {return (e%2==0);}};
		System.out.println();
		Conslist_T<?> c = b.map(f);
		c.print();
		System.out.println(" ");
		System.out.println(b.reduce(r));
		Conslist_T<Integer> c11 =  ((Cons_T) b).filter_i(ff);
		c11.print();
		System.out.println("_____________________________\n");
		
		Conslist_T<String> b1 = Cons_T.lists("R","o","h","i","t","h");
		b1.print();
		MapClosure_T<String,String> f1 = new MapClosure_T<String,String>() {public String lambda(String e) {return e.toUpperCase();}};
		ReduceClosure_T<String> r1 = new ReduceClosure_T<String>() {public String lambda(String acc, String e) {return acc+e;}};
		System.out.println();
		Conslist_T<?> c1 = b1.map(f1);
		c1.print();
		System.out.println(" ");
		System.out.println(b1.reduce(r1));
		System.out.println("_______________________________\n");
		
		Conslist_T<Integer> R = Cons_T.lists(2,4,6,8,10);
		Conslist_T<Integer> O = Cons_T.lists(1,3,5,7,9);
		R.append(O).print();
		MapClosure_T<Integer,String> S = new MapClosure_T<Integer,String>() {public String lambda(Integer e) {return e.toString();}};
		R.map(S);
		System.out.println();
		System.out.println(R);
	}


	
	 
}

