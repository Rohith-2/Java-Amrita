package mathfunc;
import java.util.Random;
public class Math {
 static Random r = new Random(7);
	static double toll = 0.000001;
	
	public static int fac (int n)
	{
		if(n<=2)
			return n;           //This is an example of a function calling itself.
		else 
			return n*fac(n-1);  /*In this step the function forms a kind of loop and returns to the first 
		                         line until the value of decreasing n becomes less than or equal to 2
	                            */
	
	}
	
	public static double sqrt(double a) {
		double x =1.0;
		double err = java.lang.Math.abs(((x*x) - a)/a) ;
		while (err>toll) {
			x=(x+a/x)/2;
			err = ((x*x) - a)/a ;
		}
		return x;
	}
	public static double root(double a) {
		double x =1.0;
		double err = java.lang.Math.abs(((x*x*x) -2*(x*x)+2*x-a)/a) ;
		while (err>toll) {
			x=((2*x*x*x)-(2*x*x)+a)/((3*x*x)-(4*x)+2);
			err = ((x*x*x) -2*(x*x)+2*x-a)/a ;
		}
		return x;
	}
	public static double sin(double x,int a) {
		double s = 0;
		for(int n = 0;n<=a;n++) {
		 s += java.lang.Math.pow(x,(2*a)+1)/(java.lang.Math.pow(-1,a)*fac((2*a) +1));
		}
		return s;
	}
	
	public static double inte(int a) {
		double dx=java.lang.Math.pow(10,-a);      //for using a to the power b where a is basically precision 
	    double sum=0;
		for (double x=0;x<=1;x+=dx) {      //basically integration of the function where x will eventually add up to 1
			sum+=(x*x*x)-2*(x*x)+2*x-4;
		}
    	double v =sum*dx;
    	return v;
	}
	
    public static double pi(int a) {
		double dx=java.lang.Math.pow(10,-a);      //for using a to the power b where a is basically precision 
	    double sum=0;
		for (double x=0;x<=1;x+=dx) {      //basically integration of the function where x will eventually add up to 1
			sum+=1/(1+x*x);
		}
    	double v =sum*dx*4;
    	return v;
    	
    }
    public static double piMC(int press) {
		double t = java.lang.Math.pow(10,press);
		int c=0;
		double x,y;
		double count = 0;
		while(count<t) {
			x=r.nextDouble()*2-1;
			y=r.nextDouble()*2-1;
			
			if(x*x + y*y <= 1.0) c+=1.0;
			count+=1;
			
		}
    	return c/t*4;
    	
    }
    public static void main(String[] args) {
     //will give 4 values accurate after decimal point after that its not..
	System.out.println(sin(java.lang.Math.PI/2 ,2));
	System.out.println(root(4));
	System.out.println(inte(4));
    }
}
