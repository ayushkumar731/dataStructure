/*
Stock Span

The span si of a stock’s price on a certain day i is the minimum number of consecutive days (up to the current day) the price of the stock has been less than its price on that ith day. If for a particular day, if no stock price is greater then just count the number of days till 0th day including current day.
For eg. if given price array is {3, 6, 8, 1, 2}, span for 4th day (which has price 2) is 2 because minimum count of consecutive days (including 4th day itself) from current day which has price less than 4th day is 2 (i.e. day 3 & 4). Similarly, span for 2nd day is 3 because no stock price in left is greater than 2nd day's price. So count is 3 till 0th day.
Given an input array with all stock prices, you need to return the array with corresponding spans of each day.
Note : Try doing it in O(n).
Input format :
Line 1 : Integer n, Arrays Size
Line 2 : Price for n days (separated by space). It can contain duplicate values`
Constraints:
Time Limit: 1 second
Size of input array lies in the range: [1, 1000000]
Output format :
Return an array that contain span for each day
Sample Input 1 :
8
60 70 80 100 90 75 80 120
Sample Output 1 :
1 2 3 4 1 1 2 8
Sample Input 2 :
 4
 1 1 1 1
Sample Output 2 :
1 1 1 1
 */
package stack;
import java.util.Stack;
import java.util.Scanner;
public class stockSpan {
    private static int[] span(int[] arr) {
       Stack<Integer> st=new Stack<>();
       int[] arr1=new int[arr.length];
       st.push(0);
       arr1[0]=1;
       for(int i=1;i<arr.length;i++){
           while(!st.isEmpty()&&arr[st.peek()]<arr[i]){
               st.pop();
           }
           if(st.isEmpty()){
               arr1[i]=i+1;
           }else{
               arr1[i]=i-st.peek();
           }
           st.push(i);
       }
       return arr1;
    }
    private static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=s.nextInt();
        }
         arr=span(arr);
        print(arr);
    }
}