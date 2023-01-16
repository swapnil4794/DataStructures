package Tree;

import java.util.ArrayList;

public class LCAOfTree {

    Node findLCA(Node n,int n1,int n2){
        ArrayList<Node> path1=new ArrayList<Node>();
        ArrayList<Node> path2=new ArrayList<Node>();
        if(findPath(n,path1,n1)==false||findPath(n,path2,n2)==false)
            return null;
        for(int i=0;i<path1.size()-1 && i<path2.size()-1;i++){
            if(path1.get(i + 1).key != path2.get(i + 1).key){
                return path1.get(i);
            }
        }

        return null;
    }

    private boolean findPath(Node n, ArrayList<Node> path1, int n1) {
        if(n==null) return false;
        path1.add(n);
        if(n.key==n1) return true;
        if(findPath(n.left,path1,n1) || findPath(n.right,path1,n1))
return true;
        path1.remove(path1.size()-1);
        return false;
    }

    /**
     * Time complexity O(n)
     * Space complexity :number of nodes in Stack at a  time =height of tree=h+1:O(h)
     */
    public static void main(String args[]){
        Node root=new Node(10);
        root.left=new Node(20);
        root.right=new Node(30);
        root.left.left=new Node(40);
        //empty tree
        Node root1=null;
        LCAOfTree HeightOfTree=new LCAOfTree();

        System.out.println(HeightOfTree.findLCA(root,30,40).key);
    }
}
