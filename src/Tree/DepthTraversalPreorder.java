package Tree;

public class DepthTraversalPreorder {
    void preorderTraversal(Node n){
        if(n!=null){
            System.out.println(n.key);
            preorderTraversal(n.left);
            preorderTraversal(n.right);
        }

    }

    /**
     * Time complexity O(n)
     * Space complexity :number of nodes in tack ata  time =height of tree=h+1:O(h)
     */


    public static void main(String args[]){
        Node root=new Node(10);
        root.left=new Node(20);
        root.right=new Node(30);
        root.left.left=new Node(40);
        //empty tree
        Node root1=null;
        DepthTraversalPreorder DepthTraversalInorder=new DepthTraversalPreorder();

        DepthTraversalInorder.preorderTraversal(root);
    }

}
