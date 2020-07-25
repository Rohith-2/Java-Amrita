package assignment2;

 abstract class Bookclass{

	public Bookclass() {
	
	}
	public abstract String gettype() ;           //we made it abstract because we can't define it nor do we have any variables to define it.
	public abstract String gettitle() ;
	public abstract String getisbn() ;
	
	
    public static void details(Bookclass s) 
	 {
	
		 System.out.println(s.gettype());
		 System.out.println(s.gettitle());
		 System.out.println(s.getisbn());
		 
	 }
	
}

class Reference extends Bookclass{

	public Reference() 
	{
		return ;
	}
	
	public String gettype() 
    {
		return ("Reference");
	}

	public String gettitle() 
    {
		return null;
	}

	public String getisbn() 
    {
		return null;
	}
}
class Text extends Bookclass{
	public Text() {
		return ;
	}
	public String gettype() {
		return ("Text");
	}
	
	public String gettitle() {
		return null;
	}

	public String getisbn() {
		return null;
	}
}
class Fiction extends Bookclass{
	public Fiction() {
		return ;
	}
	public String gettype() {
		return ("Fiction");
	}

	public String gettitle() {
		return null;
	}

	public String getisbn() {
		return null;
	}
	
}

