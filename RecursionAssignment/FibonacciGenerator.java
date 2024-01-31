public class FibonacciGenerator {

    public static void main(String[] args) {
        fibonacci(4);   
        fibonacci(10);     
    }

    public static void fibonacci(int n) {
        if (n <= 0) {
            return; 
        }

        for (int i = 0; i < n; i++) {
            System.out.print(computeFib(i));
            if (i < n - 1) {
                System.out.print(", ");
            } else {
                System.out.println(); 
            }
        }
    }

    private static int computeFib(int n) {
        if (n <= 1) {
            return n; 
        }
        return computeFib(n - 1) + computeFib(n - 2);
    }
}
