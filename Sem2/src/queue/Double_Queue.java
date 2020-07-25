package queue;

public class Double_Queue implements Dqueue {

		int[] queue;
		int rear,front;
		
		public Double_Queue(int size) {
			queue = new int[size];
			front = rear = -1;
		}
		public void enque(int i) {
			if(isFull()){
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
				queue[front]= queue[front=(front+1)%queue.length];
				
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

		@Override
		public void enquef(int a) {
			if(isFull()){
				System.out.println("OverFlow");
			}
			else if(isEmpty()){
				queue[0]=a;
				front=rear=0;
			}
			else {
				if (front-1>=0){
				queue[front=(front-1)]=a;
			}	
				else {
					queue[front=queue.length + (front-1)]=a;
				}
			}		
		}

		@Override
		public int dequeb() {
			if(isEmpty()) {
				System.out.println("UnderFlow");
				return 0;
			}
			else if(rear==front){
				int temp = queue[rear];
				front = rear = -1;
				return temp;
			}
			else {
				if(rear-1>=0) {
					int temp = queue[rear];
					queue[rear] = queue[rear=(rear-1)];
					return temp;
				}
				else {
					int temp = queue[rear];
					queue[rear] = queue[rear=queue.length+(rear-1)];
					return temp;
				}
			}
		}


		public boolean isFull() {
			return (rear+1)%queue.length == front;
			
		}
		 public static void main(String[] args) {
			 Double_Queue s = new Double_Queue(10);
			 s.enque(1);
			 s.enque(2);
			 s.enque(3);
			 s.enque(4);
			 s.enque(5);
			// s.deque();
			 s.print();
			 s.enquef(6);
			 s.enquef(7);
			 s.print();
			 s.dequeb();
			 s.dequeb();
			 s.dequeb();
			 s.dequeb();
			 s.dequeb();
			 s.dequeb();
			 s.dequeb();
			 s.print();
			 
			
			
		  }
		
}
