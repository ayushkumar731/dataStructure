package linkedList;
import java.util.Scanner;
public class printReverseLLWithRecursive {

    public static void RevesePrint(Node<Integer> head){
        if(head==null){
            return;
        }
        RevesePrint(head.next);
        System.out.print(head.data+" ");
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
        RevesePrint(head);
    }
}