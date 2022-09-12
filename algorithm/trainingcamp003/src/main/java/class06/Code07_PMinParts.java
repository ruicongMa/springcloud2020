package class06;

/**
 * @author Mark
 * @date 2022/4/14 16:49
 */
public class Code07_PMinParts {

    // 方法一：暴力解，时间复杂度O(N³)
    public static int minParts(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        return process(s.toCharArray(), 0) - 1;
    }

    // 回文最少分割数
    // 当前来到i位置，arr[0~i-1]不用管，已经弄好了
    // arr[i...N-1] 返回回文最少分割数
    public static int process(char[] str, int i) {
        if (i == str.length) {
            return 0;
        }
        // i < N
        // i...end 这一段字符串
        int ans = Integer.MAX_VALUE;
        for (int end = i; end < str.length; end++) { // O(N²)
            if (isP(str, i, end)) { // O(N)
                ans = Math.min(ans, 1 + process(str, end + 1));
            }
        }
        return ans;
    }

    // L...R范围内，校验是否是回文字符串
    public static boolean isP(char[] str, int L, int R) {
        while (L <= R) {
            if (str[L] != str[R]) {
                return false;
            }
            L++;
            R--;
        }
        return true;
    }

    // 方法二：生成回文dp，把原来需要遍历查找 L...R 是否是回文 替换成 查表操作，加速前进
    // 从左往右的尝试模型 + 范围尝试模型
    public static int minParts2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        return process2(s) - 1;
    }

    public static int process2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        char[] str = s.toCharArray();
        int N = str.length;
        // 生成回文dp，加速查找
        boolean[][] isP = new boolean[N][N];
        // 第一条和第二条斜对角线
        for (int i = 0; i < N - 1; i++) {
            isP[i][i] = true;
            isP[i][i + 1] = str[i] == str[i + 1];
        }
        isP[N - 1][N - 1] = true;
        // 其余格子，整体从下往上，其次从左往右填
        for (int row = N - 3; row >= 0; row--) {
            for (int col = row + 2; col < N; col++) {
                isP[row][col] = str[row] == str[col] && isP[row + 1][col - 1];
            }
        }
        int[] dp = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[N] = 0;
        for (int i = N - 1; i >= 0; i--) {
            for (int end = i; end < N; end++) {
                // i..end
                if (isP[i][end]) {
                    dp[i] = Math.min(dp[i], 1 + dp[end + 1]);
                }
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        String test = "aba12321412321TabaKFK";
        // String test = "ACDCDCDAD";
        System.out.println(minParts(test));
        System.out.println(minParts2(test));
    }
}
