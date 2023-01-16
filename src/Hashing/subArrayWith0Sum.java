package Hashing;

import java.util.HashSet;

public class subArrayWith0Sum {
    public static void main(String args[]) {
        int arr[] = new int[]{3, 1, 2, 1, 4, 5, 4, 6, -1, -3};
        System.out.print(isSum0(arr));
    }

    private static boolean isSum0(int[] arr) {
        HashSet s = new HashSet();
        int pre_Sum = 0;
        for (int i = 0; i < arr.length; i++) {
            pre_Sum = pre_Sum + arr[i];
            if (pre_Sum == 0)
                return true;
            if (s.contains(pre_Sum)) return true;
            s.add(pre_Sum);
        }
        return false;
    }
}
