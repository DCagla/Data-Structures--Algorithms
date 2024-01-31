class Node<T extends Comparable<T>> {
    T data;
    Node<T> left, right;

    public Node(T value) {
        this.data = value;
        this.left = this.right = null;
    }
}
