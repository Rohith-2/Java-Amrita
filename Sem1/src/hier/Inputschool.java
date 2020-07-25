package hier;

import hier.Schooldatabase.PData;

public class Inputschool {

}
 class Teacher extends PData {
	String name;
	int age;
	int cla;

	public Teacher(String n,int a,int c) {
	    super(n);
		age=a;
	
		}
	
	public void print() {
		System.out.println("Teacher: "+name);
	}

	public String off() {
		return("Not Applicable");
	}
	public int cla() {
		return(cla);
	}
}
	class Student extends PData {
		String name;
		int age;
		int cla;
	public Student(String n,int a,int c) {
		super(n,a,c);
		
		cla=c;
	}
	public String off() {
		return("Not Applicable");
	}
	public int cla() {
		return(cla);
	}
	}
class Officestaff extends PData {
		String name;
		int age;
		String os;
		public Officestaff(String n,int a,String o) {
			super(n);
			age=a;
			os=o;
		}
		public String off() {
			return(os);
		}
		public int cla() {
			return(0);
		}

public static void main(String [] args) {
	PData p1 = new Teacher("Rahul",23,4);
	PData p2 = new Student("Rohith",13,4);
	PData p3 = new Teacher("Mr.Kaji",56,10);
    PData p4 = new Officestaff("Manj",34,"Accountant");
    PData.details(p1);
    PData.details(p2);
    PData.details(p3);
    PData.details(p4);
}


}