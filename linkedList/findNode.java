/*
Find a Node in Linked List
Send Feedback
You have been given a singly linked list of integers. Write a function that returns the index/position of an integer data denoted by 'N'(if it exists). -1 otherwise.
Note :
Assume that the Indexing for the singly linked list always starts from 0.
Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

The first line of each test case or query contains the elements of the singly linked list separated by a single space. 

The second line contains the integer value 'N'. It denotes the data to be searched in the given singly linked list.
Remember/Consider :
While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element.
Output format :
For each test case/query, print the index/position of 'N' in the singly linked list. -1, otherwise.

Output for every test case will be printed in a seperate line.
 Constraints :
1 <= t <= 10^2
0 <= M <= 10^5
Time Limit: 1sec

Where 'M' is the size of the singly linked list.
Sample Input  :
3 4 5 2 6 1 9 -1
5
Sample Output :
2
Sample Input  :
10 20 30 40 50 60 70 -1
6
Sample Output :
-1
*/
package linkedList;
import java.util.Scanner;
public class findNode {
    public static int find(Node<Integer> head,int data){
        int count=0;
        Node<Integer> temp=head;
        while(temp!=null){
            if(temp.data==data){
                break;
            }
            count++;
            temp=temp.next;
        }
        if(temp==null){
            return -1;
        }
        return count;
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
        int data=s.nextInt();
        System.out.println(find(head,data));
    }
}