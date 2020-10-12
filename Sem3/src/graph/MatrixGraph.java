package graph;

public class MatrixGraph implements Graph {

		int [][]graph;
		int V;
		
		public MatrixGraph(int[][]g) {
			graph=g;
			V=g.length;
		}
		
		public int[] sssp(int src) {
			return dijkstras(src);
		}
		
		public int minimize(int[] cost,boolean[] taken) {
			int minIndex = -1,minValue = Integer.MAX_VALUE;
			for(int i=0;i<V;i++) {
				if(!taken[i] && cost[i]<minValue) {
					minValue=cost[i];
					minIndex=i;
				}
			}
			return minIndex;
		}
		
		public int[] dijkstras(int src) {
			int[] dist=new int[V];
			boolean[] taken = new boolean[V];
			
			for(int i=0;i<V;i++) {
				dist[i]=Integer.MAX_VALUE;
				taken[i]=false;
			}
			
			dist[src]=0;
			
			for(int i=0;i<V-1;i++) {
				int u = minimize(dist, taken);
				taken[u]=true;
				
				for(int v=0;v<V;v++) {
					if(graph[u][v]!=0 && !taken[v]) {
						if(dist[v]>graph[u][v] + dist[u]) dist[v]=graph[u][v] + dist[u];
							
					}
				}
			}
			return dist;	
		}
		
		@Override
		public int[] mst() {
			// TODO Auto-generated method stub
			return null;
		}
		
		public static void main(String[] args) {
		int[][] adMatrix= {
				{0, 5,  0,  0,  0,  4,  0},
				{5, 0, 10,  0,  0,  0,  0},
				{0, 10, 0,  7, 12,  0,  9},
				{0, 0,  7,  0, 21,  0,  9},
				{0, 0, 12, 21,  0,  1,  0},
				{4, 0,  0,  0,  1,  0, 11},
				{0, 0,  0,  9,  0, 11,  0}
		};
			Graph g = new MatrixGraph(adMatrix); 	
			int[] spDist = g.sssp(0);
			for(int i = 0; i < spDist.length;i++)System.out.println(i+"->"+spDist[i]);
		}

		
}
