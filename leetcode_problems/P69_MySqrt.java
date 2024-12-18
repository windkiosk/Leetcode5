package leetcode_problems;

public class P69_MySqrt {

    public static void main(String[] args) {
        P69_MySqrt p69MySqrt = new P69_MySqrt();
        System.out.println(p69MySqrt.mySqrt(2147395599));
    }

    public int mySqrt(int x) {
        if (x < 2)
            return x;

        int m, l = 2, r = x / 2;
        long num;
        while (l <= r) {
            m = l + (r - l) / 2;
            num = (long) m * m;
            if (num == x) {
                return m;
            } else if (num > x) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return r;
    }
}
