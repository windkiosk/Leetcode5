package leetcode_problems;

// https://leetcode.com/problems/ugly-number/
public class P263_UglyNumber {

  public static void main(String[] args) {
    System.out.println(isUgly(36));
  }

  public static boolean isUgly(int n) {
    while (n > 1) {
      if (n % 2 == 0) n /= 2;
      else if (n % 3 == 0) n /= 3;
      else if (n % 5 == 0) n /= 5;
      else return false;
    }
    return n == 1;
  }
}
