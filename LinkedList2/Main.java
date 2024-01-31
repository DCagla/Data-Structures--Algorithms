public class Main {
    private static class Node {
        int data;
        Node next;

        public Node(int n){
            this.data = n;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(9);
        head.next = new Node(9);
        head.next.next = new Node(9);
        head.next.next.next = new Node(9);

        System.out.print("Initial List: ");
        printList(head);

        head = add(head, 5);
        System.out.print("\nModified List: ");
        printList(head);
    }

    public static Node add(Node head, int number) {
        int carry = addRecursive(head, number);
        if (carry > 0) {
            Node newHead = new Node(carry);
            newHead.next = head;
            head = newHead;
        }
        return head;
    }

    private static int addRecursive(Node node, int number) {
        if (node == null) {
            return number;
        }

        int carry = addRecursive(node.next, number);

        int sum = node.data + carry;
        node.data = sum % 10;
        return sum / 10;
    }

    public static void printList(Node node){
        while (node != null) {
            System.out.print(node.data);
            if(node.next != null) System.out.print(" -> ");
            node = node.next;
        }
    }
}
