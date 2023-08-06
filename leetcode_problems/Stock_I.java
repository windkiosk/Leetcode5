package leetcode_problems;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class Stock_I {

  public static void main(String[] args) {
    int[] p = new int[] {7, 1, 5, 3, 6, 4};
//    int[] p = new int[] {7,6,4,3,1};
    System.out.println(maxProfit(p));
  }

  public static int maxProfit(int[] prices) {
    int maxProfit = 0;
    int min = Integer.MAX_VALUE;

    for (int v : prices) {
      if (v < min) {
        min = v;
      } else if (v - min > maxProfit) {
        maxProfit = v - min;
      }
    }
    return maxProfit;
  }
}
