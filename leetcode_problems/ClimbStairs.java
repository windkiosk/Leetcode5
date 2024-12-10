package problems;

public class ClimbStairs {

  public static void main(String[] args) {
    ClimbStairs climbStairs = new ClimbStairs();
    System.out.println(climbStairs.climbStairs(2));
  }

  public int climbStairs(int n) {
    if (n == 1) return 1;

    int curr = 1;
    int second = 0;
    int third = 0;

    for (int i = 0; i < n; i ++) {
      second += curr;
      third += curr;

      // move arrow
      curr = second;
      second = third;
      third = 0;
    }

    return curr;
  }

}
