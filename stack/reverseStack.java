/**
 Reverse Stack

Reverse a given Stack with the help of another empty stack. Two stacks will be given. Out of which first contains some integers and second one is empty. You need to reverse the first one using second stack. Change in the given first stack itself.
Note : You don't need to print or return the stack, just reverse the given stack and it will be printed internally.
Input format :
Line 1 : Size of Stack
Line 2 : Stack elements (separated by space)
Sample Input 1 :
4 
1 2 3 4     (4 is at top)
Sample Output 1 :
1 2 3 4    (1 is at top)
 */
package stack;
import java.util.Stack;
import java.util.Scanner;
public class reverseStack {
    private static void reverse(Stack<Integer> s1, Stack<Integer> s2) {
        if(s1.isEmpty()){
            return;
        }
        int temp=s1.pop();
        reverse(s1,s2);
        int n1=s1.size();
        for(int i=0;i<n1;i++){
            int x=s1.pop();
            s2.push(x);
        }
        s1.push(temp);
        int n2=s2.size();
        for(int i=0;i<n2;i++){
            int x=s2.pop();
            s1.push(x);
        }

    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        Stack<Integer> st=new Stack<Integer>();
        for(int i=0;i<n;i++){
            st.push(s.nextInt());
        }
        Stack<Integer> extra=new Stack<Integer>();
        reverse(st,extra);
        while(!st.isEmpty()){
            System.out.print(st.pop() +" ");
        }

    }

   
}