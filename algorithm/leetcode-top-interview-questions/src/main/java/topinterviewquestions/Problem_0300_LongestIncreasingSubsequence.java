package topinterviewquestions;

/**
 * @author Mark
 * @date 2022/3/29 16:46
 */
public class Problem_0300_LongestIncreasingSubsequence {

    // 最长递增子序列：https://leetcode.com/problems/longest-increasing-subsequence/
    // 方法一：时间复杂度O(N²)
    public static int lengthOfLIS1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[] dp = new int[arr.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }

    // 方法二：时间复杂度O(N*logN)
    public static int lengthOfLIS2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[] ends = new int[arr.length];
        ends[0] = arr[0];
        int right = 0;
        int L = 0;
        int R = 0;
        int M = 0;
        int max = 1;
        for (int i = 1; i < arr.length; i++) {
            L = 0;
            R = right;
            while (L <= R) {
                M = (L + R) / 2;
                if (arr[i] > ends[M]) {
                    L = M + 1;
                } else {
                    R = M - 1;
                }
            }
            right = Math.max(right, L);
            ends[L] = arr[i];
            max = Math.max(max, L + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 3, 5, 4, 7, 2};
        System.out.println(lengthOfLIS1(nums));
        System.out.println(lengthOfLIS2(nums));
    }
}
