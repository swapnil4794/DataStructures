package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/*
time complexity:V+E

*/
public class BFSDisconnected {
    public static void main(String args[]) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(7);
        for (int i = 0; i < 7; i++) {
            adj.add(new ArrayList<Integer>());
        }
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 2);
        addEdge(adj, 3, 4);
        addEdge(adj, 5, 6);

        printGraph(adj);
        boolean[] visited = new boolean[7];
        visited = bfs(adj, 7, 0,visited);
        System.out.println(bfsdis(adj,7,visited));

    }

    private static boolean[] bfs(ArrayList<ArrayList<Integer>> adj, int n, int s,boolean[] visited) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(s);
        visited[s] = true;
        while (!q.isEmpty()) {
            int curr = q.poll();
            System.out.print(curr + " ");
            for (Integer i : adj.get(curr)) {
                if (visited[i] == false) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }

        return visited;
    }

    private static int bfsdis(ArrayList<ArrayList<Integer>> adj, int n, boolean[] visited) {
        int count=1;
        for(int i=0;i<n;i++){
            if(visited[i]==false){
                count++;
                bfs(adj,n,i,visited);
            }
        }
        System.out.println();
        return  count;
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
