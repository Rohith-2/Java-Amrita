package edu.princeton.cs.algs4;

import java.io.IOException;


public class LinearRegression 
{
    public final double intercept, slope;

    public LinearRegression(double[] x, double[] y) 
    {
      
        int n = x.length;
        double sumx = 0.0, sumy = 0.0;
        for (int i = 0; i < n; i++) {
            sumx  += x[i];
            sumy  += y[i];
        }
        
        double xbar = sumx / n;
        double ybar = sumy / n;

        double xxbar = 0.0, xybar = 0.0;
        for (int i = 0; i < n; i++) {
            xxbar += (x[i] - xbar) * (x[i] - xbar);
            xybar += (x[i] - xbar) * (y[i] - ybar);
        }
        slope  = xybar / xxbar;
        intercept = ybar - slope * xbar;

       
    }
    public double intercept() {
        return intercept;
    }
    public double slope() {
        return slope;
    }

    

  public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(String.format("%.2f x + %.2f", slope(), intercept()));
        return s.toString();
       
    }
 
    public static void main(String[] args) throws IOException {
	}
    	}
    

