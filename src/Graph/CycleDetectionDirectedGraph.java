package Graph;

import java.util.ArrayList;
/*
time complexity: v+E
*/

public class CycleDetectionDirectedGraph {
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
        boolean[] recur = new boolean[4];
        System.out.print(dfsRec(adj, 0, visited, recur));
      //  System.out.println("bfs:" + bfs(adj, 4, 0));
        System.out.println(dfsdisjoinnt(adj, 4, visited,recur));
    }



    private static boolean dfsRec(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited, boolean[] recur) {
        visited[s] = true;
        recur[s]=true;
        for (Integer i : adj.get(s)) {
            if (visited[i] == false && dfsRec(adj, i, visited, recur)) {
                return true;
            } else if (recur[i]==true) return true;

        }
        recur[s]=false;
        return false;
    }

    private static boolean dfsdisjoinnt(ArrayList<ArrayList<Integer>> adj, int n, boolean[] visited, boolean[] recur) {


        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                if (dfsRec(adj, i, visited, recur) == true) return true;
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

    }
}
