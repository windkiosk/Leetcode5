package leetcode_problems;

import java.util.HashSet;
import java.util.PriorityQueue;

// https://leetcode.com/problems/ugly-number-ii/
public class P264_UglyNumber2 {
  public static void main(String[] args) {
    System.out.println(nthUglyNumber(10));
    System.out.println(nthUglyNumberByHeap(10));
  }

  public static int nthUglyNumber(int n) {
    int ugly[] = new int[n];
    int i2 = 0, i3 = 0, i5 = 0;
    int next_multiple_of_2 = 2;
    int next_multiple_of_3 = 3;
    int next_multiple_of_5 = 5;
    int next_ugly_num = 1;

    ugly[0] = 1;

    for (int i = 1; i < n; i++) {
      next_ugly_num =
          Math.min(next_multiple_of_2, Math.min(next_multiple_of_3, next_multiple_of_5));

      ugly[i] = next_ugly_num;
      if (next_ugly_num == next_multiple_of_2) {
        i2 = i2 + 1;
        next_multiple_of_2 = ugly[i2] * 2;
      }
      if (next_ugly_num == next_multiple_of_3) {
        i3 = i3 + 1;
        next_multiple_of_3 = ugly[i3] * 3;
      }
      if (next_ugly_num == next_multiple_of_5) {
        i5 = i5 + 1;
        next_multiple_of_5 = ugly[i5] * 5;
      }
    }

    return next_ugly_num;
  }

  static int nthUglyNumberByHeap(int n) {
    HashSet<Long> seen = new HashSet();
    PriorityQueue<Long> heap = new PriorityQueue<Long>();
    seen.add(1L);
    heap.add(1L);

    long currUgly = 1L, newUgly;
    int[] primes = new int[] {2, 3, 5};
    for (int i = 1; i <= n; i++) {
      currUgly = heap.poll();
      for (int j : primes) {
        newUgly = currUgly * j;
        if (!seen.contains(newUgly)) {
          seen.add(newUgly);
          heap.add(newUgly);
        }
      }
    }

    return (int) currUgly;
  }
}
