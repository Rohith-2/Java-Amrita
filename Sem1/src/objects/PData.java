package objects;
public abstract class PData{
	String name;
	String officestaff;
	int age; 
	int cla;
	
public PData(String n,int a,String os) {
		name=n;
		officestaff=os;
		age=a;
		
	}
public PData() {
		return ;
	}

public PData(String n,int a,int c) {
	name=n;
	age = a;
	cla=c;
	
}

public PData(String n) {
name=n;
}

public abstract String off();
public abstract int cla();

public static void details(PData p) {
System.out.println("Name:"+p.name);
System.out.println("Age:"+p.age);
System.out.println("Age:"+p.off());
System.out.println("Class:"+p.cla());


}

}

	
	

