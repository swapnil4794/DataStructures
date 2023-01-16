package Stack;

import java.util.ArrayList;
import java.util.Stack;

public class BalanceParanthesis {
        //Function to check if brackets are balanced or not.
        Stack<String> s=new Stack<String>();
    boolean ispar(String x)
    {
        int i=0;
        char[] ch=  x.toCharArray();
        while(i<ch.length){

            if(ch[i]=='{'||ch[i]=='(' || ch[i]=='['){
                s.push(Character.toString(ch[i]));
            }
            else if((ch[i]=='}' || ch[i]==')' ||  ch[i]==']')&& s.empty() )
                return false;

            else if(ch[i]=='}'&& s.peek().equals("{"))
                s.pop();
            else if(ch[i]==')'&& s.peek().equals("("))
                s.pop();
            else if(ch[i]==']'&& s.peek().equals("["))
                s.pop();
            i++;

        }
        return  s.empty()?true:false;
    }
    public static void main (String[] args) {

        String arr=")";
        BalanceParanthesis s=new BalanceParanthesis();
        System.out.print(s.ispar(arr));

    }

}
