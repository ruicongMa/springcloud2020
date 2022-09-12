package topinterviewquestions;

/**
 * @author Mark
 * @date 2022/3/14 9:48
 */
public class Problem_0053_MaximumSubarray {

    // 最大子数组和：https://leetcode.com/problems/maximum-subarray/
    public static int maxSum(int[] nums) {
        int N = nums.length;
        // dp[i] 含义：子数组必须以i结尾的时候，所有可以得到的子数组中，最大累加和是多少？
        int[] dp = new int[N];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < N; i++) {
            int p1 = nums[i];
            int p2 = nums[i] + dp[i - 1];
            dp[i] = Math.max(p1, p2);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static int maxSum2(int[] nums) {
        int N = nums.length;
        // dp[i] 含义：子数组必须以i结尾的时候，所有可以得到的子数组中，最大累加和是多少？
        int t = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            int cur = nums[i];
            t += nums[i];
            t = Math.max(cur, t);
            max = Math.max(max, t);
        }
        return max;
    }

    public static int maxSumFollowUp(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int N = arr.length;
        if (N == 1) {
            return arr[0];
        }
        if (N == 2) {
            return Math.max(arr[0], arr[1]);
        }
        // N > 2
        int[] dp = new int[N];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < N; i++) {
            int p1 = arr[i];
            int p2 = dp[i - 1];
            int p3 = arr[i] + dp[i - 2];
            dp[i] = Math.max(Math.max(p1, p2), p3);
        }
        return dp[N - 1];
    }

    public static int maxSubArray(int[] nums) {
        int cur = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            cur += nums[i];
            max = Math.max(max, cur);
            cur = cur < 0 ? 0 : cur;
        }
        return max;
    }
}
