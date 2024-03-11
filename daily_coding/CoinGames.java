package daily_coding;

import java.util.ArrayList;
import java.util.HashMap;

// https://www.geeksforgeeks.org/optimal-strategy-for-a-game-dp-31/
public class CoinGames {

  static ArrayList<Integer> arr = new ArrayList<>();
  static HashMap<String, Integer> memo_1st = new HashMap<>();
  static HashMap<String, Integer> memo_2nd = new HashMap<>();

  public static void main(String[] args) {
    arr.add(8);
    arr.add(15);
    arr.add(3);
    arr.add(7);
    System.out.println(bestValue(0, arr.size() - 1));
  }

  static int secValue(int i, int j) {
    String key = i + "," + j;

    if (memo_2nd.containsKey(key)) {
      return memo_2nd.get(key);
    }

    int ret;
    if (i == j) {
      ret = 0;
    } else if (j == i + 1) {
      ret = Math.min(arr.get(i), arr.get(j));
    } else {
      // check opponent's choice
      int left = arr.get(i) + secValue(i + 1, j);
      int right = arr.get(j) + secValue(i, j - 1);

      if (left > right) {
        // opponent chooses left
        ret = bestValue(i + 1, j);
      } else {
        // opponent chooses right
        ret = bestValue(i, j - 1);
      }
    }

    memo_2nd.put(key, ret);
    return ret;
  }

  static int bestValue(int i, int j) {
    String key = i + "," + j;
    if (memo_1st.containsKey(key)) {
      return memo_1st.get(key);
    }

    int ret;
    if (i == j) {
      ret = arr.get(i);
    } else if (j == i + 1) {
      ret = Math.max(arr.get(i), arr.get(j));
    } else {
     int left = arr.get(i) + secValue(i + 1, j);
     int right = arr.get(j) + secValue(i, j - 1);
     ret = Math.max(left, right);
    }
    memo_1st.put(key, ret);
    return ret;
  }
}
