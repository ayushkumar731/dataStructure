package linkedList;
import java.util.Scanner;

class DoubleNode{
    Node<Integer> head;
    Node<Integer> tail;
    DoubleNode(){}
    public  DoubleNode(Node<Integer> head,Node<Integer> tail){
        this.head=head;
        this.tail=tail;
    }
}
public class reverselinkedwithDoubleLL {
    public static DoubleNode ReverseLL(Node<Integer> head){
        DoubleNode ans;
        if(head==null||head.next==null){
            ans=new DoubleNode(head,head);
            return ans;
        }
        DoubleNode reverseHead=ReverseLL(head.next);
        reverseHead.tail.next=head;
        head.next=null;
        ans=new DoubleNode();
        ans.head=reverseHead.head;
        ans.tail=head;
        return ans;
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
        DoubleNode ans=ReverseLL(head);
        printLL(ans.head);
    }
}