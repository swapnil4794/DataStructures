package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversalLineByLine {
    void printlevel(Node n){
        if(n==null) {
            return ;
        }
        Queue<Node> q=new LinkedList<Node>();
        q.add(n);
        q.add(null);
        while(q.size()>1) {
            Node curr=q.poll();
            if(curr==null){
                System.out.println();
                q.add(null);

            }
           else {
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
                System.out.print(curr.key);
            }
        }
    }
    /**
     * Time complexity O(n)
     * Space complexity :O(n)/o(w):w=width
     */
    public static void main(String args[]){
        Node root=new Node(10);
        root.left=new Node(20);
        root.right=new Node(30);
        root.left.left=new Node(40);
        //empty tree
        Node root1=null;
        LevelOrderTraversalLineByLine LevelOrderTraversal=new LevelOrderTraversalLineByLine();

        LevelOrderTraversal.printlevel(root);
    }
}
