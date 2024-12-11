package leetcode_problems;

public class P35_SearchInsert {

    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int l = 0, r = nums.length - 1;
        while (l < r - 1) {
            int m = (l + r) / 2;
            if (nums[m] == target) {
                return m;
            } else if (nums[m] > target) {
                r = m;
            } else {
                l = m;
            }
        }
        if (target <= nums[l]) {
            return l;
        } else if (target <= nums[r]) {
            return r;
        } else {
            return r + 1;
        }
    }

    public int searchInsertOptimal(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int m, l = 0, r = nums.length - 1;
        while (l <= r) {
            m = (l + r) / 2;
            if (nums[m] == target) {
                return m;
            } else if (nums[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}
