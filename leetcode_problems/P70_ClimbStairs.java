package leetcode_problems;

public class P70_ClimbStairs {

    public static void main(String[] args) {
        P70_ClimbStairs p70ClimbStairs = new P70_ClimbStairs();
        System.out.println(p70ClimbStairs.climbStairs(2));
    }

    public int climbStairs(int n) {
        if (n == 1) return 1;

        int curr = 1;
        int second = 0;
        int third = 0;

        for (int i = 0; i < n; i++) {
            second += curr;
            third += curr;

            // move arrow
            curr = second;
            second = third;
            third = 0;
        }

        return curr;
    }

}
