package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversalLineByLineMethod2 {
    void printlevel(Node n) {
        if (n == null) {
            return;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(n);

        while (q.size() > 0) {
            int count = q.size();
            for (int i = 0; i < count; i++) {
                Node curr = q.poll();
                System.out.print(curr.key);

                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            System.out.println();
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
        LevelOrderTraversalLineByLineMethod2 LevelOrderTraversal=new LevelOrderTraversalLineByLineMethod2();

        LevelOrderTraversal.printlevel(root);
    }
}
