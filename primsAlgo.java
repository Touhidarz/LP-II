import java.util.*;

public class primsAlgo {
    public static class Edge{
        int src, dest, wt;

        Edge(int src, int dest, int wt){
            this.src=src;
            this.dest=dest;
            this.wt=wt;
        }

    }

    public static class Pair implements Comparable<Pair>{
        int node, cost;

        public Pair(int node, int cost){
            this.node = node;
            this.cost = cost;
        }
        @Override
        public int compareTo (Pair p){
            return(this.cost - p.cost);
        }
    }
    

    public static void createGraph(ArrayList <Edge> graph[], int src){
        for(int  i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1,10));
        graph[0].add(new Edge(0,2,15));
        graph[0].add(new Edge(0,3,30));

        graph[1].add(new Edge(1,0,10));
        graph[1].add(new Edge(1,3,40));

        graph[2].add(new Edge(2,0,15));
        graph[2].add(new Edge(2,3,50));

        graph[3].add(new Edge(3,1,40));
        graph[0].add(new Edge(3,2,50));
        // graph[0].add(new Edge(3,0,30));
    }

    public static void Prims(ArrayList<Edge>graph[], int V){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[] visit = new boolean[V];
        pq.add(new Pair(0, 0));
        int mstCost = 0;
        

        while(! pq.isEmpty()){
            Pair curr = pq.remove();

            if(! visit[curr.node]){
                visit[curr.node] = true;
                mstCost += curr.cost;

                System.out.print(curr.node + "->"+curr.cost);
                System.out.println();

                for(int i=0; i<graph[curr.node].size(); i++){
                    Edge e = graph[curr.node].get(i);

                    if(! visit[e.dest]){
                        pq.add(new Pair(e.dest, e.wt));
                    }
                }
            }
        }
        System.out.println();
        
        System.out.println("Min cost of Tree : "+mstCost);
        
    }
    public static void main(String args[]){
        int V = 4;
        ArrayList <Edge> graph[] = new ArrayList[V];

        createGraph(graph, V);

        Prims(graph, V);
    }
}