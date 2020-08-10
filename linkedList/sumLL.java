/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 */
package linkedList;
import java.util.Scanner;
public class sumLL {
    public static Node<Integer> add(Node<Integer> h1,Node<Integer> h2){
        if(h1==null){
            return h2;
        }
        if(h2==null){
            return h1;
        }
        if(h1==null && h2==null){
            return null;
        }
        Node<Integer> h=null,tail=null;
        int sum=0,carry=0;
        while(h1!=null&&h2!=null){
            sum=h1.data+h2.data+carry;
            if(sum<9){
                Node<Integer> currentNode=new Node<Integer>(sum);
                if(h==null){
                    h=currentNode;
                    tail=currentNode;
                }
                carry=0;
                tail.next=currentNode;
                tail=currentNode;
                h1=h1.next;
                h2=h2.next;
            }else{
                int r=sum%10;
                carry=sum/10;
                Node<Integer> currentNode=new Node<Integer>(r);
                if(h==null){
                    h=currentNode;
                    tail=currentNode;
                }
                tail.next=currentNode;
                tail=currentNode;
                h1=h1.next;
                h2=h2.next;
            }
            
        }
        while(h1!=null){
            sum=h1.data+carry;
            if(sum<9){
                Node<Integer> currentNode=new Node<Integer>(sum);
                carry=0;
                tail.next=currentNode;
                tail=currentNode;
                h1=h1.next;
            }else{
                int r=sum%10;
                carry=sum/10;
                Node<Integer> currentNode=new Node<Integer>(r);
                tail.next=currentNode;
                tail=currentNode;
                h1=h1.next;
            }
        }
        while(h2!=null){
            sum=h2.data+carry;
             if(sum<9){
                Node<Integer> currentNode=new Node<Integer>(sum);
                carry=0;
                tail.next=currentNode;
                tail=currentNode;
                 h2=h2.next;
            }else{
                int r=sum%10;
                carry=sum/10;
                Node<Integer> currentNode=new Node<Integer>(r);
                tail.next=currentNode;
                tail=currentNode;
                 h2=h2.next;
            }
        }
         if(carry!=0&&h1==null&&h2==null){
            Node<Integer> currentNode=new Node<Integer>(carry);
            tail.next=currentNode;
            tail=currentNode;
        }
        
        if(tail.next!=null){
            tail.next=null;
        }
        return h;
    }
    private static Node<Integer> sumOfTwoLinkedList(Node<Integer> head1,Node<Integer> head2) {
        return add(head1,head2);
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
        Node<Integer> head=sumOfTwoLinkedList(head1,head2);
        printLL(head);
    }
}