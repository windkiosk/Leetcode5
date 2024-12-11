package leetcode_problems;

import java.util.Deque;
import java.util.LinkedList;

public class P91_DecodeWays {

    public static void main(String[] args) {
        P91_DecodeWays decodeWays = new P91_DecodeWays();

        System.out.println(decodeWays.numDecodingsBfs("12"));

        System.out.println(decodeWays.numDecodingsBfs("226"));

        System.out.println(decodeWays.numDecodingsBfs("06"));

        System.out.println(decodeWays.numDecodingsBfs("111111"));
    }

    public int numDecodingsBfs(String s) {
        Deque<Integer> startPos = new LinkedList<>();
        startPos.add(0);
        int len = s.length();
        int ret = 0;
        while (!startPos.isEmpty()) {
            int start = startPos.poll();
            if (start == len) {
                ret++;
                continue;
            } else {
                for (int end = start + 1; end <= len && end - start < 3; end++) {
                    String numString = s.subSequence(start, end).toString();
                    int v = Integer.valueOf(numString);
                    if (v < 1 || v > 26) {
                        break;
                    } else {
                        startPos.add(end);
                    }
                }
            }
        }

        return ret;
    }
}