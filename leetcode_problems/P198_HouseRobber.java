package leetcode_problems;

public class P198_HouseRobber {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 9, 3, 1};

        P198_HouseRobber p198HouseRobber = new P198_HouseRobber();
        System.out.println(p198HouseRobber.rob(nums));
    }

    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int[] ret = new int[nums.length + 2];
        for (int i = 2; i < ret.length; i++) {
            int index = i - 2;
            ret[i] = Math.max(ret[i - 2] + nums[index], ret[i - 1]);
        }
        return ret[ret.length - 1];
    }
}
