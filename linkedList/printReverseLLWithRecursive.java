/*
Print Reverse LinkedList
Send Feedback
You have been given a singly linked list of integers. Write a function to print the list in a reverse order.
To explain it further, you need to start printing the data from the tail and move towards the head of the list, printing the head data at the end.
Note :
You can’t change any of the pointers in the linked list, just print it in the reverse order.
 Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

The first and the only line of each test case or query contains the elements of the singly linked list separated by a single space.
Remember/Constraints :
While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element.
Output format :
For each test case, print the singly linked list of integers in a reverse fashion, in a row, separated by a single space.

Output for every test case will be printed in a seperate line.
 Constraints :
1 <= t <= 10^2
0 <= M <= 10^3
Time Limit: 1sec

Where 'M' is the size of the singly linked list.
Sample Input 1 :
1 2 3 4 5 -1
Sample Output 1 :
5 4 3 2 1
Sample Input 2 :
1 2 3 -1
10 20 30 40 50 -1
Sample Output 2 :
3 2 1
50 40 30 20 10
 */
package linkedList;
import java.util.Scanner;
public class printReverseLLWithRecursive {

    public static void RevesePrint(Node<Integer> head){
        if(head==null){
            return;
        }
        RevesePrint(head.next);
        System.out.print(head.data+" ");
    }
    public static Node<Integer> takeInput(){
        Scanner s=new Scanner(System.in);
        int data=s.nextInt();
        Node<Integer> head=null,tail=null;

        while(data!=-1){
            Node<Integer> currentNode=new Node<Integer>(data);
            if(head==null){
                head=currentNode;
                tail=currentNode;
            }else{
                tail.next=currentNode;
                tail=currentNode;
            }
            data=s.nextInt();
        }
        return head;
    }
    
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        Node<Integer> head=takeInput();
        RevesePrint(head);
    }
}