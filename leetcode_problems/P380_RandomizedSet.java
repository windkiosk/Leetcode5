package leetcode_problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class P380_RandomizedSet {
    public static void main(String[] args) {
        P380_RandomizedSet randomizedSet = new P380_RandomizedSet();
        randomizedSet.insert(1);
        randomizedSet.remove(2);
        randomizedSet.insert(2);
        int r = randomizedSet.getRandom();
        randomizedSet.remove(1);
        randomizedSet.insert(2);
        r = randomizedSet.getRandom();
    }

    private final Random ran;
    private final ArrayList<Integer> list;
    private final Map<Integer, Integer> map;

    public P380_RandomizedSet() {
        ran = new Random();
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }

        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        int last = list.get(list.size() - 1);
        int pos = map.get(val);
        if (pos != list.size() - 1) {
            list.set(pos, last);
            map.put(last, pos);
        }
        list.remove(list.size() - 1);
        map.remove(val);

        return true;
    }

    public int getRandom() {
        int r = ran.nextInt(list.size());
        return list.get(r);
    }
}
