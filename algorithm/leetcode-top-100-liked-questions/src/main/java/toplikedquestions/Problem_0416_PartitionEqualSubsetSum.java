package toplikedquestions;

/**
 * @author Mark
 * @date 2022/4/3 9:28
 */
public class Problem_0416_PartitionEqualSubsetSum {

    // 分割等和子集：https://leetcode.com/problems/partition-equal-subset-sum/
    public static boolean canPartition(int[] nums) {
        int N = nums.length;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += nums[i];
        }
        if ((sum & 1) != 0) { // 累加和是奇数，直接返回false，不可能划分出来
            return false;
        }
        sum >>= 1;
        boolean[][] dp = new boolean[N][sum + 1];
        for (int i = 0; i < N; i++) {
            dp[i][0] = true;
        }
        if (nums[0] <= sum) {
            dp[0][nums[0]] = true;
        }
        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - nums[i] >= 0) {
                    dp[i][j] |= dp[i - 1][j - nums[i]];
                }
            }
            if (dp[i][sum]) {
                return true;
            }
        }
        return false;
    }

    // 超时
    public static boolean canPartition2(int[] nums) {
        int N = nums.length;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += nums[i];
        }
        if ((sum & 1) != 0) { // 累加和是奇数，直接返回false，不可能划分出来
            return false;
        }
        return process(nums, 0, sum / 2);
    }

    public static boolean process(int[] nums, int i, int rest) {
        if (rest == 0) {
            return true;
        }
        if (i == nums.length) {
            return rest == 0;
        }
        boolean p1 = process(nums, i + 1, rest);
        boolean p2 = false;
        if (nums[i] <= rest) {
            p2 = process(nums, i + 1, rest - nums[i]);
        }
        return p1 || p2;
    }

    public static boolean canPartition3(int[] nums) {
        int N = nums.length;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += nums[i];
        }
        if ((sum & 1) != 0) { // 累加和是奇数，直接返回false，不可能划分出来
            return false;
        }
        sum >>= 1;
        boolean[][] dp = new boolean[N + 1][sum + 1];
        for (int i = 0; i <= N; i++) {
            dp[i][0] = true;
        }
        for (int i = N - 1; i >= 0; i--) {
            for (int rest = 1; rest <= sum; rest++) {
                if (dp[i][rest]) {
                    return true;
                }
                dp[i][rest] = dp[i + 1][rest];
                if (nums[i] <= rest) {
                    dp[i][rest] |= dp[i + 1][rest - nums[i]];
                }
            }

        }
        return dp[0][sum];
    }

    public static void main(String[] args) {
        int[] nums = {3, 3, 3, 4, 5};
        System.out.println(canPartition(nums));
        System.out.println(canPartition2(nums));
        System.out.println(canPartition3(nums));
    }
}
