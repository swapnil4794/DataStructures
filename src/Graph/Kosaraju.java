package Graph;

import java.io.*;
import java.util.*;
import java.util.LinkedList;

class Kosaraju
{
    private int V;
    private LinkedList<Integer> adj[];

    Kosaraju(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) { adj[v].add(w); }

    void DFSUtil(int v,boolean visited[])
    {

        visited[v] = true;
        System.out.print(v + " ");

        int n;

        Iterator<Integer> i =adj[v].iterator();
        while (i.hasNext())
        {
            n = i.next();
            if (!visited[n])
                DFSUtil(n,visited);
        }
    }

    Kosaraju getTranspose()
    {
        Kosaraju g = new Kosaraju(V);
        for (int v = 0; v < V; v++)
        {
            Iterator<Integer> i =adj[v].listIterator();
            while(i.hasNext())
                g.adj[i.next()].add(v);
        }
        return g;
    }

    void fillOrder(int v, boolean visited[], Stack stack)
    {
        visited[v] = true;

        Iterator<Integer> i = adj[v].iterator();
        while (i.hasNext())
        {
            int n = i.next();
            if(!visited[n])
                fillOrder(n, visited, stack);
        }

        stack.push(new Integer(v));
    }

    int printSCCs(int V,ArrayList<ArrayList<Integer>> adj)
    {
        boolean[] vis=new boolean[V];
        Stack<Integer> s =new Stack<Integer>();
        int ans=0;
        for(int i=0;i<V;i++){
            if(vis[i]==false){
                dsfutil(V,adj,vis,i,s);
            }
        }
        ArrayList<ArrayList<Integer>> adj1=getTranspose(V, adj);

        for (int i = 0; i < V; i++)
            vis[i] = false;

        while (s.empty() == false)
        {
            int v = (int)s.pop();

            if (vis[v] == false){
                ans++;
                dsfutil(V,adj1,vis,v,s);
            }
        }
        return ans;
    }
    public ArrayList<ArrayList<Integer>> getTranspose(int V, ArrayList<ArrayList<Integer>> adj)
    {
        ArrayList<ArrayList<Integer>> adj1=new  ArrayList<ArrayList<Integer>>();
        for(int i=0;i<V;i++) {
            adj1.add(i,new ArrayList<Integer>());
        }
            for(int i=0;i<V;i++){
            for(int a:adj.get(i)){
                adj1.get(a).add(i);
            }
        }
        return adj1;
    }
    public void dsfutil(int V, ArrayList<ArrayList<Integer>> adj,boolean[] vis,int s,Stack<Integer> stack)
    {
        vis[s]=true;
        for(int a:adj.get(s))
        {
            if(vis[a]==false){
                dsfutil(V,adj,vis,a,stack);
            }}
        stack.push(s);
    }

    public static void main(String args[])
    {
        Kosaraju g = new Kosaraju(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);

        System.out.println("Following are strongly connected components "+
                "in given graph ");
       // g.printSCCs(5,g);
    }
}
