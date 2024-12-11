package leetcode_problems;

public class P31_NextPermutation {

    public static void main(String[] args) {
        int[] a = new int[]{2, 2, 1, 3};
        nextPermutation(a);

        for (int i : a) {
            System.out.println(i);
        }
    }

    public static void nextPermutation(int[] nums) {
        int curr = nums.length - 1;

        while (curr > 0) {
            // find the first decreasing digit.
            if (nums[curr] <= nums[curr - 1]) {
                curr--;
            } else {
                int pos = nums.length - 1;
                while (nums[pos] <= nums[curr - 1] && pos >= curr) {
                    pos--;
                }
                swap(nums, curr - 1, pos);
                break;
            }
        }
        reverse(nums, curr, nums.length - 1);
    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}