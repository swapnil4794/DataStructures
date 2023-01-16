package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/*
time complexity: v+E
*/

public class CycleDetection {
    public static void main(String args[]) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(4);
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList<Integer>());
        }
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);

        printGraph(adj);
        boolean[] visited = new boolean[4];
        System.out.print(dfsRec(adj, 4, 0, visited, 0));
        System.out.println("bfs:" + bfs(adj, 4, 0));
        System.out.println(dfsdisjoinnt(adj, 4, visited));
    }

    private static boolean bfs(ArrayList<ArrayList<Integer>> adj, int n, int s) {
        Queue<Integer> q = new LinkedList<Integer>();
        boolean[] visited = new boolean[n];
        Integer[] parent = new Integer[n];
        q.add(s);
        parent[s] = -1;
        visited[s] = true;
        while (!q.isEmpty()) {
            int curr = q.poll();
            System.out.print(curr + " ");
            for (Integer i : adj.get(curr)) {

                if (visited[i] == false) {
                    visited[i] = true;
                    q.add(i);
                    parent[i] = curr;
                } else if (i != parent[curr])
                    return true;
            }
        }
        return false;
    }

    private static boolean dfsRec(ArrayList<ArrayList<Integer>> adj, int n, int s, boolean[] visited, int parent) {
        visited[s] = true;
        System.out.print(s + " ");

        for (Integer i : adj.get(s)) {
            if (visited[i] == false) {
                if (dfsRec(adj, n, i, visited, s) == true) return true;
            } else if (i != parent) return true;

        }
        return false;
    }

    private static boolean dfsdisjoinnt(ArrayList<ArrayList<Integer>> adj, int n, boolean[] visited) {


        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                if (dfsRec(adj, n, i, visited, -1) == true) return true;
            }


        }
        return false;
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
