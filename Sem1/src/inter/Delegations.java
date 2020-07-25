package inter;

public class Delegations {

	 static EventListener[] eventarray = new EventListener[10];     //why static?? 
	 static int count=0;
	
	static void register(EventListener l) {
		eventarray[count++] = l;             //Its considered like this when l is saved it happens in eventarray[0] and the next obj gets saved in eventarray[1] the value inside keeps incrementing
	}
	public Delegations () {
		for(int i=0;i<count;i++) {
			eventarray[i].eventoccured();
		}
	}
}

interface EventListener{
	public void eventoccured();
}
class A implements EventListener{
String name;
public A(String n) {
	name=n;
}
	public void eventoccured() {
		System.out.println(name + " of type A : Object Created..");
	}
	
}
class B implements EventListener{
int num;
public B(int n) {
	num=n;
}
	public void eventoccured() {
		System.out.println(num + " of type B : Object Instantiated..");
	}

	

public static void main(String[] args) {
	A a1 = new A("Krish");
	A a2 = new A("Harsh");
	B b1 = new B(2209);
	B b2 = new B(1234);
	A a3 = new A("Batman");
	Delegations.register(a1);
	Delegations.register(a2);
	Delegations.register(b1);
	Delegations.register(b2);
	
	Delegations d1 =new Delegations();
	Delegations.register(a3);
	Delegations d2 =new Delegations();
	System.out.print(d1);
	System.out.print(d2);
}
}