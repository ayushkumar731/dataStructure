package linkedList;
import java.util.Scanner;
public class findNodeRecursively {
    public static int findNode(Node<Integer> head,int n){
        if(head==null){
            return -1;
        }
        if(head.data==n){
            return 0;
        }
        int k=findNode(head.next, n);
        if(k==-1){
            return -1;
        }else{
            return 1+k;
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
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        Node<Integer> head=takeInput();
        int n=s.nextInt();
        System.out.print(findNode(head,n));
    }
}