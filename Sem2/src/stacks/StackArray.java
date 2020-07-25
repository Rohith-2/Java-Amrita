package stacks;

public class StackArray implements Stacks {
	int top;
	int[] stack;
	
	public StackArray(int size) {
		stack = new int[size];
		top = -1;
	}

	@Override
	public void push(int a) {
		if (top + 1 == stack.length) {
			System.out.println("Overflow");
			return;
		}
		stack[++top] = a;
	}

	@Override
	public int pop() {
		if (top < 0) {
			System.out.println("Underflow");
			return -1;
		}
		return stack[top--];

	}

	@Override
	public void print() {
		for (int i = top; i >= 0; i--) {
			System.out.print(stack[i] + " ");
			System.out.println();
		}
	}

	public void comp(String a) {
		for (int i = 0; i < a.length(); i++) {

			if (a.charAt(i) == '+') {
				int t = pop() + pop();
				push(t);
			} else if (a.charAt(i) == '-') {
				int t = -pop() + pop();
				push(t);
			} else if (a.charAt(i) == '*') {
				int t = pop() * pop();
				push(t);
			} else if (a.charAt(i) == '/') {
				int temp = pop();
				int t = pop() / temp;
				push(t);
			} else {
				int num = Integer.parseInt(a.substring(i, i + 1));
				push(num);
			}
		}
		print();
	}

	public static void main(String[] args) {
		StackArray s = new StackArray(10);
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.pop();
		// s.print();
		StackArray q = new StackArray(10);
		String a = "533+7*6-8*3/";
		q.comp(a);
		
	}
}
