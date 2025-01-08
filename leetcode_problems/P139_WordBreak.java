package leetcode_problems;

import java.util.*;

public class P139_WordBreak {

    public static void main(String[] args) {
        String w = "leetcode";
        List<String> list = Arrays.asList("leet", "code");

        P139_WordBreak p139WordBreak = new P139_WordBreak();
        System.out.println(p139WordBreak.wordBreak(w, list));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        set.addAll(wordDict);
        Map<String, Boolean> map = new HashMap<>();
        return wordBreakRecursive(s, set, map);
    }

    boolean wordBreakRecursive(String s, Set<String> set, Map<String, Boolean> map) {
        if (map.containsKey(s)) return map.get(s);
        if (set.contains(s)) return true;

        boolean ret = false;
        for (int i = 1; i < s.length(); i ++) {
            String sub = s.substring(0, i);
            if (set.contains(sub)) {
                String other = s.substring(i);
                if (wordBreakRecursive(other, set, map)) {
                    ret = true;
                    break;
                }
            }
        }
        map.put(s, ret);
        return ret;
    }
}
