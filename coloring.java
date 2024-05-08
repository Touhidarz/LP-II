import java.util.*;

public class coloring{

	public static class Edge{
		int src, dest;
		
		public Edge(int src, int dest){
			this.src = src;
			this.dest = dest;
		}
	}
	
	public static void createGraph(ArrayList <Edge>[] graph){
		Scanner sc = new Scanner(System.in);
		for(int i=0; i< graph.length; i++){
			graph[i] = new ArrayList<>();
			
			System.out.print("Enter neighbour of "+(i)+"(Enter -1 to close) : ");
			while(true){
				int input = sc.nextInt();
				if(input == -1){break;}
				graph[i].add(new Edge(i, input));
			}
		}	
	}
	
	public static void color(ArrayList <Edge>[] graph, int start){
		int[] result = new int [graph.length];
		boolean[] check = new boolean [graph.length];
		
		for(int i=0; i<graph.length; i++){
			result[i] = -1;
		}
		Arrays.fill(check, true);
		result[0] = 0;
		
		for(int i=0; i<graph.length; i++){
			for(int j=0; j<graph[i].size(); j++){
				Edge e = graph[i].get(j);
				
				if(result[e.dest] != -1){
					check[e.dest] = false;
				}
			}
			int j;
			for(j=0; j<graph.length; j++){
				if(check[j]){
					break;
				}
			}
			result[i] = j;
			Arrays.fill(check, true);
		}
		
		for(int i=0; i<graph.length; i++){
			System.out.println("Vertex : "+i+ " --> color : "+result[i]);
		}
	}
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of Vertices : ");
		int v = sc.nextInt();
		
		ArrayList <Edge>[] graph = new ArrayList[v];
		createGraph(graph);
		color(graph, 0);
	}
}

