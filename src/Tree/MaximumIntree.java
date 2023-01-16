package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumIntree {
    int maximum(Node n){
        if(n==null) {
            return Integer.MIN_VALUE;
        }
        Queue<Node> q=new LinkedList<Node>();
        q.add(n);
        int max=0;
        while(!q.isEmpty()) {
            Node curr=q.poll();
            if(curr.key>max)max=curr.key;
            if(curr.left!=null){
                q.add(curr.left);
            }
            if(curr.right!=null){
                q.add(curr.right);
            }
        }
        return max;
    }

    int maximumMethod2(Node n) {
        if (n == null) {
            return Integer.MIN_VALUE;
        }
        return Math.max(n.key,Math.max(maximumMethod2(n.left),maximumMethod2(n.right)));
    }
    /**
     * Time complexity O(n)
     * Space complexity :O(h) via method 2 (good fpr perfect tree)
     * Space complexity :o(w) via method 1:w=width(good fpr skewed)
     */
    public static void main(String args[]){
        Node root=new Node(10);
        root.left=new Node(60);
        root.right=new Node(30);
        root.left.left=new Node(40);
        //empty tree
        Node root1=null;
        MaximumIntree MaximumIntree=new MaximumIntree();

        System.out.println(MaximumIntree.maximum(root));
        System.out.println(MaximumIntree.maximumMethod2(root));

    }
}
