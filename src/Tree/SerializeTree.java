package Tree;

import java.util.ArrayList;

public class SerializeTree {
    int index=0;
    void serialize(Node n, ArrayList<Integer> arr){
        if(n==null) {
            arr.add(-1);
            return;
        }
            arr.add(n.key);
            serialize(n.left,arr);
            serialize(n.right,arr);
        }

    /**
     * Time complexity O(n)
     * Space complexity :n(nodes) + n+1(no of nulls)
     */


    public static void main(String args[]){
        Node root=new Node(10);
        root.left=new Node(20);
        root.right=new Node(30);
        root.left.left=new Node(40);//empty tree
        Node root1=null;
        SerializeTree DepthTraversalInorder=new SerializeTree();
ArrayList<Integer> arr=new ArrayList<>();
       DepthTraversalInorder.serialize(root,arr);
        System.out.println(DepthTraversalInorder.deserialize(arr).key);
    }

    private Node deserialize(ArrayList<Integer> arr) {
        if(arr.size()==index) return null;
        int val= arr.get(index);
        index++;
        if(val==-1) return null;
        Node root=new Node(val);
        root.left=deserialize(arr);
        root.right=deserialize(arr);
        return root;
    }

}
