import java.util.*;
public class Graph {
    static class Edge{
        int src;
        int dest;
        int wt;

        Edge(int src, int dest, int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1, 3));
        graph[0].add(new Edge(0, 2, 3));

        graph[1].add(new Edge(1, 0, 2));
        graph[1].add(new Edge(1, 3, 5));

        graph[2].add(new Edge(2, 0, 3));
        graph[2].add(new Edge(2, 4, 2));

        graph[3].add(new Edge(3, 1, 5));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 6, 1));

        graph[6].add(new Edge(6, 5, 1));
    }


    public static void bfs(ArrayList <Edge> graph[], boolean visited[], int v){
        Queue <Integer> queue = new LinkedList<>();

        queue.add(0);
        while (! queue.isEmpty()) {
            int curr = queue.remove();

            if (visited[curr] == false) {
                System.out.print(curr+" ");
                visited[curr] = true;

                for(int i=0; i<graph[curr].size(); i++){
                    Edge e = graph[curr].get(i); 
                    queue.add(e.dest);
                }
            }
         
        }
    }

    public static void dfs(ArrayList <Edge> graph[], int curr, boolean visited[]){
        System.out.print(curr+" ");
        visited[curr] = true;
        
        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(! visited[e.dest]){
                dfs(graph, e.dest, visited);
            }
            
        }
        
    }
 
    public static void main(String args[]){
        int v = 7;
        ArrayList <Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        
        
        //print neighbours 
        // for(int i=0; i<graph[2].size(); i++){
        //     Edge e = graph[2].get(i);
        //     System.out.println(e.dest+" "+e.wt);
        // }

        
        boolean visitedBfs[] = new boolean[v];
        bfs(graph, visitedBfs, v);

        System.out.println();
        
        boolean visitedDfs[] = new boolean[v];
        dfs(graph, 0, visitedDfs);
    }
}
