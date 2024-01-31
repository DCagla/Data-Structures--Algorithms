public class BinarySearchTree { 
    public Node root; 

    private class Node { 
        String word; 
        int count; 
        Node left, right; 
        public Node(String value) { 
            this.word = value; 
            this.count = 1; 
            this.left = this.right = null; 
        }    
    } 

    public void insert(String word) {
        root = insertRec(root, word);
    }

    private Node insertRec(Node root, String word) {
        if (root == null) {
            root = new Node(word);
            return root;
        }

        if (word.compareTo(root.word) < 0)
            root.left = insertRec(root.left, word);
        else if (word.compareTo(root.word) > 0)
            root.right = insertRec(root.right, word);
        else
            root.count++;

        return root;
    }

    public void printFrequencies() {
        printInOrder(root);
    }

    private void printInOrder(Node node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.println(node.word + " " + node.count);
            printInOrder(node.right);
        }
    }
}
