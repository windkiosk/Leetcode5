package leetcode_problems;

public class P121_BuySellStock {
    
    public int maxProfit(int[] prices) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int v : prices) {
            if (v < min) {
                min = v;
            } else if (v - min > max) {
                max = v - min;
            }
        }
        return max;
    }
}
