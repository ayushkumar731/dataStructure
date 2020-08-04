/*
You have been given a singly linked list of integers, an integer value called 'data' and a position with the name 'pos.'
 Write a function to add a node to the list with the 'data' at the specified position, 'pos.'
Note :
Assume that the Indexing for the singly linked list always starts from 0.

If the position is greater than the length of the singly linked list, you should return the same linked list without any change.

Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

The first line of each test case or query contains the elements of the linked list separated by a single space. 

The second line contains the two integer values of 'data' and 'pos' separated by a single space, respectively
Reminder/Consider :
While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element.
Output format :
For each test case, print the resulting singly linked list of integers in a row, separated by a single space.

Output for every test case will be printed in a seperate line.
 Constraints :
1 <= t <= 10^2
0 <= N <= 10^5
pos >= 0
Time Limit: 1sec
Sample Input 1 :
3 4 5 2 6 1 9 -1
3 100
*/
package linkedList;
import java.util.Scanner;
public class insertNodeRecursive {
    public static Node<Integer> insertRecursive(Node<Integer> head,int data,int pos){
       if(pos>0&&head==null){
           return head;
       }
        if(pos==0){
            Node<Integer> currentNode=new Node<Integer>(data);
            currentNode.next=head;
            return currentNode;
        }else{
            
           Node<Integer> smallHead=insertRecursive(head.next, data, pos-1);
            head.next=smallHead;
            return head;
            
        }
       
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
    public static void printLL(Node<Integer> head){
        while(head!=null){
            System.out.print(head.data+" ");
            head=head.next;
        }
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        Node<Integer> head=takeInput();
        int pos=s.nextInt();
        int insertNo=s.nextInt();
        head=insertRecursive(head,insertNo,pos);
        printLL(head);
    }
}