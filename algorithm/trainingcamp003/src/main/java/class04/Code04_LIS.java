package class04;

/**
 * @author Mark
 * @date 2022/4/10 11:42
 */
public class Code04_LIS {

    // 最长递增子序列问题
    // 方法一：时间复杂度O(N²)
    public static int[] lis1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        int[] dp = getdp1(arr);
        return generateLIS(arr, dp);
    }

    // 填好一维dp数组
    public static int[] getdp1(int[] arr) {
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp;
    }

    public static int[] generateLIS(int[] arr, int[] dp) {
        int len = 0; // 最长递增子序列的长度
        int index = 0; // 最长递增子序列的下标
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > len) {
                len = dp[i];
                index = i;
            }
        }
        int[] lis = new int[len];
        lis[--len] = arr[index];
        for (int i = index; i >= 0; i--) {
            if (arr[i] < arr[index] && dp[i] == dp[index] - 1) {
                lis[--len] = arr[i];
                index = i;
            }
        }
        return lis;
    }

    // 方法二：时间复杂度O(N*logN)
    public static int[] lis2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        int[] dp = getdp2(arr);
        return generateLIS(arr, dp);
    }

    public static int[] getdp2(int[] arr) {
        int[] dp = new int[arr.length];
        int[] ends = new int[arr.length];
        ends[0] = arr[0];
        dp[0] = 1;
        int right = 0; // 有效区  0....right  right往右无效
        int L = 0;
        int R = 0;
        int M = 0;
        for (int i = 1; i < arr.length; i++) {
            L = 0;
            R = right;
            while (L <= R) { // 二分查找的过程
                M = (L + R) / 2;
                if (arr[i] > ends[M]) {
                    L = M + 1;
                } else {
                    R = M - 1;
                }
            }
            // L -> right+1
            right = Math.max(right, L);
            ends[L] = arr[i];
            dp[i] = L + 1;
        }
        return dp;
    }

    // for test
    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 3, 6, 4, 8, 9, 7};
        printArray(arr);
        printArray(lis1(arr));
        printArray(lis2(arr));
    }
}
