class BinarySearchTree<T extends Comparable<T>> {
    Node<T> root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(T value) {
        root = insertRecursive(root, value);
    }

    private Node<T> insertRecursive(Node<T> current, T value) {
        if (current == null) {
            return new Node<>(value);
        }

        if (value.compareTo(current.data) < 0) {
            current.left = insertRecursive(current.left, value);
        } else if (value.compareTo(current.data) > 0) {
            current.right = insertRecursive(current.right, value);
        }

        return current;
    }

    public boolean search(T value) {
        return searchRecursive(root, value);
    }

    private boolean searchRecursive(Node<T> current, T value) {
        if (current == null) {
            return false;
        }
        if (value.equals(current.data)) {
            return true;
        }
        return value.compareTo(current.data) < 0 
               ? searchRecursive(current.left, value) 
               : searchRecursive(current.right, value);
    }

    public int countNodes() {
        return countNodesRecursive(root);
    }

    private int countNodesRecursive(Node<T> current) {
        if (current == null) {
            return 0;
        }
        return 1 + countNodesRecursive(current.left) + countNodesRecursive(current.right);
    }

    public static <T extends Comparable<T>> boolean checkBST(Node<T> node) {
        return checkBSTRecursive(node, null, null);
    }

    private static <T extends Comparable<T>> boolean checkBSTRecursive(Node<T> node, T min, T max) {
        if (node == null) {
            return true;
        }
        if ((min != null && node.data.compareTo(min) <= 0) || (max != null && node.data.compareTo(max) >= 0)) {
            return false;
        }
        return checkBSTRecursive(node.left, min, node.data) && checkBSTRecursive(node.right, node.data, max);
    }
}
