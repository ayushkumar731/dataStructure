/**
Brackets Balanced

Given a string expression, check if brackets present in the expression are balanced or not. Brackets are balanced if the bracket which opens last, closes first.
You need to return true if it is balanced, false otherwise.
Note: This problem was asked in initial rounds in Facebook
Sample Input 1 :
{ a + [ b+ (c + d)] + (e + f) }
Sample Output 1 :
true
Sample Input 2 :
{ a + [ b - c } ]
Sample Output 2 :
false
 */
package stack;
import java.util.Stack;
import java.util.Scanner;
public class bracketsBalances {
    private static boolean checkBracketBalanced(String str) {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='{'||str.charAt(i)=='['||str.charAt(i)=='('){
                st.push(str.charAt(i));
            }else if(str.charAt(i)=='}'||str.charAt(i)==']'||str.charAt(i)==')'){
                if(st.isEmpty()){
                    return false;
                }
                char ch=st.pop();
                if(ch=='{'&&str.charAt(i)=='}'){
                    continue;
                }else if(ch=='['&&str.charAt(i)==']'){
                    continue;
                }else if(ch=='('&&str.charAt(i)==')'){
                    continue;
                }else{
                    return false;
                }
            }
        }
        if(st.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        String str=s.nextLine();
        System.out.println(checkBracketBalanced(str));
    }    
}