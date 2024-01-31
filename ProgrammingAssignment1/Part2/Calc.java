import java.util.Stack;
import java.util.Scanner;

public class Calc {

    private static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String input = sc.nextLine();

            if (input.equals("E")) {
                break;
            }

            try {
                int number = Integer.parseInt(input);
                stack.push(number);
            } catch (NumberFormatException e) {
                if (input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/")) {
                    if (stack.size() < 2) {
                        System.out.println("Error: Not enough operands for operation.");
                        continue;
                    }
                    int operand2 = stack.pop();
                    int operand1 = stack.pop();
                    switch (input) {
                        case "+":
                            stack.push(operand1 + operand2);
                            break;
                        case "-":
                            stack.push(operand1 - operand2);
                            break;
                        case "*":
                            stack.push(operand1 * operand2);
                            break;
                        case "/":
                            if (operand2 == 0) {
                                System.out.println("Error: Division by zero.");
                                stack.push(operand1);
                                stack.push(operand2);
                                continue;
                            }
                            stack.push(operand1 / operand2);
                            break;
                    }
                    System.out.println("Result is " + stack.peek());
                } else {
                    System.out.println("Invalid operator");
                }
            }
        }

        sc.close();
    }
}
