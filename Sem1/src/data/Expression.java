package data;

public class Expression {
	public static void main(String[] args) {
		Expr e1 = new NumExpr(8);
		Expr e2 = new NumExpr(1);
		Expr e3 = new NumExpr(10);
		Expr e4 = new NumExpr(4);
		Expr a1 = new AddExpr(e1,e3) ;
		Expr m1 = new MultExpr(a1,e4);
		Expr s1 = new SubExpr(m1,e2);
		System.out.println(s1.compute());
	}

}
