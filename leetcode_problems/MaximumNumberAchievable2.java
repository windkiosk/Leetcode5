package leetcode_problems;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/maximum-number-of-achievable-transfer-requests/
public class MaximumNumberAchievable2 {

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
    int[] degreeMap = new int[n];
    traversal(degreeMap, 0, 0, requests);
    return maxRequests;
  }

  static void traversal(int[] degreeMap, int index, int current, int[][] requests) {
    if (index == requests.length) {
      for (int degree : degreeMap) {
        if (degree != 0) {
          return;
        }
      }
      maxRequests = Math.max(current, maxRequests);
      return;
    }

    // go to next node directly
    traversal(degreeMap, index + 1, current, requests);

    degreeMap[requests[index][0]]--;
    degreeMap[requests[index][1]]++;

    current++;

    traversal(degreeMap, index + 1, current, requests);

    degreeMap[requests[index][0]]++;
    degreeMap[requests[index][1]]--;
  }
}
