package queue;
import linkedList.Node;

class queueLL<T>{
    private Node<T> front;
    private Node<T> rear;
    private int size;
    private Node<T> head;

    public queueLL(){
        front=null;
        rear=null;
        size=0;
        head=null;
    }
    public int size(){
        return size;
    }
    public T top() throws queueEmptyException{
        if(size==0){
            throw new queueEmptyException();
        }
        return front.data;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public void enqueue(T elem){
        Node<T> currentNode=new Node<>(elem);
        if(front==null){
            front=currentNode;
            rear=currentNode;
        }else{
            rear.next=currentNode;
            rear=currentNode;
        }
        size++;
    }
    public T dequeue() throws queueEmptyException {
        if(size==0){
            throw new queueEmptyException();
        }
        T temp=front.data;
        front=front.next;
        if(front==null){
            rear=null;
        }
        size--;
        return temp;
    }

}
public class queueUsingLL {
    public static void main(String[] args) throws queueEmptyException {
        queueLL<Integer> q=new queueLL<>();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        q.enqueue(60);
        q.enqueue(70);
        System.out.println(q.dequeue());
        System.out.println(q.size());
        System.out.println(q.isEmpty());
        System.out.println(q.top());
    }
    
}