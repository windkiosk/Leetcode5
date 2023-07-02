package leetcode_problems;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/maximum-number-of-achievable-transfer-requests/
public class MaximumNumberAchievable {

  static int maxRequests = 0;

  public static void main(String[] args) {
    int n = 5;
//    int[][] requests = new int[][] {{0, 1}, {1, 0}, {0, 1}, {1, 2}, {2, 0}, {3, 4}};
//    int[][] requests = new int[][] {{1,2},{1,2},{2,2},{0,2},{2,1},{1,1},{1,2}};
//    int[][] requests = new int[][] {{2,0},{0,0},{1,2},{0,0}};
    int[][] requests = new int[][] {{3,0},{2,2},{3,0},{0,1},{1,2},{0,0},{3,2},{1,2}};
    System.out.println("DB-Test " + maximumRequests(4, requests));
  }

  public static int maximumRequests(int n, int[][] requests) {
    Map<Integer, Integer> degreeMap = new HashMap<>();
    traversal(degreeMap, 0, 0, requests);
    return maxRequests;
  }
  static void traversal(Map<Integer, Integer> degreeMap, int index, int current, int[][] requests) {
    if (index >= requests.length) {
      return;
    }

    // go to next node directly
    traversal(degreeMap, index + 1, current, requests);

    updateDegreeMap(degreeMap, requests[index][0], requests[index][1]);
    current ++;
    if (degreeMap.size() == 0 && current > maxRequests) {
      maxRequests = current;
    }

    traversal(degreeMap, index + 1, current, requests);

    updateDegreeMap(degreeMap, requests[index][1], requests[index][0]);
  }

  private static void updateDegreeMap(Map<Integer, Integer> degreeMap, int from, int to) {
    int fromDegree = degreeMap.get(from) == null ? 0 : degreeMap.get(from);
    fromDegree--;
    if (fromDegree == 0) {
      degreeMap.remove(from);
    } else {
      degreeMap.put(from, fromDegree);
    }
    int toDegree = degreeMap.get(to) == null ? 0 : degreeMap.get(to);
    toDegree++;
    if (toDegree == 0) {
      degreeMap.remove(to);
    } else {
      degreeMap.put(to, toDegree);
    }
  }
}
