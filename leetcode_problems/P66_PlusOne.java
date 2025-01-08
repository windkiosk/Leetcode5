package leetcode_problems;

public class P66_PlusOne {

    public static void main(String[] args) {
        P66_PlusOne p66PlusOne = new P66_PlusOne();
        System.out.println(p66PlusOne.plusOne(new int[]{1, 2, 3}));
    }

    public int[] plusOne(int[] digits) {
        if (digits.length == 0)
            return digits;

        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int v = digits[i];
            digits[i] = (v + carry) % 10;
            carry = (v + carry) / 10;
        }

        if (carry < 1) {
            return digits;
        } else {
            int[] ret = new int[digits.length + 1];
            ret[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                ret[i + 1] = digits[i];
            }
            return ret;
        }
    }
}
