package Searching;

public class CountOccurencesof1 {

    public static int countOnes(int arr[], int N){

        if(arr[0]==0) return 0;
        return lastOcur(arr,N,1);

    }

    public static int lastOcur(int arr[], int N,int k){
        int low=0;
        int high=N-1;
        int last=0;
        while(low<=high){
            int mid=(low+high)/2;
            if(k>arr[mid]) high=mid-1;
            else if(k<arr[mid]) low=mid+1;
            else if(mid==N-1 || arr[mid]!=arr[mid+1]) {
                last = mid;
                break;
            }
            else low=mid+1;
        }
        return last+1;
    }

    public static void main(String args[])
    {
        int arr[] = {1, 1, 1, 1, 0, 0}, n = 6;

        System.out.println(countOnes(arr, n));

    }

}
