package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class leftViewofTree {
    int maxLevel = 0;

    void leftView(Node n, int level) {
        if (n == null) {
            return;
        }
        if (maxLevel < level) {
            System.out.println(n.key);
            maxLevel = level;
        }
        leftView(n.left, level + 1);
        leftView(n.right, level + 1);
    }

    void leftViewMethod2(Node n) {
        if (n == null) {
            return;
        }

        Queue<Node> q = new LinkedList<Node>();
        q.add(n);
        int count = 0;
        while (!q.isEmpty()) {
            count = q.size();
            for (int i = 0; i < count; i++) {
                Node curr = q.poll();
                if (i == 0) System.out.println(curr.key);
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
    }
    /**
     * Time complexity O(n)
     * Space complexity :O(h)/O(w)
     */


    public static void main(String args[]){
        Node root=new Node(10);
        root.left=new Node(20);
        root.right=new Node(30);
        root.left.left=new Node(40);
        //empty tree
        Node root1=null;
        leftViewofTree leftViewofTree=new leftViewofTree();

        leftViewofTree.leftView(root,1);
        leftViewofTree.leftViewMethod2(root);
    }

}
