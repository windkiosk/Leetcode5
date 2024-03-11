package leetcode_problems;

// https://leetcode.com/problems/maximum-number-of-achievable-transfer-requests/
public class P1601_MaximumNumberAchievable3 {

  static int maxRequests = 0;

  public static void main(String[] args) {
    int n = 5;
    int[][] requests = new int[][] {{0, 1}, {1, 0}, {0, 1}, {1, 2}, {2, 0}, {3, 4}};
    //    int[][] requests = new int[][] {{1,2},{1,2},{2,2},{0,2},{2,1},{1,1},{1,2}};
    //    int[][] requests = new int[][] {{2,0},{0,0},{1,2},{0,0}};
    //    int[][] requests = new int[][] {{3,0},{2,2},{3,0},{0,1},{1,2},{0,0},{3,2},{1,2}};
    System.out.println("DB-Test " + maximumRequests(5, requests));
  }

  public static int maximumRequests(int n, int[][] requests) {
    int maxRequest = 0;
    for (int mask = 0; mask < 1 << requests.length; mask++) {
      int bigCount = Integer.bitCount(mask);
      if (bigCount <= maxRequest) {
        continue;
      }

      int[] inDegree = new int[n];
      int pos = requests.length - 1;
      for (int curr = mask; curr > 0; curr >>= 1, pos--) {
        if ((curr & 1) == 1) {
          inDegree[requests[pos][0]]--;
          inDegree[requests[pos][1]]++;
        }
      }

      boolean isEven = true;
      for (int degree : inDegree) {
        if (degree != 0) {
          isEven = false;
          break;
        }
      }

      if (isEven) {
        maxRequest = bigCount;
      }
    }

    return maxRequest;
  }
}
