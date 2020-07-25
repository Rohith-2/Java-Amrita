package arrays;

public class Repeatingfunctions {
	public static int fac (int n)
	{
		if(n<=2)
			return n;           //This is an example of a function calling itself.
		else 
			return n*fac(n-1);  /*In this step the function forms a kind of loop and returns to the first 
		                         line until the value of decreasing n becomes less than or equal to 2
	                            */
	
	}
	
	public static int fib (int n)    // Fibonacci series is 0,1,1,2,3,5,8,13.... basically the
	                                 //nth term is sum of the previous 2 terms
	{
		if(n<=1)
			return n;           
		else 
			return fib(n-1) + fib(n-2);  
	
	}
	
	public static void main(String[] Args)
	{
	int a = 9;
	int b = fac(a);
	System.out.println(a +" and its factorial is "+ b );    
	int c = 5;
	int f = fib(c);      //c-1 as we need to include 0 in counting also.. if not neglect c-1 and consider it as just c.
	System.out.println(f);
	}

}
