package Stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class NextGreaterElement {
    public static ArrayList<Integer> nextGreater(int arr[],int n) {
        ArrayList<Integer> al = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        for (int i = n-1; i >= 0; i--) {
            if (s.empty()) {
                al.add(-1);
                s.push(arr[i]);
            } else {
                if (s.peek() > arr[i]) {
                    al.add( s.peek());
                } else {
                    while (s.empty() == false && s.peek() <= arr[i])
                        s.pop();
                    if (s.empty()) {
                        al.add( -1);
                    } else {
                        al.add( s.peek());
                    }
                }
                s.push(arr[i]);
            }
        }
        Collections.reverse(al);
        return al;
    }
    public static void main (String[] args) {

        int[] arr=new int[]{5,15,10,8,6,12,9,18};
            ArrayList<Integer> al = nextGreater(arr,arr.length);
            for (int i = 0; i < arr.length; i++) {
                System.out.print(al.get(i)+" ");
            }

    }

}
