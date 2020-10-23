package misc;

public class StupidStack<T> {

    private StackNode<T> top;

    public T pop() {
        if (top == null) {
            throw new RuntimeException("There is no element in the top position");
        }
        T data = top.data;
        top = top.next;
        return data;
    }

    public void push(T data) {
        StackNode<T> element = new StackNode<>(data);
        element.next = top;
        top = element;
    }

    public T peek() {
        if (top == null) {
            throw new RuntimeException("Empty stack!");
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    private static class StackNode<T> {
        T data;
        StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }
    }
}
