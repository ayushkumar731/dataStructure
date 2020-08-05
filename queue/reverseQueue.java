/**
Reverse Queue

Given a queue of integers, reverse it without help of any explicit stack or queue. You need to change in the given queue itself.
Note : No need to return or print the queue.
Input format :
Line 1 : First Element - Size of Queue, Rest Elements - Elements Of Queue
Output format :
Queue elements
Sample Input :
4 1 2 3 4     (1 is at front)
Sample Output :
4 3 2 1    (4 is at front)
 */
package queue;
import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;
public class reverseQueue {
    private static void reverseQueue(Queue<Integer> input) {
        if(input.isEmpty()){
            return;
        }
        int temp = input.remove();
        reverseQueue(input);
        input.add(temp);

    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
		Queue<Integer> input = new LinkedList<>();
		for(int i = 0; i < n; i++) {
			input.add(s.nextInt());
		}
		reverseQueue(input);
		while(!input.isEmpty()) {
			System.out.print(input.remove() + " ");
		}
    }
}