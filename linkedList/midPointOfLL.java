package linkedList;
import java.util.Scanner;
public class midPointOfLL {
    public static int midPoint(Node<Integer> head){
        Node<Integer> slow=head;
        Node<Integer> fast=head;
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        int n=slow.data;
        return n;
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
        int res=midPoint(head);
        System.out.println(res);
    }
}