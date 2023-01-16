package Hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LongestSubArrayWithGivenSum {
    public static void main(String args[]) {
        int arr[] = new int[]{3, 1, 2, 1, 4, -5, 4, 6, -1, -3};
        System.out.print(isSum0(arr,19));
    }

    private static int isSum0(int[] arr,int sum) {
        Map<Integer,Integer> s = new HashMap<>();
        int longest=0;
        int pre_Sum = 0;
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
