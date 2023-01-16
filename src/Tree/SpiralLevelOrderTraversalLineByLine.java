package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SpiralLevelOrderTraversalLineByLine {
    void printlevel(Node n) {
        if (n == null) {
            return;
        }
        Queue<Node> q = new LinkedList<Node>();
        Stack<Integer> s = new Stack<Integer>();
        boolean rev = false;
        q.add(n);
        while (!q.isEmpty()) {
            int count = q.size();
            for (int i = 0; i < count; i++) {
                Node curr = q.poll();
                if (rev) {
                    s.push(curr.key);
                } else {
                    System.out.print(curr.key);
                }
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            if (rev) {
                while (!s.isEmpty())
                System.out.print(s.pop());
            }
            System.out.println();
            rev = !rev;

        }
    }

    void printlevel2(Node n) {
        if (n == null) {
            return;
        }
        Stack<Node> s1 = new Stack<Node>();
        Stack<Node> s2 = new Stack<Node>();

        s1.push(n);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            while (!s1.isEmpty()){
                int count = s1.size();
            for (int i = 0; i < count; i++) {
                Node curr = s1.pop();
                System.out.print(curr.key);
                if (curr.left != null) {
                    s2.add(curr.left);
                }
                if (curr.right != null) {
                    s2.add(curr.right);
                }
            }
            System.out.println();
        }
            while (!s2.isEmpty()){
                int count = s2.size();
                for (int i = 0; i < count; i++) {
                    Node curr = s2.pop();
                    System.out.print(curr.key);
                    if (curr.left != null) {
                        s1.add(curr.left);
                    }
                    if (curr.right != null) {
                        s1.add(curr.right);
                    }
                }
                System.out.println();
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
        root.right.left=new Node(50);
        //empty tree
        Node root1=null;
        SpiralLevelOrderTraversalLineByLine LevelOrderTraversal=new SpiralLevelOrderTraversalLineByLine();

        LevelOrderTraversal.printlevel(root);
        LevelOrderTraversal.printlevel2(root);
    }
}
