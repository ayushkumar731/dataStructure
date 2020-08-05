/*
Stack Using 2 Queues
Send Feedback
You need to implement a Stack class using two queues as its data members.
Only 2 data members should be there inside the class - two queues, which should be created dynamically and both should be public. Use the inbuilt queue.
Implement the following public functions :
1. Constructor -
Initialises both the data members.
2. push :
This function should take one argument of type T and has return type void. This function should insert an element in the stack. Time complexity should be O(1).
3. pop :
This function takes no input arguments and has return type T. This should removes the last element which is entered and return that element as an answer.
4. top :
This function takes no input arguments and has return type T. This should return the last element which is entered and return that element as an answer.
5. getSize :
Return the size of stack i.e. count of elements which are present ins stack right now. Time complexity should be O(1).
 */
package queue;
import java.util.Queue;
import java.util.LinkedList;
class stack<T>{
    private Queue<T> q1;
    private Queue<T> q2;
    public stack(){
        q1=new LinkedList<>();
        q2=new LinkedList<>();
    }
    public int size(){
        return q1.size();
    }
    public void push(T data){
        q1.add(data);
    }
    public T pop() throws queueEmptyException {
        if(q1.size() == 0) {
            throw new queueEmptyException();
        }
        while(!q1.isEmpty()){
            T data=q1.remove();
            if(q1.isEmpty()){
                while(!q2.isEmpty()){
                    q1.add(q2.remove());
                }
                return data;
            }
            q2.add(data);
        }
        return null;
    }
    public T top() throws queueEmptyException {
        if(q1.size() == 0) {
            throw new queueEmptyException();
        }
        while(!q1.isEmpty()){
            T data=q1.remove();
            q2.add(data);
            if(q1.isEmpty()){
                while(!q2.isEmpty()){
                    q1.add(q2.remove());
                }
                return data;
            } 
        }
        return null;
    }
}
public class stackUsingQueue {
    public static void main(String[] args) throws queueEmptyException {
        stack<Integer> st=new stack<>();
        st.push(10);
        st.push(32);
        st.push(35);
        st.push(37);
        st.push(39);
        st.push(40);
        System.out.println(st.pop());
        System.out.println(st.top());
        System.out.println(st.size());
    }
}