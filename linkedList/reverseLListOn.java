package linkedList;
import java.util.Scanner;
public class reverseLListOn {
    public static Node<Integer> ReverseLL(Node<Integer> head){
        if(head==null||head.next==null){
            return head;
        }
        Node<Integer> reverseHead=ReverseLL(head.next);
        Node<Integer> reverseTail=head.next;
        reverseTail.next=head;
        head.next=null;
        return reverseHead;
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
        head=ReverseLL(head);
        printLL(head);
    }
}