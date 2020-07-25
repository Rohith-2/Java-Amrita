package data;


public abstract class PData1{
	String name;
	String officestaff;
	int age; 
	int cla;
	String des;
	
public PData1(String n,int a,String os) 
   {
		name=n;
		officestaff=os;
		age=a;
		
	}
public PData1() 
    {
		return ;
	}

public PData1(String n,int a,int c) {
	name=n;
	age = a;
	cla=c;
	
}

public abstract String off();
public abstract int cla();
public abstract String des();

public static void details(PData1 p) {
System.out.println("Name:"+p.name);
System.out.println("Age:"+p.age);
System.out.println("Class:"+p.cla());
System.out.println("Des:"+p.des());


}

}