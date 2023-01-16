package Deque;

public class CircularTour {
    public static void main(String[] args) {
        int arr[] = {20, 40, 30, 60, 60};
        int dist[] = {30, 10, 40, 40, 80};
        int k = 3;
        int start = tour(arr, dist);
        System.out.print("start:" + start);
    }

    private static int tour(int[] arr, int[] dist) {
        int start=0;
        int curr_petrol = 0;
        int prev_petrol = 0;
        for (int i = 0; i < arr.length; i++) {
            curr_petrol = curr_petrol + arr[i] - dist[i];
            if (curr_petrol < 0) {
                prev_petrol = curr_petrol;
                start = i + 1;
                curr_petrol = 0;
            }
        }
        return curr_petrol - +prev_petrol >= 0 ? start + 1 : -1;
    }
}