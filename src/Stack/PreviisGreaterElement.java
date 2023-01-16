package Stack;

import java.util.ArrayList;
import java.util.Stack;

public class PreviisGreaterElement {
    public static ArrayList<Integer> printPrevGreater(int arr[], int n) {
        ArrayList<Integer> al = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (s.empty()) {
                al.add(i, -1);
                s.push(arr[i]);
            } else {
                if (s.peek() > arr[i]) {
                    al.add(i, s.peek());
                } else {
                    while (s.empty() == false && s.peek() <= arr[i])
                        s.pop();
                    if (s.empty()) {
                        al.add(i, -1);
                    } else {
                        al.add(i, s.peek());
                    }
                }
                s.push(arr[i]);
            }
        }
        return al;
    }

        public static void main (String[]args){

            int[] arr = new int[]{20, 30, 10, 5, 15};

            ArrayList<Integer> al = printPrevGreater(arr, arr.length);
            for (int i = 0; i < arr.length; i++) {
                System.out.print(al.get(i)+" ");
            }

        }
}