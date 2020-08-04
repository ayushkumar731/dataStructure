package linkedList;

import java.util.Scanner;
class Node<T>{
    T data;
    Node<T> next;
    public Node(T data){
        this.data=data;
    }
}
public class lenghLinkedList {

    public static int length(Node<Integer> head){
        int count=0;
        while(head!=null){
            count++;
            head=head.next;
        }
        return count;
    }
    public static Node<Integer> takeInput(){
        Scanner s=new Scanner(System.in);
        Node<Integer> head =null,tail=null;
        int data=s.nextInt();
        while(data!=-1){
             Node<Integer> newNode=new Node<Integer>(data);
             if(head==null){
                 head=newNode;
                 tail=newNode;
             }
             else{
                 tail.next=newNode;
                 tail=newNode;
             }
             data=s.nextInt();
        }
        return head;
    }
    public static void main(String[] args) {
        Node<Integer> head=takeInput();
        System.out.println(length(head));
    }
}