package Hashing;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWith01 {
    public static void main(String args[]) {
        int arr[] = new int[]{0, 1, 0, 0, 1, 1, 1, 0, 0, 0};
        System.out.print(isSum0(arr,0));
    }

    private static int isSum0(int[] arr,int sum) {
        Map<Integer,Integer> s = new HashMap<>();
        int longest=0;
        int pre_Sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) arr[i] = -1;
        }
        for (int i = 0; i < arr.length; i++) {
            pre_Sum = pre_Sum + arr[i];
            if (pre_Sum == sum )
                longest= i+1;
            if (!s.containsKey(pre_Sum))
                s.put(pre_Sum,i);
            if (s.containsKey(pre_Sum-sum))
                longest=Math.max(longest,i-s.get(pre_Sum-sum));
        }
        return longest;
    }
}
