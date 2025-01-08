package leetcode_problems;

public class P97_InterleavingString {

    public static void main(String[] args) {
//        String s1 = "aabcc";
//        String s2 = "dbbca";
//        String s3 = "aadbbcbcac";

        String s1 = "aaa";
        String s2 = "bbb";
        String s3 = "ababab";
        P97_InterleavingString p97InterleavingString = new P97_InterleavingString();
        System.out.println(p97InterleavingString.isInterleave(s1, s2, s3));
    }

    public boolean is_Interleave(String s1, int i, String s2, int j, String res, String s3) {
        if (res.equals(s3) && i == s1.length() && j == s2.length()) return true;
        boolean ans = false;
        if (i < s1.length()) ans |= is_Interleave(s1, i + 1, s2, j, res + s1.charAt(i), s3);
        if (j < s2.length()) ans |= is_Interleave(s1, i, s2, j + 1, res + s2.charAt(j), s3);
        return ans;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        return is_Interleave(s1, 0, s2, 0, "", s3);
    }


    public boolean is_Interleave(String s1, int i, String s2, int j, String s3, int k, int[][] memo) {
        if (i == s1.length()) {
            return s2.substring(j).equals(s3.substring(k));
        }
        if (j == s2.length()) {
            return s1.substring(i).equals(s3.substring(k));
        }
        if (memo[i][j] >= 0) {
            return memo[i][j] == 1 ? true : false;
        }
        boolean ans = false;
        if ((s3.charAt(k) == s1.charAt(i) && is_Interleave(s1, i + 1, s2, j, s3, k + 1, memo)) || (s3.charAt(k) == s2.charAt(j) && is_Interleave(s1, i, s2, j + 1, s3, k + 1, memo))) {
            ans = true;
        }
        memo[i][j] = ans ? 1 : 0;
        return ans;
    }

    public boolean isInterleaveMemory(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        int memo[][] = new int[s1.length()][s2.length()];
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                memo[i][j] = -1;
            }
        }
        return is_Interleave(s1, 0, s2, 0, s3, 0, memo);
    }
}
