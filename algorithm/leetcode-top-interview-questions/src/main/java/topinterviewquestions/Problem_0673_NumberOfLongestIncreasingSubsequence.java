package topinterviewquestions;

/**
 * @author Mark
 * @date 2022/3/29 14:10
 */
public class Problem_0673_NumberOfLongestIncreasingSubsequence {

    public static int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 3, 5, 4, 7, 2};
        System.out.println(findNumberOfLIS(nums));
    }
}
