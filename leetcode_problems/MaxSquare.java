package problems;

public class MaxSquare {

  public static void main(String[] args) {
    char[][] a = new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'},
        {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
    MaxSquare maxSquare = new MaxSquare();
    System.out.println(maxSquare.maximalSquare(a));
  }

  public int maximalSquareDp(char[][] matrix) {
    int max = 0;
    int rows = matrix.length, cols = matrix[0].length;
    int ret[][] = new int[rows + 1][cols + 1];
    for (int i = 1; i <= rows; i++) {
      for (int j = 1; j <= cols; j++) {
        if (matrix[i - 1][j - 1] == '1') {
          ret[i][j] = Math.min(Math.min(ret[i][j - 1], ret[i - 1][j - 1]), ret[i - 1][j]) + 1;
          max = Math.max(max, ret[i][j]);
        }
      }
    }
    return max * max;
  }

  public int maximalSquare(char[][] matrix) {
    if (matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }

    int max = 0;

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] == '0') {
          continue;
        }

        for (int s = 1; s <= matrix.length; s++) {
          boolean flag = true;
          if (i + s - 1 >= matrix.length || j + s - 1 >= matrix[i].length) {
            flag = false;
          } else {
            for (int h = i; h < i + s; h++) {
              for (int k = j; k < j + s; k++) {
                if (matrix[h][k] == '0') {
                  flag = false;
                }
              }
            }
          }

          if (flag) {
            if (s > max) {
              max = s;
            }
          } else {
            break;
          }
        }
      }
    }

    return max * max;
  }
}
