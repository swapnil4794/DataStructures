import java.util.*;

class Test {
    public static void main(String args[]) {
        int[] arr = {15, 10, 16, 20, 8, 9, 7, 50};
        int[] res= new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            while(!stack.empty() && stack.peek()<arr[i]) {
                stack.pop();
            }
            if(stack.isEmpty()){
                res[i] = Integer.MAX_VALUE;
            }
            else if(stack.peek()>=arr[i]){
                    res[i]=stack.peek();
                }
            stack.push(arr[i]);
        }
        for(int i=0;i<res.length;i++){
            System.out.println(arr[i]+"->  "+res[i]);
        }
    }
}
