package leetcode_problems;

public class P63_PathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] grid) {
        if (grid[0][0] == 1) return 0;

        int m = grid.length, n = grid[0].length;
        int[][] ret = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // init the left-top corner
                if (i == 1 && j == 1) {
                    ret[i][j] = 1;
                } else if (grid[i - 1][j - 1] == 0) {
                    ret[i][j] = ret[i - 1][j] + ret[i][j - 1];
                } else {
                    ret[i][j] = 0;
                }
            }
        }

        return ret[m][n];
    }
}
