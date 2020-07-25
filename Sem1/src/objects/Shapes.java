package objects;

public class Shapes {
	
	}
	class Circle extends Shape {
		double radius;
		public Circle(double r) {
			super();
			radius = r;
		}
		
		public Circle(double r,String n) {
			super(n);                           //Imagine this: The shape abstract is like a display and only here we define what to display hence we send this to the parent class (Shape) 
			radius = r;
		}


		public double area() {
			return(radius*radius*3.14);
			
		}

		
		public double perimeter() {
			return (2*3.14*radius);
		
		}
		public void print() {
			System.out.println("Circle: "+name);
		}
		
	}
	class Square extends Shape {
		double side;
		public Square(double s) {
			super();
			side = s;
		}
		
		public Square(double s,String n) {
			super(n);
			side = s;
		}


		public double area() {
			return(side*side);
			
		}

		
		public double perimeter() {
			return (4*side);
		
		}
		public void print() {
			System.out.println("Square: "+name);
		}
	}
		
	class Triangle extends Shape
		{
			double side;
			double height;
			public Triangle() 
			{
               super();			
			
			}
			public Triangle(String n) 
			{
				super(n);
			}
		   public Triangle(String n,double s, double h) {
		   super(n);
		   side = s;
		   height=h;
		   
		   
		   }
		   public double area()
		   {
			   return(0.5*side*height);
		   }
		   public double perimeter()
		   {
			   return(3*side);
		   }
		   public void print() {
			   System.out.println("Triangle:"+this.name);
		   }
		}
	
		
  

