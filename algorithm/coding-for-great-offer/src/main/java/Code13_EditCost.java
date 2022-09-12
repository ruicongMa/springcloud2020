/**
 * https://leetcode.com/problems/edit-distance/
 *
 * @author Mark
 * @date 2021/10/23 13:54
 */
public class Code13_EditCost {

    /**
     * 经典中的经典
     * 编辑距离问题
     * 求一个字符串变成另外一个字符串的最小代价问题。
     */

    /**
     * 利用动态规划中的 “样本对应模型”：往往是根据结尾处进行划分的。
     * "编辑距离" 可以描述两个字符串的相似程度(搜索框例子，比如用户输入"今晚吃什么？" 词库里有"今夜吃什么？")
     */

    public static int minDistance(String word1, String word2) {
        return minCost(word1, word2, 1, 1, 1);
    }

    private static int minCost(String s1, String s2, int add, int delete, int replace) {
        if (s1 == null || s2 == null) {
            return 0;
        }
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        int N = str1.length + 1;
        int M = str2.length + 1;
        int[][] dp = new int[N][M];
        // dp[i][j] 代表 s1前i个字符 变成 s2前j个字符的代价
        for (int i = 1; i < N; i++) {
            dp[i][0] = delete * i;
        }
        for (int j = 1; j < M; j++) {
            dp[0][j] = add * j;
        }
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                if (str1[i - 1] == str2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + replace;
                }
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + delete);
                dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + add);
            }
        }
        return dp[N - 1][M - 1];
    }
}
