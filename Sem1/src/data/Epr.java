package data;

interface Expr{
	public int compute() ;
}


 class NumExpr implements Expr{
	 int q;
	 public NumExpr(int q) {
		 
	 }

	public int compute() {
		return q;
	}

	
 }
 class AddExpr implements Expr{
	 Expr q;
	 Expr r;
	 public AddExpr(Expr q, Expr r) {
		
	 }
	 public int compute() {
		 return q.compute() + r.compute() ;
	 }

 }
class SubExpr implements Expr{
	Expr q;
	Expr r;
	
    public SubExpr(Expr q, Expr r) {
	
		 }
		 public int compute() {
			 return q.compute() - r.compute() ;
		 }
	
 }
class MultExpr implements Expr{
	Expr q;
	Expr r;
	public MultExpr(Expr q, Expr r) {
		
			}
	 public int compute() {
		 return q.compute() * r.compute() ;
	 }
	
}





