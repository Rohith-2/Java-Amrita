package objects;

public class PData1 {

}
class Teacher extends PData {
	
	public Teacher(String n,int a,int c) {
	    super(n,a,c);
		
	
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
class Office extends PData {
		
	public Office(String n,int a,String os) {
			name=n;
			
			age=a;
			officestaff=os;
		}
		public String off() {
			return(officestaff);
		}
		public int cla() {
			return(0);
		}


public static void main(String[] args) 
{
	PData p1 = new Teacher("Rahul",23,4);
	PData p2 = new Student("Rohith",13,4);
	PData p3 = new Teacher("Mr.Kaji",56,10);
    PData p4 = new Office("Manj",34,"Accountant");
    PData.details(p1);
    PData.details(p2);
    PData.details(p3);
    PData.details(p4);
    
    
}
}
