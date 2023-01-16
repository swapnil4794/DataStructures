package Tree;

public class ChildrenSum {
    /**
     * Time complexity O(n)
     * Space complexity :O(h)
     */
    public static void main(String args[]) {
        Node root = new Node(50);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(20);
        //root.left.right = new Node(0);
        root.right.left = new Node(10);
        root.right.right = new Node(20);
        //empty tree
//        Node root1 = null;
//        Node root = new Node(50);
//        root.left = new Node(10);
//        root.right = new Node(40);
        ChildrenSum ChildrenSum = new ChildrenSum();

        //System.out.println(ChildrenSum.childrenSum(root));
        System.out.println(ChildrenSum.childrenSum(root));

    }

    private boolean childrenSum(Node n) {
        if (n == null || (n.right == null && n.left == null)) return true;
        int sum=0;
        if (n.right != null) {
            sum+= n.right.key;
        }
        if (n.left != null) {
            sum+= n.left.key;
        }
        return (n.key==sum && childrenSum(n.left) && childrenSum(n.right));
    }
}
