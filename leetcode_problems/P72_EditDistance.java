package leetcode_problems;

public class P72_EditDistance {

    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        int[][] ret = new int[l1 + 1][l2 + 1];
        // init first row
        for (int i = 0; i < ret[0].length; i++) {
            ret[0][i] = i;
        }
        // int first column
        for (int i = 0; i < ret.length; i++) {
            ret[i][0] = i;
        }

        for (int i = 1; i < ret.length; i++) {
            for (int j = 1; j < ret[i].length; j++) {
                char c1 = word1.charAt(i - 1);
                char c2 = word2.charAt(j - 1);
                int cost = (c1 == c2 ? 0 : 1);
                ret[i][j] = Math.min(Math.min(ret[i - 1][j - 1] + cost, ret[i][j - 1] + 1),
                        ret[i - 1][j] + 1);
            }
        }

        return ret[l1][l2];
    }
}
