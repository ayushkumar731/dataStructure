/*
Queue Using LL

You need to implement a Queue class using linked list.
All the required data members should be private.
Implement the following public functions :
1. Constructor -
Initialises the data members.
2. enqueue :
This function should take one argument of type T and has return type void. This function should insert an element in the queue. Time complexity should be O(1).
3. dequeue :
This function takes no input arguments and has return type T. This should removes the first element which is entered and return that element as an answer. Time complexity should be O(1).
4. front :
This function takes no input arguments and has return type T. This should return the first element which is entered and return that element as an answer. Time complexity should be O(1).
5. size :
Return the size of stack i.e. count of elements which are present ins stack right now. Time complexity should be O(1).
6. isEmpty :
Checks if the queue is empty or not. Return true or false.
 */
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