package LinkedList;

public class AddTwoList {


      public static class ListNode {
          int val;
          ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode temp1=l1;
            ListNode temp2=l2;
            ListNode l =new ListNode();
            ListNode temp3=l;
            int carry =0;
            while(temp1!=null || temp2!=null){
                ListNode a;
                if(temp1==null){

                    int value= (temp2.val+carry)%10;
                    carry = (temp2.val+carry)/10;
                    a=new ListNode(value);
                }
                else if(temp2==null){

                    int value= (temp1.val+carry)%10;
                    carry = (temp1.val+carry)/10;
                    a=new ListNode(value);
                }
                else{

                    int value= (temp1.val+temp2.val+carry)%10;
                    carry=(temp1.val+temp2.val+carry)/10;
                    a=new ListNode(value);
                }
                temp3.next=a;
                temp3=temp3.next;
                temp1=temp1.next;
                temp2=temp2.next;

            }
            return l.next;
        }
    public static void main(String args[])
    {
        ListNode l1=new ListNode(2);
        ListNode head1=l1;
        l1.next=new ListNode(4);
        l1.next.next=new ListNode(3);

        ListNode l2=new ListNode(5);
        ListNode head2=l2;
        l2.next=new ListNode(6);
        l2.next.next=new ListNode(4);


        ListNode l3=addTwoNumbers(head1,head2);
        while(l3!=null){
            System.out.println(l3.val);
            l3=l3.next;
        }
    }
    }

