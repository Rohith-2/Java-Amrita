package consset;

public class NonEmpty extends Set {

	int key;
	Set left;
	Set right;
	
	static Set Empty = new Set() {

		@Override
		public boolean has(int key) {return false;}

		@Override
		public Set add(int key) {return new NonEmpty(this, key, this);}
		
		@Override
		public String toString() {
			return "";
		}
		
	};
	
	public NonEmpty(Set l,int k, Set r) {
		key=k;
		left=l;
		right=r;
	}
	
	@Override
	public boolean has(int k) {
		if(k<key) return left.has(k);
		else if(k>key) return right.has(k);
		return true;
	}

	@Override
	public Set add(int k) {
		if(k<key) return new NonEmpty(left.add(k), key, right);
		else if(k>key) return new NonEmpty(left, key, right.add(k));;
		return this;
	}
	
	@Override
	public String toString() {
		return '('+left.toString() + "," + key + "," + right.toString()+')';
		
	}
	
	public static void main(String[] args) {
		Set s = new NonEmpty(Empty, 5, Empty);
		System.out.println(s);
		Set s1 = s.add(3);
		System.out.println(s1);
		Set s2 = s1.add(7);
		System.out.println(s2);
		Set s3 = s2.add(2);
		System.out.println(s3);
		Set s4 = s3.add(4);
		System.out.println(s4);
		Set s5 = s4.add(6);
		System.out.println(s5);
		Set s6 = s5.add(8);
		System.out.println(s6);
		Set s7 = s6.add(1);
		System.out.println(s7);	
	}
	
}
