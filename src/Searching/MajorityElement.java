package Searching;

public class MajorityElement {
    static int majorityElement(int a[], int size)
    {
        int  count=1;
        int maj_index=0;
        for(int i=1;i<size;i++){
            if(a[maj_index]==a[i]){
                count++;
            }
            else
                count--;
            if(count==0){
                maj_index=i;
                count=1;
            }
        }
        int count1=0;
        for(int i=0;i<size;i++){
            if(a[i]==a[maj_index])
                count1++;
        }
        if(count1>size/2)
            return a[maj_index];
        else
            return -1;
    }

    public static void main(String[] args)
    {
        MajorityElement majorelement
                = new MajorityElement();
        int a[] = new int[] { 1, 3, 3, 1, 2 };

        // Function call
        int size = a.length;
      System.out.println( majorelement.majorityElement(a, size));
    }
}
