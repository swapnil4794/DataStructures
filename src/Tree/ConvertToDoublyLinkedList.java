package Tree;

public class ConvertToDoublyLinkedList {
    Node prev = null;

    Node inorderTraversal(Node n) {

        if (n == null) {
            return n;
        }
        Node head = inorderTraversal(n.left);
        if (prev == null) head = n;
        else {
            n.left = prev;
            prev.right = n;
        }
        prev = n;
        inorderTraversal(n.right);
        return head;
    }

    /**
     * Time complexity O(n)
     * Space complexity :O(h)
     */
    public static void main(String args[]) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        //empty tree
        Node root1 = null;
        ConvertToDoublyLinkedList DepthTraversalInorder = new ConvertToDoublyLinkedList();

        DepthTraversalInorder.inorderTraversal(root);
    }

}
