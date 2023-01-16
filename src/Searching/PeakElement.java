package Searching;

public class PeakElement {
    public int peakElement(int[] arr,int n)
    {
        if(n==1)
            return 1;
        else{
            if(arr[0]>arr[1])
                return 1;
            if(arr[n-1]>arr[n-2])
                return 1;
            for(int i=1;i<n-1;i++){
                if(arr[i]>arr[i+1] && arr[i]>arr[i-1])
                    return 1;
            }
            return 0;
        }}

    public static void main(String[] args)
    {
        PeakElement majorelement
                = new PeakElement();
        int a[] = new int[] { 13,13 };

        // Function call
        int size = a.length;
        System.out.println( majorelement.peakElement(a, size));
    }
}
