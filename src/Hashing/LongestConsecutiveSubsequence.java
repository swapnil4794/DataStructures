package Hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LongestConsecutiveSubsequence {
    public static void main(String args[]) {
        int arr[] = new int[]{3, 1, 2, 1, 4, -5, 4, 6, -1, -3};
        System.out.print(findLongest(arr,arr.length));
    }

    static int findLongest(int arr[], int n) {
        HashSet<Integer> s = new HashSet<>();
        int res = 0;

        for (int i = 0; i < n; i++)
            s.add(arr[i]);

        for (int i = 0; i < n; i++) {
            if (!s.contains(arr[i] - 1)) {
                int curr = 1;
                while (s.contains(curr + arr[i]))
                    curr++;

                res = Math.max(res, curr);
            }
        }
        return res;
    }
}
