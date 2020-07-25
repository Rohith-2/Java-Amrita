
package edu.princeton.cs.algs4;
import java.io.IOException;
import java.util.*;
public class Data1 
{
	static Scanner a;
	static Scanner b;

	public static void main(String[] args) throws IOException 
	{
        double[] y1 = {0.0750,0.2135,0.055,0.3258,0.3103,0.0440,-0.0055,0.136,0.4429};//skin conductance
		double[] x1 = {83.109,94.749,81.793,107.724,92.316,88.1523,83.801,78.1123,104.263};  //heart rate
		Scanner sc=new Scanner(System.in);
		LinearRegression obj = new LinearRegression(x1,y1);
		System.out.println(obj);
		double slope = obj.slope();
		double intercept = obj.intercept();

		double[] y2 = {-0.0153,0.33748,0.0891,0.3600,0.3661,0.1381,0.09956,0.1312,0.021678};//skin conductance
		double[] x2 = {62.929,100.421,75.5191,101.753,91.499,74.5567,72.6428,66.9411,63.0965};  //heart rate
		LinearRegression obj2 = new LinearRegression(x2,y2);
		System.out.println(obj2);
		double slope2 = obj2.slope();
		double intercept2 = obj2.intercept();

		double[] y3 = {0.4515,0.11196,0.4215,0.1081,0.04883,0.09576,0.22555,0.40765,0.33924};//skin conductance
		double[] x3 = {106.3033,52.815,90.24695,66.7695,61.8014,57.7964,93.7245,82.7480,96.84451};  //heart rate
		LinearRegression obj3 = new LinearRegression(x3,y3);
		System.out.println(obj3);
		double slope3 = obj3.slope();
		double intercept3 = obj3.intercept();

		a = new Scanner(System.in);
		System.out.println("Enter Heart Beat : ");
		double var1=a.nextDouble();
		b = new Scanner(System.in);
		System.out.println("Enter Skin Conductance : ");
		double var2=b.nextDouble();
		System.out.println("Enter 1 for 6-15");
		System.out.println("Enter 2 for 16-60");
		System.out.println("Enter 3 for 60 above");
		System.out.println("Enter the age value:");
		int av=sc.nextInt();

		if (av ==1) {

			if(var2 > (slope*var1) + intercept) {
				System.out.println("Lie detected!");
			}
			else {
				System.out.println("Truth has been spoken");
			}
		}
		else if (av ==2) {

			if(var2 > (slope2*var1) + intercept2) {
				System.out.println("Lie detected!");
			}
			else {
				System.out.println("Truth has been spoken");
			}

		}
		else if (av ==3) {

			if(var2 > (slope3*var1) + intercept3) {
				System.out.println("Lie detected!");
			}
			else {
				System.out.println("Truth has been spoken");
			}

		}
		else 
			System.out.println("Incorrect Age Group");
		sc.close();
	}
	}
