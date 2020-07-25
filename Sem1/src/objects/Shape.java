package objects;

public abstract class Shape {
                                                 /*
                                                  * Abstraction is a concept taken without any query take for granted that the shape exists 
                                                  * All classes are abstract if any class is specifically called abstract then it can't be defined.
                                                  * The opposite of abstract classes are concrete classes in concrete class is fully defined.
                                                  */
    String name;
    
public Shape() { 
	this("Noname");                               /*This is a constructor i.e. when its name is the class name and its purpose is to initialise variables.
                                                   *Current class object that is being constructed, whereas
	                                               *super refers to calling objects from parent class
	                                               */
 System.out.println("Inside Shape con1");
}

public Shape(String n)
{                                                 //We are overloading the constructor with a string defined inside.
	name=n;
	System.out.println("Inside Shape con2");
}

public void print() 
{
	System.out.println("Shape: "+this.name);
}

 public abstract double area();                   /*This is an abstract function where you can't use it but are initialising it to 
                                                  *give an abstract idea that every shape has an area and perimeter.
                                                  */
 public abstract double perimeter();
 
 public static void details(Shape s) 
 {
	 System.out.println(s.name);
	 System.out.println(s.area());
	 System.out.println(s.perimeter());
	 System.out.println(s.getClass().getName());
	 
 }

	/*Inheritance 
	 * 
	 *
	 * This is the 'Shape' example Class. The Objective is to demonstrate the
	 * concept of 'abstract' and concrete classes and 'abstract' methods 
	 * (functions) as well as to show-case the idea of "Inheritance" in Object 
	 * Oriented Programming as extending classes.     
	 * Polymorphism is the property to behave differently in different situations. 
	 */
}