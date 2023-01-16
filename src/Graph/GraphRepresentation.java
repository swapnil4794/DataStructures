package Graph;

import java.util.ArrayList;

public class GraphRepresentation {
    public static void main(String args[]) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(5);
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList<Integer>());
        }
            addEdge(adj, 0, 1);
            addEdge(adj, 0, 2);
            addEdge(adj, 1, 2);
            addEdge(adj, 1, 3);
            printGraph(adj);
        }

    private static void printGraph(ArrayList<ArrayList<Integer>> adj) {
        for(int i=0;i<adj.size();i++){
            for(int j=0;j<adj.get(i).size();j++){
                System.out.print(adj.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }

    private static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}
