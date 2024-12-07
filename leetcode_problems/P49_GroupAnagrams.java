import java.util.*;

public class P49_GroupAnagrams {
    public static void main(String[] args) {
        String[] ss = new String[]{"eat","tea","tan","ate","nat","bat"};
        List<List<String>> lists = groupAnagrams(ss);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ret = new LinkedList<>();
        if(strs == null || strs.length == 0) return ret;
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] array = s.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.get(key);
            if (list == null) {
                list = new ArrayList<>();
                map.put(key, list);
            }
            list.add(s);
        }

        for (List<String> list : map.values()) {
            ret.add(list);
        }
        return ret;
    }
}
