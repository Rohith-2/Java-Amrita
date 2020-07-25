package arraydata;
public class Array {
	double[] a;
	int size;
public Array(int s,double[]arr) {
		 a = new double[s];
		 a=arr;
		 size = 0;
	}
public Array(int s) {
	 a = new double[s];
	 size = 0;
}
public void arr() {
	for (int i=0;i<a.length;i++) {
		System.out.println(a[i]);
		}
	
}
public void append (int q) {
		 double[] a2 = new double[2*a.length];
		 if(size<a.length) {
		for (int i =0;i<a.length;i++) {
			a2[i]=a[i];
		}
		a2[size++]= q;
		a = a2;
		 }
	}
public void sort() {
	double temp;
	for(int i = 0;i<a.length-1;i++) {
		if(a[i]>a[i+1]) {
			temp=a[i+1];
			a[i+1] = a[i];
			a[i]=temp;
		}
	}
}
public int search(int r) {
	int w = -1;
	for (int i =0;i<a.length;i++) {
		if(a[i]==r) {
			 w=i;
		} 
	}
	return w;
	
}
void insert(int pos, int i) {
	double[] a3 = new double[a.length+1];
	for (int e=0;e<pos;e++) {
		a3[e]=a[e];
	}
	a3[pos]=i;
	for (int e=pos+1;e<a.length;e++) {
		a3[e]=a[e];
	}
	a=a3;
}

void delete(int pos) {
	double[] a3 = new double[a.length-1];
	for (int e=0;e<pos;e++) {
		a3[e]=a[e];
	}
	for (int e=pos+1;e<a.length-1;e++) {
		a3[e]=a[e];
	}
	a = a3;
}
	
public static void main(String[] args) {
	Array a = new Array(1);
	a.append(2);
	a.append(3);
	a.insert(3,5);
	a.arr();
	System.out.println("Search:");
	System.out.println(a.search(3));
	//a.delete(3);
	a.arr();
	System.out.println("Sort");
	a.sort();
	a.arr();
	
	
}
}
