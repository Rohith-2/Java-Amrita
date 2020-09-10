package cons;

public abstract class Conslist {
	
	abstract public int head();
	abstract public Conslist tail();
	abstract public int reduce(ReduceClosure f);
	
	public boolean isEmpty() {return true;}
	public void print() {}
	public Conslist map(MapClosure f) {return Cons.Nil;}
	public int length(){return 0;}
	public Conslist reverse() {return Cons.Nil;}
	
}
