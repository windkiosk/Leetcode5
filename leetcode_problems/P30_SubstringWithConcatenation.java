package leetcode_problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P30_SubstringWithConcatenation {

    public static void main(String[] args) {
//        String str = "wordgoodgoodgoodbestword";
//        String[] words = new String[]{"word", "good", "best", "good"};
        String str = "aaaaaaaaaaaaaa";
        String[] words = new String[]{"aa", "aa"};
        P30_SubstringWithConcatenation p30SubstringWithConcatenation = new P30_SubstringWithConcatenation();
        List<Integer> ret = p30SubstringWithConcatenation.findSubstring(str, words);
        System.out.println(ret);
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ret = new ArrayList<>();
        if (words == null || words[0].isEmpty()) return ret;

        int size = words.length;
        int len = words[0].length();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int last = i, l = i, r = i + len, match = 0;
            map.clear();
            for (String word : words) {
                Integer c = map.get(word);
                int count = c == null ? 0 : c;
                map.put(word, count + 1);
            }
            while (r <= s.length()) {
                String str = s.substring(l, r);
                if (map.containsKey(str)) {
                    if (map.get(str) == 0) {
                        // pop the first one and try again
                        String first = s.substring(last, last + len);
                        int c = map.get(first);
                        map.put(first, c + 1);
                        match --;
                        last += len;
                    } else {
                        match++;
                        int count = map.get(str) - 1;
                        map.put(str, count);
                        if (match == size) {
                            ret.add(last);
                            // return the first word
                            String first = s.substring(last, last + len);
                            int c = map.get(first);
                            map.put(first, c + 1);
                            match --;
                            last += len;
                        }
                        l = r;
                        r += len;
                    }
                } else {
                    if (match > 0) {
                        // return words from last to l
                        for (int index = 0; index < match; index++) {
                            int pos = last + index * len;
                            String ss = s.substring(pos, pos + len);
                            Integer c = map.get(ss);
                            int count = c == null ? 0 : c;
                            map.put(ss, count + 1);
                        }
                        last = l;
                        r = l + len;
                    } else {
                        l = r;
                        last = r;
                        r = r + len;
                    }
                    match = 0;
                }
            }
        }

        return ret;
    }
}
