package prroj;


public abstract class Conslist<T> {
	public KVPair<String, Integer> head;
	abstract public KVPair<String, Integer> head();
	abstract public Conslist<KVPair<String, Integer>> tail();
	public boolean isEmpty() {return true;}
	public void print() {}
	abstract Conslist<KVPair<String, Integer>> append(Conslist<KVPair<String, Integer>> other);
	public abstract boolean has(String k);
	public Conslist<KVPair<String, Integer>> ReduceByKey(){return null;}
	public abstract KVPair<String, Integer> where(String k);
	public abstract Conslist<KVPair<String, Integer>> reverse();;
}
