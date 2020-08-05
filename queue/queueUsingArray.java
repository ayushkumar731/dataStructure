package queue;

class queueArray{
    private int[] data;
    private int size;
    private int front;
    private int rear;

    public queueArray(){
        data=new int[3];
        size=0;
        front=-1;
        rear=-1;
    }
    public int size(){
        return size;
    }
    public int top() throws queueEmptyException {
        if(size==0){
            throw new queueEmptyException();
        }
        return data[front];
    }
    public boolean isEmpty(){
        return size==0;
    }
    public void enqueue(int elem){
        if(size==data.length){
            doubleCapacity();
        }
        if(size==0){
            front=0;
        }
        rear=(rear+1)%data.length;
        data[rear]=elem;
        size++;
    }

    private void doubleCapacity() {
        int[]temp=data;
        data=new int[2*temp.length];
        for(int i=front;i<temp.length;i++){
            data[i]=temp[i];
        }
        for(int i=0;i<front-1;i++){
            data[i]=temp[i];
        }
    }
    public int dequeue() throws queueEmptyException {
        if(size==0){
            throw new queueEmptyException();
        }
        int temp=data[front];
        front=(front+1)%data.length;
        size--;
        if(size==0){
            front=-1;
            rear=-1;
        }
        return temp;
    }


}
public class queueUsingArray {
    public static void main(String[] args) throws queueEmptyException {
        queueArray q=new queueArray();
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