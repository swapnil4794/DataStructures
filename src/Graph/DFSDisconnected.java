package Graph;

import java.util.ArrayList;
/*
time complexity:V+E

*/
public class DFSDisconnected {
    public static void main(String args[]) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(6);
        for (int i = 0; i < 6; i++) {
            adj.add(new ArrayList<Integer>());
        }
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 2, 3);
        addEdge(adj, 4, 5);
        printGraph(adj);
        boolean[] visited = new boolean[6];
        dfsRec(adj, 6, 0,visited);
        dfsDisconnected(adj,6,visited);
    }

    private static void dfsDisconnected(ArrayList<ArrayList<Integer>> adj, int n, boolean[] visited) {
        int count=1;
        for(int i=0;i<n;i++){
            if(visited[i]==false){
                count++;
                dfsRec(adj,n,i,visited);
            }
        }
        System.out.println(count);
    }

    private static void dfsRec(ArrayList<ArrayList<Integer>> adj, int n, int s, boolean[] visited) {
        //Queue<Integer> q = new LinkedList<Integer>();
       // q.add(s);
            visited[s] = true;
            System.out.print(s + " ");
            for (Integer i : adj.get(s)) {
                if(visited[i]==false)
             dfsRec(adj,n,i,visited);
            }
        }

    private static void printGraph(ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    private static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}
