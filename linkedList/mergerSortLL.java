/**
 Merge Sort LL

Sort a given linked list using Merge Sort.
You don't need to print the elements, just sort the elements and return the head of updated LL.
Input format :
Linked list elements (separated by space and terminated by -1)
Output format :
Updated LL elements (separated by space)
Constraints :
1 <= Length of LL <= 1000
Sample Input 1 :
1 4 5 2 -1
Sample Output 1 :
1 2 4 5
 */
package linkedList;
import java.util.Scanner;
public class mergerSortLL {
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
    public static Node<Integer> mergeSort(Node<Integer> head){
        if(head==null||head.next==null){
            return head;
        }
        Node<Integer> slow=head;
        Node<Integer> fast=head;
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node<Integer> head2=slow.next;
        slow.next=null;
        Node<Integer> left=mergeSort(head);
        Node<Integer> right=mergeSort(head2);
        Node<Integer> sorted=mergeTwoSort(left,right);
        return sorted;
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
        Node<Integer> merged=mergeSort(head);
        printLL(merged);   
    }
}