package leetcode_problems;

import java.util.Arrays;

public class P150_HIndex {

    public static void main(String[] args) {
        System.out.println(hIndex(new int[]{3, 0, 6, 1, 5}));
    }

    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        int len = citations.length;
        int h = 0;
        for (int i = len - 1; i >= 0; i--) {
            // no need to check smaller citations
            if (citations[i] <= h) {
                break;
            }

            int curr = Math.min(citations[i], len - i);
            if (curr > h) {
                h = curr;
            }
        }
        return h;
    }
}
