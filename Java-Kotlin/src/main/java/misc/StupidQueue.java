package misc;

public class StupidQueue<T> {

    private static class QueueNode<T> {
        T data;
        QueueNode<T> next;

        public QueueNode(T data) {
            this.data = data;
        }
    }
    private QueueNode<T> first;

    private QueueNode<T> last;

    public void add(T data) {
        QueueNode<T> node = new QueueNode<>(data);
        if (last != null) {
            last.next = node;
        }
        last = node;
        if (first == null) {
            first = last;
        }
    }

    public T remove() {
        if (first == null) {
            throw new RuntimeException("The queue is empty");
        }
        T data = first.data;
        first = first.next;
        if (first == null) {
            last = null;
        }
        return data;
    }

    public T peek() {
        if (first == null) {
            throw new RuntimeException("The queue is empty");
        }
        return first.data;
    }

    public boolean isEmpty() {
        return first == null;
    }
}
