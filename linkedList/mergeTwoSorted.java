/*
Merge Two Sorted LL

Given two linked lists sorted in increasing order. Merge them in such a way that the result list is also sorted (in increasing order).
Try solving with O(1) auxiliary space (in-place). You just need to return the head of new linked list, don't print the elements.
Input format :
Line 1 : Linked list 1 elements of length n (separated by space and terminated by -1)
Line 2 : Linked list 2 elements of length m (separated by space and terminated by -1)
Output format :
Merged list elements (separated by space)
Constraints :
1 <= n, m <= 10^4
Sample Input :
 2 5 8 12 -1
 3 6 9 -1
Sample Output :
 2 3 5 6 8 9 12 
*/
package linkedList;
import java.util.Scanner;
public class mergeTwoSorted {

    public static Node<Integer> mergeTwoSort(Node<Integer> head1,Node<Integer> head2){
        Node<Integer> head=null,tail=null;
        if(head1.data<=head2.data){
            head=head1;
            tail=head1;
            head1=head1.next;
        }else{
            head=head2;
            tail=head2;
            head2=head1.next;
        }
        while(head1!=null&&head2!=null){
            if(head1.data<=head2.data){
                tail.next=head1;
                tail=head1;
                head1=head1.next;
            }else{
                tail.next=head2;
                tail=head2;
                head2=head2.next;
            }
        }
        while(head1!=null){
            tail.next=head1;
            tail=head1;
            head1=head1.next;
        }
        while(head2!=null){
            tail.next=head2;
            tail=head2;
            head2=head2.next;
        }
        return head;
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
        Node<Integer> head1=takeInput();
        Node<Integer> head2=takeInput();
        Node<Integer> merged=mergeTwoSort(head1,head2);
        printLL(merged);   
    }
}