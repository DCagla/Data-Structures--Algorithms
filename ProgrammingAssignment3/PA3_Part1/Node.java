import java.util.Stack;

class Node {
    char value;
    Node left, right;

    Node(char item) {
        value = item;
        left = right = null;
    }
}

public class ExpressionTree {

    public static Node buildTree(String postfix) {
        Stack<Node> stack = new Stack<>();
        Node t, t1, t2;

        for (int i = 0; i < postfix.length(); i++) {
            if (!Character.isLetterOrDigit(postfix.charAt(i))) {
                t = new Node(postfix.charAt(i));
                t1 = stack.pop();     
                t2 = stack.pop();
                t.right = t1;
                t.left = t2;
                stack.push(t);
            } else {
                t = new Node(postfix.charAt(i));
                stack.push(t);
            }
        }

        t = stack.peek();
        stack.pop();

        return t;
    }
}

