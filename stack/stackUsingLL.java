package stack;
import linkedList.Node;

class stackLL<T>{
    private Node<T> head;
    private int size;
    public stackLL(){
        head=null;
        size=0;
    }
    public int size(){
        return size;
    }
    public T peek() throws stackEmptyException {
        if(size==0){
            throw new stackEmptyException();
        }
        return head.data;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public void push(T data){
        Node<T> currentData=new Node<T> (data);
        currentData.next=head;
        head=currentData;
        size++;
    }
    public T pop() throws stackEmptyException {
        if(size==0){
            throw new stackEmptyException();
        }
        T temp=head.data;
        head=head.next;
        size--;
        return temp;
    }
}
public class stackUsingLL {
    public static void main(String[] args) throws stackEmptyException, stackEmptyException {
        stackLL<Integer> st = new stackLL<Integer>();

        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);
        st.push(60);
        st.push(70);
        st.push(80);
        st.push(90);
        st.push(100);
        st.push(710);
        st.push(745);
        System.out.println(st.size());
        System.out.println(st.isEmpty());
        System.out.println(st.pop());
        System.out.println(st.peek());
    }

}