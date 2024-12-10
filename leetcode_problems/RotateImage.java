package problems;

public class RotateImage {

  public static void main(String[] args) {
    int[][] image = new int[][]{{1,2,3}, {4,5,6},{7,8,9}};

    RotateImage rotateImage = new RotateImage();
    rotateImage.rotate(image);
  }

  public void rotate(int[][] matrix) {
    int n = matrix.length;
    if (n == 1) return;

    // swap diagonal
    for (int i = 0; i < n; i ++) {
      for (int j = 0; j < i; j ++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
      }
    }

    // swap horizontal
    for (int i = 0; i < n; i ++) {
      for (int j = 0; j < n / 2; j ++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[i][n - j - 1];
        matrix[i][n - j - 1] = temp;
      }
    }
  }
}
