package Tree;

public class DepthTraversalPostorder {
    void postorderTraversal(Node n){
        if(n!=null){
            postorderTraversal(n.left);
            postorderTraversal(n.right);
            System.out.println(n.key);
        }

    }
    /**
     * Time complexity O(n): we travel every node once and constant work is done
     * Space complexity :number of nodes in stack at a  time =height of tree=h+1:O(h)
     */
    public static void main(String args[]){
        Node root=new Node(10);
        root.left=new Node(20);
        root.right=new Node(30);
        root.left.left=new Node(40);
        //empty tree
        Node root1=null;
        DepthTraversalPostorder DepthTraversalInorder=new DepthTraversalPostorder();

        DepthTraversalInorder.postorderTraversal(root);
    }

}
