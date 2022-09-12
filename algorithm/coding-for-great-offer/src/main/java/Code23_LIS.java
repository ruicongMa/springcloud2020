import java.util.Arrays;

/**
 * @author Mark
 * @date 2022/1/25 15:03
 */
public class Code23_LIS {

    // 最长递增子序列问题

    // 本题测试链接 : https://leetcode.com/problems/longest-increasing-subsequence

    // [4,1,3,2,3,9,5,6]：选 1,2,3,5,6
    //  0 1 2 3 4 5 6 7
    // dp[i]：子序列必须以i位置的数结尾的情况下，最长递增子序列是多长
    // max(dp[i])
    // [4,1,3,2,3,9,5,6] => [1,1,2,2,3,4,4,5]
    // 当前位置比较左边谁比你小，在选择小的dp中，谁的dp值最大，当前位置的值 = 左边dp最大值 + 1

    public static void main(String[] args) {
        int[] arr = {4, 1, 3, 2, 3, 9, 5, 6};
        int result1 = lengthOfLIS1(arr);
        int result2 = lengthOfLIS(arr);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result1 == result2);
    }

    // 时间复杂度O(N²)
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

    // 时间复杂度O(N*logN)
    public static int lengthOfLIS(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[] ends = new int[arr.length];
        ends[0] = arr[0];
        int right = 0;
        int l = 0;
        int r = 0;
        int m = 0;
        int max = 1;
        for (int i = 1; i < arr.length; i++) {
            l = 0;
            r = right;
            while (l <= r) {
                m = (l + r) / 2;
                if (arr[i] > ends[m]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            right = Math.max(right, l);
            ends[l] = arr[i];
            max = Math.max(max, l + 1);
        }
        return max;
    }
}
