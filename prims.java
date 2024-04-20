import java.util.*;


public class prims {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of Nodes :");
        int nodes = sc.nextInt();
        int arr[][] = new int[nodes][nodes];
        String Nodes[] = new String[5];
        int visit[] = new int[nodes];
        int minCost=0, count = 1, cost = 0;
        int minIndex =-1;

        System.out.println("Enter Nodes :");
        for(int i=0; i<nodes; i++){
            Nodes[i] = sc.next();
        }

        System.out.println("Enter weight of each edge :");
        for(int i=0; i<nodes; i++){
            for(int j=0; j<nodes; j++){
                System.out.println(Nodes[i]+" and "+Nodes[j]);
                arr[i][j] = sc.nextInt();
            }
        }
        
        for(int i=0; i<nodes; i++){
            visit[i] = 0;
        }

        System.out.print("Shortest Path : ");
        visit[0] = 1;
        System.out.print(Nodes[0]+" -> ");

        while(true){
            minCost = 1000;
            for(int i=0; i<nodes; i++){
                for(int j=0; j<nodes; j++){
                    if(visit[i]==0 && arr[i][j]!=0 && arr[i][j]<minCost && visit[j] == 0){
                        minCost = arr[i][j];
                        minIndex = j;
                    }
                }
            }
            
            visit[minIndex] = 1;
            System.out.print(Nodes[minIndex]+" -> ");
            cost = cost + minCost;
            count++;

            if(count == nodes){
                break;
            }

        }
        




    }
}
