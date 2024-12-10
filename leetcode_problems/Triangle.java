package problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Triangle {

  public static void main(String[] args) {
    Triangle triangle = new Triangle();

    // [[2],[3,4],[6,5,7],[4,1,8,3]]
    List<Integer> a = new ArrayList<>();
    a.add(2);

    List<Integer> b = new ArrayList<>();
    b.add(3);
    b.add(4);

    List<Integer> c = new ArrayList<>();
    c.add(6);
    c.add(5);
    c.add(7);

    List<Integer> d = new ArrayList<>();
    d.add(4);
    d.add(1);
    d.add(8);
    d.add(3);

    List<List<Integer>> t = new ArrayList<>();
    t.add(a);
    t.add(b);
    t.add(c);
    t.add(d);

    System.out.println(triangle.minimumTotal(t));
  }

  public int minimumTotal(List<List<Integer>> triangle) {
    if (triangle.size() == 1)
      return triangle.get(0).get(0);

    for (int i = 1; i < triangle.size(); i++) {
      List<Integer> last = triangle.get(i - 1);
      List<Integer> curr = triangle.get(i);
      for (int j = 0; j < curr.size(); j++) {
        int v = curr.get(j);
        if (j == 0) {
          curr.set(j, last.get(j) + v);
        } else if (j == curr.size() - 1) {
          curr.set(j, last.get(j - 1) + v);
        } else {
          // find the smaller one
          curr.set(j, Math.min(last.get(j - 1), last.get(j)) + v);
        }
      }
    }

    return Collections.min(triangle.get(triangle.size() - 1));
  }
}
