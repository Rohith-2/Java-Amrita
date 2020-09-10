package cons;
@SuppressWarnings("unchecked")
public abstract class Conslist_T <T>{
	abstract public T head();
	abstract public Conslist_T<T> tail();
	abstract public T reduce(ReduceClosure_T<T> f);
	
	public boolean isEmpty() {return true;}
	public void print() {}
	public Conslist_T<?> map(MapClosure_T<T,?> f) {return Cons_T.Nil;}
	public int length(){return 0;}
	public Conslist_T<?> reverse() {return Cons_T.Nil;}
}
