package stack;

class stackEmptyException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

}

class stackArray {
    private int[] data;
    private int topIndex;

    public stackArray() {
        data = new int[10];
        topIndex = -1;
    }

    public int size() {
        return topIndex + 1;
    }

    public boolean isEmpty() {
        return topIndex == -1;
    }

    public void push(int elem) {
        if (data.length - 1 == topIndex) {
            doublecapacity();
        }
        data[++topIndex] = elem;
    }

    private void doublecapacity() {
        int temp[] = data;
        data = new int[2 * data.length];
        for (int i = 0; i < temp.length; i++) {
            data[i] = temp[i];
        }
    }

    public int pop() throws stackEmptyException {
        if (topIndex == -1) {
            throw new stackEmptyException();
        }
        int temp = data[topIndex];
        topIndex--;
        return temp;
    }

    public int top() throws stackEmptyException {
        if (topIndex == -1) {
            throw new stackEmptyException();
        }
        return data[topIndex];
    }

}

public class stackUsingArray {
    public static void main(String[] args) throws stackEmptyException {
        stackArray st = new stackArray();
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
        try {
            System.out.println(st.pop());
        } catch (stackEmptyException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(st.top());
        
    }
}