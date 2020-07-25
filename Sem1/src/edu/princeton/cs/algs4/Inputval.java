package edu.princeton.cs.algs4;

import java.util.Scanner;

public class Inputval {
	   
	private static Scanner sc;

	public static void main(String args[]) 
	    {
	    
	    	sc = new Scanner(System.in);

	    	 double[] y = {-0.0144,0.1538,0.0077,0.018,0.1875,-0.0096,0.18197,0.16768,0.16358,0.1376,0.0932,0.0928,0.007739};//skin conductance
	    	 double[] x = {74.42,93.91,64.96,79.01,85.12,72.14,104.28,108.22,83.93,66.35,60.30,74.86,64.94}; 
	    	LinearRegression obj=new LinearRegression(x,y);
	    	System.out.println(obj);
	    	System.out.println("Slope of Regression is "+obj.slope());
	    	System.out.println("Intercept of Regression is "+obj.intercept());
	    	double slope = obj.slope();
	    	double intercept = obj.intercept();
	    	sc = new Scanner(System.in);
	    	System.out.println("Enter x : ");
	    	int var1=sc.nextInt();
	    	sc = new Scanner(System.in);
	    	System.out.println("Enter y : ");
	    	int var2=sc.nextInt();
	    	
	    	if(var2 > slope*var1 + intercept) {
	    	System.out.println("Lie detected!");
	    	}
	    	else {
	    	System.out.println("Truth has been spoken");
	    	}
	    	
}
	    	
	    	
	 
	    	
	    	

	    	
	    }




