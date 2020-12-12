package prroj;


public class KVPair<K extends Comparable<K>,V> {
	K key;
	V value;
	public KVPair(K key_1,V value_1) {
		this.key = key_1;
		this.value = value_1;

	}
	public K key() {
		return key;
	}
	public V value() {
		return value;
	}
	@Override
	public String toString() {
	        return key + ":" + value;
	   }
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Conslist<KVPair<String,Integer>> A = Cons.KVlists(new KVPair<>("Tiger", 1),new KVPair<>("Tiger", 1),
				new KVPair<>("Bus", 1),new KVPair<>("Bus", 1),new KVPair<>("Bus", 1),
				new KVPair<>("Lion", 1),new KVPair<>("Lion", 1)
				,new KVPair<>("River", 1),new KVPair<>("River", 1));
		System.out.println(A+"\n");
		Conslist<KVPair<String,Integer>> b = A.ReduceByKey();
		System.out.println(b);
	}
}