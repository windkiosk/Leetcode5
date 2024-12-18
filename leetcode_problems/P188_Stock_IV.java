package leetcode_problems;

import java.util.Arrays;

public class P188_Stock_IV {

    public static void main(String[] args) {
        int[] p = new int[]{1, 2, 3, 0, 5, 6};
        P188_Stock_IV p188StockIv = new P188_Stock_IV();
        System.out.println(p188StockIv.maxProfit(3, p));
    }

    public int maxProfit(int k, int[] prices) {
        if (k == 0) return 0;

        int[] profit = new int[k + 1];
        int[] cost = new int[k + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);

        for (int price : prices) {
            for (int i = 0; i < k; i++) {
                cost[i + 1] = Math.min(cost[i + 1], price - profit[i]);
                profit[i + 1] = Math.max(profit[i + 1], price - cost[i + 1]);
            }
        }
        return profit[k];
    }
}
