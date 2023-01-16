package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/*
time complexity: v+E
*/

public class CycleDetectionUsingKahns {
    public static void main(String args[]) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(4);
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList<Integer>());
        }
        addEdge(adj, 0, 1);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 0);
        addEdge(adj, 2, 3);
        Integer[] inDegree={0,0,0,0};
        printGraph(adj);
        inDegree = findInDegree(adj, inDegree);
        for (int i = 0; i < 4; i++) {
            System.out.println(i+":"+inDegree[i]);
        }

      System.out.println(  KahnUsingbfs(adj, 4, inDegree));
    }

    private static Integer[] findInDegree(ArrayList<ArrayList<Integer>> adj, Integer[] inDegree) {
        for (int i = 0; i < adj.size(); i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                inDegree[adj.get(i).get(j) ]= inDegree[adj.get(i).get(j) ]+1;
            }

        }
        return  inDegree;
    }

    private static boolean KahnUsingbfs(ArrayList<ArrayList<Integer>> adj, int n, Integer[] inDegree) {
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i=0;i<n;i++){
            if(inDegree[i]==0)
                q.add(i);
        }
        int count=0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            System.out.print(curr + " ");
            for (Integer i : adj.get(curr)) {
                inDegree[i]=inDegree[i]-1;
                if(inDegree[i]==0)
                    q.add(i);
                count++;
            }
        }
        return count!=n;
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
