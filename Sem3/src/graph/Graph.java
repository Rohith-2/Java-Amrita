package graph;

public interface Graph {

	int[] sssp(int i);
	
	int[] dijkstras(int src);
	
	int[] mst();
	void print_mst(int[][] adMatrix);
	
}