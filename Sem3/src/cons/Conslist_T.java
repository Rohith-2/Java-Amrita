package cons;
@SuppressWarnings("unchecked")
public abstract class Conslist_T <T>{
	abstract public T head();
	abstract public Conslist_T<T> tail();
	abstract public T reduce(ReduceClosure_T<T> f);
	abstract Conslist_T<T> append(Conslist_T<T> other);
	
	public boolean isEmpty() {return true;}
	public void print() {}
	
	public Conslist_T<?> map(MapClosure_T<T,?> f) {return Cons_T.Nil;}
	public Conslist_T<T> filter(FilterPredicate<T> f){return (Conslist_T<T>) Cons_T.Nil;};
	public int length(){return 0;}
	
	public Conslist_T<T> reverse() {return (Conslist_T<T>) Cons_T.Nil;}
}
