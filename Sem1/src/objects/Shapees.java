package objects;

public class Shapees {

		 public static void main(String [] args) {
			 Shape s1 = new Circle(1,"abcd");        //We can't code Shape s1 = new Shape() because they are abstract       
			 Shape s2 = new Square(1,"Sunny");
			 Shape s3 = new Triangle("Shankar",3,4);
			 s1.print();
			 Shape.details(s1);
			 s2.print();
			 Shape.details(s2);
			 s3.print();
			 Shape.details(s3);
		 }
		}


