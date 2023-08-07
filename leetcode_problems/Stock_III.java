package leetcode_problems;

public class Stock_III {

  public static void main(String[] args) {
    int[] p = new int[] {3, 3, 5, 0, 0, 3, 1, 4};
    //    int[] p = new int[] {1,2,3,4,5};
    //    int[] p = new int[] {7, 6, 4, 3, 1};
    //    System.out.println(slowWayMaxProfit(p));

    System.out.println(dpMaxProfit(p));
  }

  static int slowWayMaxProfit(int[] prices) {
    int maxProfit = 0;

    for (int split = 0; split < prices.length; split++) {
      int left = slowWayMaxProfit(prices, 0, split);
      int right = slowWayMaxProfit(prices, split + 1, prices.length - 1);
      if (left + right > maxProfit) {
        maxProfit = left + right;
      }
    }

    return maxProfit;
  }

  static int slowWayMaxProfit(int[] prices, int start, int end) {
    int min = Integer.MAX_VALUE;
    int maxProfit = 0;

    for (int i = start; i <= end; i++) {
      if (prices[i] < min) {
        min = prices[i];
      } else if (prices[i] - min > maxProfit) {
        maxProfit = prices[i] - min;
      }
    }

    return maxProfit;
  }

  static int dpMaxProfit(int[] prices) {
    int maxProfit = 0;
    if (prices.length <= 1) {
      return maxProfit;
    }

    int len = prices.length;
    int leftMin = prices[0];
    int[] leftProfit = new int[len];
    for (int i = 1; i < len; i++) {
      if (prices[i] < leftMin) {
        leftMin = prices[i];
        leftProfit[i] = leftProfit[i - 1];
      } else {
        leftProfit[i] = Math.max(prices[i] - leftMin, leftProfit[i - 1]);
      }
    }

    int rightMax= prices[len - 1];
    int[] rightProfit = new int[len + 1];
    for (int i = len - 2; i >= 0; i --) {
      if (prices[i] > rightMax) {
        rightMax = prices[i];
        rightProfit[i] = rightProfit[i + 1];
      } else {
        rightProfit[i] = Math.max(rightMax - prices[i], rightProfit[i + 1]);
      }
    }

    for (int i = 1; i < len; i ++) {
      maxProfit = Math.max(leftProfit[i] + rightProfit[i +1], maxProfit);
    }

    return maxProfit;
  }
}
