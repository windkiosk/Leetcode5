package leetcode_problems;

public class P150_PowXN {

    public static void main(String[] args) {
        P150_PowXN p150PowXN = new P150_PowXN();
        System.out.println(p150PowXN.myPow(0.5, -3));
    }

    private double binaryExp(double x, long n) {
        // Base case, to stop recursive calls.
        if (n == 0) {
            return 1;
        }

        // Handle case where, n < 0.
        if (n < 0) {
            return 1.0 / binaryExp(x, -1 * n);
        }

        // Perform Binary Exponentiation.
        // If 'n' is odd we perform Binary Exponentiation on 'n - 1' and multiply result with 'x'.
        if (n % 2 == 1) {
            return x * binaryExp(x * x, (n - 1) / 2);
        }
        // Otherwise we calculate result by performing Binary Exponentiation on 'n'.
        else {
            return binaryExp(x * x, n / 2);
        }
    }

    public double myPow(double x, int n) {
        return binaryExp(x, (long) n);
    }
}
