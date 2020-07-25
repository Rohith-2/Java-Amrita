package hash;

public class HashTest {
	public static int hash(int key) {
		return key%10;
	}
	
public static void main(String []args) {
	HashTest x = new HashTest();
	System.out.println("I am a string".hashCode());
	System.out.println(x.hashCode());
	int key = 5643;
	int[] a = new int[10];
	a[hash(key)]=key;
}
}
