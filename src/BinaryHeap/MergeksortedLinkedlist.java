package BinaryHeap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeksortedLinkedlist {
    class Node
    {
        int data;
        Node next;

        Node(int key)
        {
            data = key;
            next = null;
        }
    }
    Node mergeKList(Node[]arr,int K)
    {
        Node ans=new Node(-1);
        Node head=ans;
        PriorityQueue<Node> pq=new PriorityQueue<>(new Sort());
        for(int i=0;i<K;i++){
            pq.offer(arr[i]);
        }
        while(!pq.isEmpty()){
            Node curr=pq.poll();
            if(curr.next!=null)
                pq.offer(curr.next);
            ans.next=curr;
            ans=ans.next;

        }
        return head.next;
    }
    class Sort implements Comparator<Node> {
        public int compare(Node o,Node t)
        {
            return o.data-t.data;
        }

    }
   public static void main(String[] args){
       MergeksortedLinkedlist a=new MergeksortedLinkedlist();
       Node[] arr=new Node[5];

       a.mergeKList(arr,5);
   }

}
