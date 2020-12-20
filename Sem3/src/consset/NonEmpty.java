package consset;

@SuppressWarnings({"unchecked","rawtypes"})
public class NonEmpty<T extends Comparable<T>> extends ConsSet<T> {

	T key;
	ConsSet<T> left;
	ConsSet<T> right;
	
	static ConsSet<Comparable<Object>> Empty = new ConsSet<Comparable<Object>>() {

		@Override
		public boolean has(Comparable<Object> key) {return false;}

		
		@Override
		public ConsSet add(Comparable<Object> key) {return new NonEmpty(this, key, this);}
		
		@Override
		public String toString() {
			return "";
		}
		
	};
	
	public ConsSet<T> getEmpty() {
		return (ConsSet<T>) Empty;
	}
	
	public NonEmpty(T key2) {
		key=key2;
		left=getEmpty();
		right=getEmpty();
	}
	
	public NonEmpty(ConsSet<T> l,T key2, ConsSet<T> r) {
		key=key2;
		left=l;
		right=r;
	}
	
	@Override
	public boolean has(T k) {
		if(k.compareTo(key) < 0) return left.has(k);
		else if(k.compareTo(key) > 0) return right.has(k);
		return true;
	}

	@Override
	public ConsSet<T> add(T k) {
		if(k.compareTo(key) < 0) return new NonEmpty<T>(left.add(k), key, right);
		else if(k.compareTo(key) > 0) return new NonEmpty<T>(left, key, right.add(k));
		return this;
	}
	
	@Override
	public String toString() {
		return '('+left.toString() + "," + key + "," + right.toString()+')';
		
	}
	
	public static void main(String[] args) {
		ConsSet s = new NonEmpty(5);
		System.out.println(s);
		ConsSet s1 = s.add(3);
		System.out.println(s1);
		ConsSet s2 = s1.add(7);
		System.out.println(s2);
		ConsSet s3 = s2.add(2);
		System.out.println(s3);
		ConsSet s4 = s3.add(4);
		System.out.println(s4);
		ConsSet s5 = s4.add(6);
		System.out.println(s5);
		ConsSet s6 = s5.add(8);
		System.out.println(s6);
		ConsSet s7 = s6.add(1);
		System.out.println(s7);	
	}
	
}
