package Searching;

import java.util.HashMap;

public class SquareRoot {
    public int[] twoRepeated(int arr[], int N) {
        int[] res = new int[2];
        int j=0;
        HashMap<Integer, Integer> h = new HashMap<Integer,Integer>();
        for (int i = 0; i <arr.length; i++) {
            h.put(arr[i],h.getOrDefault(arr[i],0)+1);
            if(h.get(arr[i])==2) {
                res[j] = arr[i];
                System.out.println(res[j]);
                j++;
                if(j==2) break;
            }
        }
return res;
    }

    public static void main(String[] args)
    {
        SquareRoot majorelement
                = new SquareRoot();
        int a[] = new int[] { 1,3,3,2,1,13 };

        // Function call
        int size = a.length;
         majorelement.twoRepeated(a, size);
    }
}