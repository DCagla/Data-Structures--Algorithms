import java.util.Stack;

public class PostfixToInfixConversion {

    public static void main(String[] args) {
        System.out.println(postfixToInfix("34*2+")); 
        System.out.println(postfixToInfix("3422*+/")); 
        System.out.println(postfixToInfix("1234567891+-*+-*+-*")); 
    }

    public static String postfixToInfix(String formula) {
        Stack<String> stack = new Stack<>();
        String[] tokens = formula.split("");

        for (String token : tokens) {
            if (isOperator(token)) {
                String operand2 = stack.pop();
                String operand1 = stack.pop();
                String subExpr = "(" + operand1 + token + operand2 + ")";
                stack.push(subExpr);
            } else {
                stack.push(token);
            }
        }

        return stack.pop();
    }
    private static boolean isOperator(String token) {
        return "+-*/".contains(token);
    }
}
