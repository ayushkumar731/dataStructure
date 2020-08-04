package linkedList;
import java.util.Scanner;
public class deleteNode {

    public static Node<Integer> delete(Node<Integer> head, int pos){
        int count=0;
        Node<Integer> temp1=head,temp2=head.next;
        while(temp2!=null&&count<pos-1){
            count++;
            temp1=temp1.next;
            temp2=temp2.next;
        }
        if(temp2!=null){
            temp1.next=temp2.next;
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
        Node<Integer> head=takeInput();
        int pos=s.nextInt();
        head=delete(head,pos);
        printLL(head);
    }
}