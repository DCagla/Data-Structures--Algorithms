import java.util.Stack;

public class PrefixToInfixConverter {

    public static void main(String[] args) {
        prefixToInfix("+*342"); 
        prefixToInfix("/+*3422"); 
        prefixToInfix("+-*+-*+-*1234567891"); 
    }

    public static void prefixToInfix(String formula) {
        Stack<String> stack = new Stack<>();

        for (int i = formula.length() - 1; i >= 0; i--) {
            char c = formula.charAt(i);

            if (Character.isDigit(c)) {
                stack.push(c + "");
            } else {
                String operand1 = stack.pop();
                String operand2 = stack.pop();

                String expression = "(" + operand1 + c + operand2 + ")";
                stack.push(expression);
            }
        }

        System.out.println(stack.pop());
    }
}
