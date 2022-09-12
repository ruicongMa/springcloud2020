package toplikedquestions;

/**
 * @author Mark
 * @date 2022/4/2 17:39
 */
public class Problem_0221_MaximalSquare {

    // 最大正方形：https://leetcode.com/problems/maximal-square/
    public static int maximalSquare(char[][] m) {
        if (m == null || m.length == 0 || m[0].length == 0) {
            return 0;
        }
        int N = m.length;
        int M = m[0].length;
        int[][] dp = new int[N + 1][M + 1];
        int max = 0;
        for (int i = 0; i < N; i++) { // 0列
            if (m[i][0] == '1') {
                dp[i][0] = 1;
                max = 1;
            }
        }
        for (int j = 1; j < M; j++) { // 0行
            if (m[0][j] == '1') {
                dp[0][j] = 1;
                max = 1;
            }
        }
        // 其他位置，上边、左边、左上都有可能是瓶颈
        for (int i = 1; i < N; i++) { // 其它位置
            for (int j = 1; j < M; j++) {
                if (m[i][j] == '1') {
                    dp[i][j] = Math.min(
                            Math.min(dp[i - 1][j], // 上边
                                    dp[i][j - 1]), // 左边
                            dp[i - 1][j - 1]) // 左上
                            + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }
}
