package leetcode_problems;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
public class P122_Stock_II {

    public static void main(String[] args) {
        int[] p = new int[]{7, 1, 5, 3, 6, 4};
        //    int[] p = new int[]{1,2,3,4,5};
        //    int[] p = new int[]{7,6,4,3,1};
        System.out.println(maxProfit(p));
    }

    public static int maxProfit(int[] prices) {
        int profit = 0;
        int min = Integer.MAX_VALUE;

        for (int v : prices) {
            if (v > min) {
                profit += v - min;
            }
            min = v;
        }

        return profit;
    }
}
