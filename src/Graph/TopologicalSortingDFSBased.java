package Graph;

import java.util.ArrayList;
import java.util.Stack;

/*
 * time: o(v+e)
 * space:
 * */
public class TopologicalSortingDFSBased {
    public static void main(String args[]) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(5);
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList<Integer>());
        }
        Stack<Integer> stack = new Stack<Integer>();
        Integer[] inDegree = {0, 0, 0, 0, 0};
        addEdge(adj, 0, 1);
        addEdge(adj, 2, 4);
        addEdge(adj, 3, 4);
        addEdge(adj, 1, 3);
        addEdge(adj, 2, 3);
        printGraph(adj);
        boolean[] visited = new boolean[5];
        dfsRec(adj, 0, visited, stack);
        for(int i=0;i<5;i++){
            if(visited[i]==false)
                dfsRec(adj,i,visited,stack);
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }

    private static void dfsRec(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited, Stack<Integer> stack) {
        visited[s] = true;
        for (Integer i : adj.get(s)) {
            if (visited[i] == false)
                dfsRec(adj, i, visited, stack);
        }
        stack.push(s);
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
