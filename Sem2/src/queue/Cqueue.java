 package queue;

import java.util.ArrayList;

public class Cqueue implements Queue {

		int[] queue;
		int rear,front;
		
		public Cqueue(int size) {
			queue = new int[size];
			front = rear = -1;
		}
		
		public void enque(int i) {
			if((rear+1)%queue.length == front){
				System.out.println("OverFlow");
			}
			else if(isEmpty()){
				queue[0]=i;
				front=rear=0;
			}
			else {
				queue[rear=(rear+1)%queue.length]=i;
			}
		}
		
		public int deque() {
			if(isEmpty()) {
				System.out.println("UnderFlow");
				return 0;
			}
			else if(rear==front){
				int temp = queue[front];
				front = rear = -1;
				return temp;
			}
			else {
				int temp = queue[front];
				front = queue[front=(front+1)%queue.length];
				
				return temp;
			}
		}
		
		public boolean isEmpty() {
			return front<0;
		}

		public void print() {
			if(isEmpty()) return;
			
			for(int i =front;i!=rear;i=(i+1)%queue.length) {
				System.out.println(queue[i]+" ");	
			}
			System.out.println(queue[rear] + "\n");
		}
		 public static void main(String[] args) {
			 /*
			 Cqueue s = new Cqueue(5);
			 s.enque(1);
			 s.enque(2);
			 s.enque(3);
			 s.enque(4);
			 s.enque(5);
			 s.print();
			 s.enque(6);
			 for (int i =0;i<=6;i++)
				 System.out.println(s.deque());
				 */
			 ArrayList<Integer> a = new ArrayList<Integer>();
			 a.add(1);a.add(2);a.add(3);
			 System.out.println(a.get(1));
			 
			
			
		  }
}
