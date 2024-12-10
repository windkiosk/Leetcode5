package problems;

import java.util.HashMap;

public class StringMinWindow {

  public static void main(String[] args) {
    StringMinWindow stringMinWindow = new StringMinWindow();
    System.out.println(stringMinWindow.minWindow("ADOBECODEBANC", "CBA"));
  }

  public String minWindow(String s, String t) {
    if (s == null || t == null || s.length() < t.length()) {
      return "";
    }

    HashMap<Character, Integer> curr = new HashMap<>();
    HashMap<Character, Integer> target = new HashMap<>();
    for (char c : t.toCharArray()) {
      Integer count = target.get(c);
      if (count == null) {
        count = 0;
      }
      target.put(c, count + 1);
      curr.put(c, 0);
    }

    int[] ret = new int[2];
    int min = Integer.MAX_VALUE;
    int l = 0, r = 0, len = 0;

    while (r < s.length()) {
      char c = s.charAt(r);
      if (target.containsKey(c)) {
        int targetCount = target.get(c);
        int count = curr.get(c);
        if (count < targetCount) {
          len++;
        }
        curr.put(c, count + 1);
      }
      r++;
      while (len == t.length() && l <= r) {
        if (r - l < min) {
          ret[0] = l;
          ret[1] = r;
          min = r - l;
        }

        char lc = s.charAt(l);
        if (target.containsKey(lc)) {
          int count = curr.get(lc);
          count--;
          curr.put(lc, count);
          if (count < target.get(lc)) {
            len--;
          }
        }
        l++;
      }
    }

    return s.substring(ret[0], ret[1]);
  }
}
