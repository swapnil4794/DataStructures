package ImpQuestions;

public class TwoRepeatedElements {
    //{0,10,2,-10,-20}
//    1==[-10 -20 2 0 10]
//    2==[ -10 -20 -1 3 0]
    public  static int findMissing(int[] arr, int size) {

        // Your code here
        // You can add utility functions (if required)
        //segregate non positives
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (arr[i] <= 0) {
                //swap with j and increment j
                int tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
                j++;
            }
        }


        for (int k = j; k < size; k++) {
            int x = Math.abs(arr[k]);
            //System.out.println(" x "+ x + " k "+ k);
            if (x - 1 + j < arr.length && arr[x - 1 + j] > 0) {
                arr[x - 1 + j] = -arr[x - 1 + j];
            }
        }


        for (int l = j; l < arr.length; l++) {
            if (arr[l] > 0) {
                return l + 1 - j;
            }
        }
        return arr.length + 1 - j;


    }

    public static void main(String[] args) {
       int op= findMissing(new int[]{-10, 0, 2, 10, -30}, 5);
        System.out.println(" ans "+ op);
    }

}
