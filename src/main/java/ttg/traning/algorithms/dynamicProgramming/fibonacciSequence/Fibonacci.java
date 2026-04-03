package ttg.traning.algorithms.dynamicProgramming.fibonacciSequence;

/**
 *
 * @author ttg
 */
public class Fibonacci {

    // Recursive function to calculate Fibonacci number
    public static int fibonacci1(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci1(n - 1) + fibonacci1(n - 2);
        }
    }

    // Optimized DP approach (using tabulation)
    public static int fibonacci2(int n) {
        if (n <= 1) {
            return n;
        }

        int[] fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n];
    }

    public static void main(String[] args) {
        int n = 10; // Calculate the first 10 Fibonacci numbers
        System.out.println("Fibonacci number at position " + n + " is: " + fibonacci2(n));
    }
}