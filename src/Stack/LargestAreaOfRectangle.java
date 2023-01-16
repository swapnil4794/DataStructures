package Stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class LargestAreaOfRectangle {
    public static int getMaxArea(int arr[],int n){
        ArrayList<Integer> right = new ArrayList<>();
        ArrayList<Integer> left = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        Stack<Integer> s1 = new Stack<>();

        int max_area = 0;
        int area_with_top;
        //previous smaller element
        for (int i = 0; i < n; i++) {
            if (s.empty()) {
                left.add(i, -1);
                s.push(i);
            } else {
                if (arr[s.peek()] < arr[i]) {
                    left.add(i, s.peek());
                } else {
                    while (s.empty() == false && arr[s.peek()] >= arr[i])
                        s.pop();
                    if (s.empty()) {
                        left.add(i, -1);
                    } else {
                        left.add(i, s.peek());
                    }
                }
                s.push(i);
            }
        }

        //next smaller element
        for (int i = n-1; i >=0; i--) {
            if (s1.empty()) {
                right.add(n);
                s1.push(i);
            } else {
                if (arr[s.peek()] < arr[i]) {
                    right.add(i, s1.peek());
                } else {
                    while (s1.empty() == false && arr[s1.peek()] >= arr[i])
                        s1.pop();
                    if (s1.empty()) {
                        right.add(-1);
                    } else {
                        right.add(s1.peek());
                    }
                }
                s1.push(i);
            }
        }
        Collections.reverse(right);
        for(int i=0;i<n;i++){
            area_with_top=(right.get(i)-left.get(i)-1)*arr[i];
            max_area=Math.max(max_area,area_with_top);
        }

        return max_area;
        }

    public static void main (String[] args) {

        int[] arr=new int[]{6,2,4,5,4,1,6};

        System.out.print("Maximum Area: "+getMaxArea(arr,arr.length));

    }

}
