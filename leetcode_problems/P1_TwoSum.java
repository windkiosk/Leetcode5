package leetcode_problems;

import java.util.HashMap;
import java.util.Map;

public class P1_TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[] { 2, 7, 11, 15 };
        int[] ret = twoSum(nums, 9);
        System.out.println("first: " + ret[0] + ", second: " + ret[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] pair = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                pair[0] = map.get(nums[i]);
                pair[1] = i;
                break;
            } else {
                map.put(target - nums[i], i);
            }
        }

        return pair;
    }
}