package data;

public class PData2 {
	public static void main(String[] args) 
	{
		PData1 p1 = new Teacher("Rahul",23,4);
		PData1 p2 = new Student("Rohith",13,4);
		PData1 p3 = new Teacher("Mr.Ravi",56,10) {
	    public String des() {
				return ("Principal");
				
			}
		};
		
		PData1 p5 = new Teacher();
		
	    PData1 p4 = new Office("Manj",34,"Accountant");
	    PData1.details(p1);
	    PData1.details(p2);
	    PData1.details(p3);
	    PData1.details(p4);
	    PData1.details(p5);
	    
	    
	}

}
class Teacher extends PData1 {
	
	public Teacher(String n,int a,int c) {
	    super(n,a,c);
		}
	public Teacher() {
	    super();
		
	
		}
	
	

	public String off() {
		return("Not Applicable");
	}
	public int cla() {
		return(cla);
	}


	public String des() {
		return ("Teacher");
	}
}

class Student extends PData1 {
		
	public Student(String n,int a,int o) {
		super(n,a,o);
		
	}
	public String off() {
		return("Not Applicable");
	}
	public int cla() {
		return(cla);
	}
	public String des() {
		return ("Student");
	}
	}
class Office extends PData1 {
		
	public Office(String n,int a,String os) {
		super(n,a,os);
		}
		public String off() {
			return(officestaff);
		}
		public int cla() {
			return (0);
		}
		public String des() {
			return (officestaff);
		}



}