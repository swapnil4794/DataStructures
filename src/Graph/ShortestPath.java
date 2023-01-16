package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPath {
    public static void main(String args[]) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(4);
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList<Integer>());
        }
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 3);
        printGraph(adj);
        boolean[] visited = new boolean[4];
        Integer[] dist = shortestPath(adj, 4, 0, visited);
        for(int i=0;i<4;i++){
            System.out.print(dist[i]);
        }
    }

    private static Integer[] shortestPath(ArrayList<ArrayList<Integer>> adj, int n, int s, boolean[] visited) {
        Queue<Integer> q = new LinkedList<Integer>();
        Integer[] dist = new Integer[n];
        dist[s]=0;
        q.add(s);
        visited[s] = true;
        while (!q.isEmpty()) {
            int curr = q.poll();

            for (Integer i : adj.get(curr)) {
                if (visited[i] == false) {
                    dist[i]=dist[curr]+1;
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
        return dist;
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
