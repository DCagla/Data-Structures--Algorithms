package linkedlist;

public class MyQueue<Type> {
    private DLinkedList<Type> list = new DLinkedList<>();

    public MyQueue() {}

    public void enqueue(Type item) {
        list.addLast(item);
    }
    public Type dequeue() {
        return list.removeFirst();
    }
}