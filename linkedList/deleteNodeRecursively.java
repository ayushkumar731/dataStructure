/*
You have been given a linked list of integers. Your task is to write a function that deletes a node from a given position, 'pos'.
Note :
Assume that the Indexing for the linked list always starts from 0.

If the position is greater than or equal to the length of the linked list, you should return the same linked list without any change.
Illustration :
The following images depict how the deletion has been performed.

Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

The first line of each test case or query contains the elements of the linked list separated by a single space. 

The second line contains the integer value of 'pos'. It denotes the position in the linked list from where the node has to be deleted.
 Remember/Consider :
While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element
Output format :
For each test case/query, print the resulting linked list of integers in a row, separated by a single space.

Output for every test case will be printed in a seperate line.
Constraints :
1 <= t <= 10^2
0 <= N <= 10^5
pos >= 0
Time Limit: 1sec

Where 'N' is the size of the singly linked list.
Sample Input  :
3 4 5 2 6 1 9 -1
3
 */
package linkedList;
import java.util.Scanner;
public class deleteNodeRecursively {
    public static Node<Integer> deleteRecursively(Node<Integer> head, int pos){
        if(head==null&&pos>0){
            return head;
        }
        if(pos==0){
           return head=head.next;
        }else{
            Node<Integer> smallHead=deleteRecursively(head.next, pos-1);
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
        head=deleteRecursively(head,pos);
        printLL(head);
    }
}