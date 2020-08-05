package stack;
import java.util.Stack;
import java.util.Scanner;
public class bracketremoval {
    private static int minimumBracket(String str) {
        Stack<Character> st=new Stack<>();
        if(str.length()%2!=0){
            return -1;
        }
        for(int i=0;i<str.length();i++){  
            if(str.charAt(i)=='}'&&!st.isEmpty()){
                if(st.peek()=='{'){
                    st.pop();
                }
            }else{
                st.push(str.charAt(i));
            }
        }
        int size=st.size();
        int n=0;
        while(!st.isEmpty()&&st.peek()=='{'){
            n++;
            st.pop();
        }
        return (size/2+n%2);
        
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        String str=s.nextLine();
        System.out.println(minimumBracket(str));
    }

   
}