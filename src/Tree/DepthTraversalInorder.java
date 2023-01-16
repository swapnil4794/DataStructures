package Tree;

public class DepthTraversalInorder {
    void inorderTraversal(Node n){
        if(n!=null){
            inorderTraversal(n.left);
            System.out.println(n.key);
            inorderTraversal(n.right);
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
        DepthTraversalInorder DepthTraversalInorder=new DepthTraversalInorder();

        DepthTraversalInorder.inorderTraversal(root);
    }

}
