package leetcode_problems;

public class P5_LongestPalindrome {

    public static void main(String[] args) {
        String s = "caba";
        P5_LongestPalindrome p5LongestPalindrome = new P5_LongestPalindrome();
        System.out.println(p5LongestPalindrome.longestPalindrome(s));
    }

    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) return s;

        int len = s.length();
        int max = 1;
        String ret = s.substring(0, 1);

        // for empty, all true;
        boolean[] odd = new boolean[len];
        // for 1 char, all true;
        boolean[] even = new boolean[len];

        for (int i = 0; i < len; i++) {
            odd[i] = true;
            even[i] = true;
        }

        for (int j = 2; j <= len; j++) {
            if (j - max > 2) {
                // no need to continue;
                break;
            }

            for (int i = 0; i < len; i++) {
                char l = s.charAt(i);
                int pos = i + j - 1;
                if (pos >= len) {
                    break;
                }
                char r = s.charAt(pos);
                if (j % 2 == 0) {
                    if (even[i + 1] && l == r) {
                        even[i] = true;
                        if (max < j) {
                            max = j;
                            ret = s.substring(i, i + j);
                        }
                    } else {
                        even[i] = false;
                    }
                } else {
                    if (odd[i + 1] && l == r) {
                        odd[i] = true;
                        if (max < j) {
                            max = j;
                            ret = s.substring(i, i + j);
                        }
                    } else {
                        odd[i] = false;
                    }
                }
            }
        }

        return ret;
    }
}
