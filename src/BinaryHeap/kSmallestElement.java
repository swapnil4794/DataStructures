package BinaryHeap;

import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

public class kSmallestElement {
    public static void firstKElements(int arr[], int n, int k) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            maxHeap.add(arr[i]);
        }
        for (int i = k; i < n; i++) {
            if (  arr[i]>maxHeap.peek())
                continue;
            else {
                maxHeap.poll();
                maxHeap.add(arr[i]);
            }
        }

            System.out.print(maxHeap.peek());
    }

    public static void main(String[] args) {
        int arr[] = {11, 3, 2, 1, 15, 5, 4, 45, 88, 96, 50, 45};

        int size = arr.length;

        int k = 3;

        firstKElements(arr, size, k);
    }
}
