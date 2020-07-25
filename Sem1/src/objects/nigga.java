package objects;

public class nigga {
	public static void main(String[] args) {
		int a[] = new int[101];
		for(int i =0 ; i< 101 ; i++)
		{
			a[i]=i;
			System.out.println(a[i]);
		}
		int c = 12;
		String b= Integer.toBinaryString(c);
		System.out.println(b);
		int k = c>>2;
		String r= Integer.toBinaryString(k);
		System.out.println(r);
		
	}

}
