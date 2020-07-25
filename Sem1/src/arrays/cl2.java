package arrays;

public class cl2 
{
	public static double sumArray(double[] a )
	{
		double sum = 0;
		for(int i =0 ; i< a.length ; i++)
		{
			sum+=a[i];
		}
		System.out.println(sum);
    return sum;
	}
	
	public static void main(String [] args) {
		double[] arr = {1,2,3,4,5};
		double sum = sumArray(arr);
		System.out.println(sum);
		
		int j = 0x00005670;
		System.out.println(Integer.toBinaryString(j));
		int a = j>>12;
		System.out.println(Integer.toBinaryString(a));
		System.out.println(Integer.toBinaryString(a&1));
		
		int[] a1=new int[101];
		for (int i =1;i<a1.length;i++)
		{
			a1[i]=i;
			System.out.println(a1[i]);
			
		}
			
		
	}

}
