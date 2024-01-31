package linkedlist;

public class Node<Type> {
    Type data;
    Node<Type> next;
    Node<Type> prev;

    Node(Type data) {
        this.data = data;
    }
}