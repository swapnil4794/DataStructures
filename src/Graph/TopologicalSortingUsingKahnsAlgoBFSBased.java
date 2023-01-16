package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/*
* time: o(v+e)
* space:
* */
public class TopologicalSortingUsingKahnsAlgoBFSBased {
    public static void main(String args[]) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(5);
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList<Integer>());
        }
        Integer[] inDegree = {0,0,0,0,0};
        addEdge(adj, 0, 3);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 4);
        addEdge(adj, 1, 3);
        addEdge(adj, 2, 3);
        printGraph(adj);
        inDegree = findInDegree(adj, inDegree);
        for (int i = 0; i < 5; i++) {
            System.out.println(i+":"+inDegree[i]);
        }

        KahnUsingbfs(adj, 5, 0,inDegree);
    }

    private static Integer[] findInDegree(ArrayList<ArrayList<Integer>> adj, Integer[] inDegree) {
        for (int i = 0; i < adj.size(); i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                inDegree[adj.get(i).get(j) ]= inDegree[adj.get(i).get(j) ]+1;
            }

        }
      return  inDegree;
    }

    private static void KahnUsingbfs(ArrayList<ArrayList<Integer>> adj, int n, int s, Integer[] inDegree) {
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i=0;i<n;i++){
            if(inDegree[i]==0)
                q.add(i);
        }
        while (!q.isEmpty()) {
            int curr = q.poll();
            System.out.print(curr + " ");
            for (Integer i : adj.get(curr)) {
               inDegree[i]=inDegree[i]-1;
               if(inDegree[i]==0)
                    q.add(i);
                }
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

    }
}
