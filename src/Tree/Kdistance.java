package Tree;

public class Kdistance {

    void kDistNodes(Node n,int k){
        if(n==null) {
            return ;
        }
        if(k==0){
            System.out.println(n.key);
        }
        kDistNodes(n.left,k-1);
        kDistNodes(n.right,k-1);
    }
    /**
     * Time complexity O(n)
     * Space complexity :number of nodes in stack at a  time =height of tree=h+1:O(h)
     */
    public static void main(String args[]){
        Node root=new Node(10);
        root.left=new Node(20);
        root.right=new Node(30);
        root.left.left=new Node(40);
        //empty tree
        Node root1=null;
        Kdistance Kdistance=new Kdistance();

        Kdistance.kDistNodes(root,2);
    }
}
