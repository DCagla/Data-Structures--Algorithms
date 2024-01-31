package linkedlist;

public class MyStack<Type> {
    private DLinkedList<Type> list = new DLinkedList<>();

    public MyStack() {}

    public void push(Type item) {
        list.addLast(item);
    }
    public Type pop() {
        return list.removeLast();
    }
}
