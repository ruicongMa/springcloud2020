package toplikedquestions;

/**
 * @author Mark
 * @date 2022/4/2 19:34
 */
public class Problem_0213_HouseRobberII {

    // 打家劫舍II：https://leetcode.com/problems/house-robber-ii/
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int N = nums.length;
        int[] dp1 = new int[N];
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < N - 1; i++) {
            dp1[i] = Math.max(dp1[i - 1], nums[i] + dp1[i - 2]);
        }
        int[] dp2 = new int[N];
        dp2[1] = nums[1];
        dp2[2] = Math.max(nums[1], nums[2]);
        for (int i = 3; i < N; i++) {
            dp2[i] = Math.max(dp2[i - 1], nums[i] + dp2[i - 2]);
        }
        return Math.max(dp1[N - 2], dp2[N - 1]);
    }
}
