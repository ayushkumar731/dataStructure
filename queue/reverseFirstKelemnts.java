/*
Reverse first K elements
Send Feedback
Given a queue and an integer k, reverse first k elements. Return the updated queue.
Do the problem in O(n) complexity.
Input Format :
Line 1 : Integer N, Size of Queue
Line 2 : Queue Elements (separated by space)
Line 3 : Integer k
Output Format:
Updated Queue elements
Contraints :
1<= N <=10000
Sample Input 1:
5
1 2 3 4 5
3
Sample Output 1:
3 2 1 4 5
Sample Input 2:
7
3 4 2 5 6 7 8
7
Sample Output 2:
8 7 6 5 2 4 3
*/
package queue;
import java.util.Stack;
import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;
public class reverseFirstKelemnts {
    private static Queue<Integer> reverseKElements(Queue<Integer> q, int k) {
        if(q.isEmpty()||k==0){
            return q;
        }
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<k;i++){
            st.push(q.remove());
            
        }
        while(!st.isEmpty()){
            q.add(st.pop());
            
        }
        for(int i=0;i<q.size()-k;i++){
            q.add(q.remove());
            
        }
        return q;
    }
    public static void main(String[] args) {
        Scanner s=new Scanner (System.in);
        int n=s.nextInt();
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 0; i < n; i++){
			q.add(s.nextInt());
		}
		int k = s.nextInt();
		Queue<Integer> ans = reverseKElements(q,k);
		while(!ans.isEmpty()){
			System.out.print(ans.remove()+" ");
		}
    }

    
}