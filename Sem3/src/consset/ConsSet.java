package consset;

public abstract class ConsSet<T> {
	public abstract boolean has(T key);
	public abstract ConsSet<T> add(T key);
}
