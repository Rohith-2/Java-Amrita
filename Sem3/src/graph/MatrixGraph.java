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
		
		/*
		 * Refer-Concept : https://amritavishwavidyapeetham-my.sharepoint.com/:v:/r/personal/m_vijaykrishna_cb_amrita_edu/Documents/19AIE203/Videos/VKM-19AIE203-DS2-VX3-Graph-Dijkstras.mp4?csf=1&web=1&e=AmS0PR
		 * 
		 * Refer-Code_Implementation : https://amritavishwavidyapeetham-my.sharepoint.com/:v:/r/personal/m_vijaykrishna_cb_amrita_edu/Documents/19AIE203/Videos/VKM-19AIE203-DS2-VX5-Graph-Matrix-Implementation.mp4?csf=1&web=1&e=eVqLCf
		 */
		
		public int[] dijkstras(int src) {
			int[] dist=new int[V];
			boolean[] taken = new boolean[V];
			
			for(int i=0;i<V-1;i++) {
				dist[i]=Integer.MAX_VALUE;
				taken[i]=false;
			}
			
			dist[src]=0;
			
			for(int i=0;i<V-1;i++) {
				int u = minimize(dist, taken);
				taken[u]=true;
				
				for(int v=0;v<V;v++) {
					if(graph[u][v]!=0 && !taken[v] && dist[v]>graph[u][v] + dist[u]) 
							dist[v]=graph[u][v] + dist[u];	
				}
			}
			return dist;	
		}
		
		/*
		 * Refer-Concept : https://amritavishwavidyapeetham-my.sharepoint.com/:v:/g/personal/m_vijaykrishna_cb_amrita_edu/EZFWrKBzo1xEqG_WdmK4T1MBJdXfmZC3mPKzHAgJMLHR2g?e=s6HWGT
		 * 
		 * Refer-Code_Implementation : Self
		 */
		 
		@Override
		public int[] mst() {
			int[] parent = new int[V];
			int[] key = new int[V];
			boolean[] taken = new boolean[V];
			
			for(int i=0;i<V;i++) {
				key[i]=Integer.MAX_VALUE;
				taken[i]=false;
			}
			
			key[0]=0;
			parent[0]=-1;
			
			for(int i=0;i<V-1;i++) {
				int u = minimize(key, taken);
				taken[u]=true;
				
				for(int v=0;v<V;v++) {
					if(graph[u][v]!=0 && !taken[v] && key[v]>graph[u][v]) {
						parent[v] = u;
						key[v]=graph[u][v];	
					}
				}
			}
			return parent;
		}
		
		public void print_mst(int[][] adMatrix) {
			System.err.println("Link  Key");
			int[] mst = mst();
			for(int i = 1; i < mst.length;i++)System.out.println(mst[i]+"->"+i+" : "+adMatrix[i][mst[i]]);
		}
		
		public static void main(String[] args) {
		int[][] adMatrix= {
				{0, 5,  0,  0,  0,  4,  0},
				{5, 0, 10,  0,  0,  0,  0},
				{0, 10, 0,  7, 12,  0,  0},
				{0, 0,  7,  0, 21,  0,  9},
				{0, 0, 12, 21,  0,  1,  0},
				{4, 0,  0,  0,  1,  0, 11},
				{0, 0,  0,  9,  0, 11,  0}
		};
			Graph g = new MatrixGraph(adMatrix); 	
			/*
			int[] spDist = g.sssp(0);
			for(int i = 0; i < spDist.length;i++)System.out.println(i+"->"+spDist[i]);
			*/
			g.print_mst(adMatrix);
			
		}

		
}
