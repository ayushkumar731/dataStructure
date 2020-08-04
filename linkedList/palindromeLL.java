/*
Palindrome LinkedList

You have been given a head to a singly linked list of integers. Write a function check to whether the list given is a 'Palindrome' or not.
 Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

First and the only line of each test case or query contains the the elements of the singly linked list separated by a single space.
 Remember/Consider :
While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element.
 Output format :
For each test case, the only line of output that print 'true' if the list is Palindrome or 'false' otherwise.
 Constraints :
1 <= t <= 10^2
0 <= M <= 10^5
Time Limit: 1sec

Where 'M' is the size of the singly linked list.
Sample Input 1 :
1
9 2 3 3 2 9 -1
Sample Output 1 :
true
Sample Input 2 :
-1
Sample Output 2 :
true
Explanation for the Sample Input 2 :
For the first query, it is pretty intuitive that the the given list is not a palindrome, hence the output is 'false'.

For the second query, the list is empty. An empty list is always a palindrome , hence the output is 'true'.
 */
package linkedList;
import java.util.Scanner;
public class palindromeLL {
    public static Node<Integer> reverse(Node<Integer> head){
        if(head==null||head.next==null){
            return head;
        }
        Node<Integer> smallHead=reverse(head.next);
        Node<Integer> reverseTail=head.next;
        reverseTail.next=head;
        head.next=null;
        return smallHead;
    }
    public static boolean palindrome(Node<Integer> head1){
        if(head1==null||head1.next==null){
            return true;
        }
        Node<Integer> slow=head1;
        Node<Integer> fast=head1;
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node<Integer> head2=slow.next;
        slow.next=null;
        head2=reverse(head2);
        while(head2!=null){
            if(head1.data!=head2.data){
                return false;
            }
            head1=head1.next;
            head2=head2.next;
        }
        return true;
    }
    public static Node<Integer> takeInput(){
        Node<Integer> head=null,tail=null;
        Scanner s=new Scanner(System.in);
        int data=s.nextInt();
        while(data!=-1){
            Node<Integer> currentNode=new  Node<Integer>(data);
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
        Node<Integer> head=takeInput();
        System.out.print(palindrome(head));
    }
}