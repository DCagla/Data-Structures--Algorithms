public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);
        bst.insert(7);
        bst.insert(12);
        bst.insert(18);

        System.out.println("Search 7: " + bst.search(7)); 
        System.out.println("Search 4: " + bst.search(4)); 

        System.out.println("Total nodes: " + bst.countNodes()); 

        System.out.println("Is BST: " + BinarySearchTree.checkBST(bst.root)); 
    }
}
