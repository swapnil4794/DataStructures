package Tree;

import java.util.Stack;

public class IterativePreorderTraversal {
    /**
     * Time complexity O(n)
     * Space complexity :O(n)
     */
    void inorderTraversal(Node n) {
        if(n==null) return ;
        Stack<Node> s = new Stack<>();
        s.add(n);
        while ( !s.isEmpty()) {
            Node curr=s.pop();
            System.out.println(curr.key);
            if(curr.right!=null) s.push(curr.right);
            if(curr.left!=null) s.push(curr.left);
        }

    }

    /**
     * Time complexity O(n)
     * Space complexity :number of nodes in stack at a  time =height of tree=h+1:O(h)
     */

    void inorderTraversalMethod2(Node n) {
        if (n == null) return;
        Node curr = n;
        Stack<Node> s = new Stack<>();
        while (curr != null || !s.isEmpty()) {
            while (curr != null) {
                System.out.println(curr.key);
                if(curr.right!=null)s.push(curr.right);
                 curr = curr.left;
            }
            if(!s.isEmpty())
            curr=s.pop();
        }
    }
    public static void main(String args[]) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        //empty tree
        Node root1 = null;
        IterativePreorderTraversal DepthTraversalInorder = new IterativePreorderTraversal();

        DepthTraversalInorder.inorderTraversal(root);
        DepthTraversalInorder.inorderTraversalMethod2(root);
    }

}
