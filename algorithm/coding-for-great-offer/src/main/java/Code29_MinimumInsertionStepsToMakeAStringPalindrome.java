import java.util.ArrayList;
import java.util.List;

/**
 * @author Mark
 * @date 2022/2/6 17:53
 */
public class Code29_MinimumInsertionStepsToMakeAStringPalindrome {

    /**
     * 问题一：一个字符串至少需要添加多少个字符能整体变成回文串
     * <p>
     * 问题二：返回问题一的其中一种添加结果
     * <p>
     * 问题三：返回问题一的所有添加结果
     */

    // 本题测试链接 : https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/
    // 测试链接只测了本题的第一问，直接提交可以通过
    public static int minInsertions(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        char[] str = s.toCharArray();
        int N = str.length;
        int[][] dp = new int[N][N];
        for (int i = 0; i < N - 1; i++) {
            // 倒数第二条斜对角线，相等为0，不等为1
            dp[i][i + 1] = str[i] == str[i + 1] ? 0 : 1;
        }
        for (int i = N - 3; i >= 0; i--) { // 从下往上
            for (int j = i + 2; j < N; j++) { // 从左往右
                // 可能性一、可能性二决策
                dp[i][j] = Math.min(dp[i][j - 1], dp[i + 1][j]) + 1;
                if (str[i] == str[j]) { // 可能性三
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j - 1]);
                }
            }
        }
        return dp[0][N - 1];
    }

    // 问题二，返回其中一种结果
    public static String minInsertionsOneWay(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        char[] str = s.toCharArray();
        int N = str.length;
        int[][] dp = new int[N][N];
        for (int i = 0; i < N - 1; i++) {
            dp[i][i + 1] = str[i] == str[i + 1] ? 0 : 1;
        }
        for (int i = N - 3; i >= 0; i--) {
            for (int j = i + 2; j < N; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], dp[i + 1][j]) + 1;
                if (str[i] == str[j]) {
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j - 1]);
                }
            }
        }
        // 格子开始位置（格子跳到哪的变量L、R）
        int L = 0;
        int R = N - 1;
        // N:字符串长度，dp[L][R]：至少需要添加的字符，总字符长度为：N + dp[L][R]
        char[] ans = new char[N + dp[L][R]];
        // ansl、ansr变量，整体的结果填到哪
        int ansl = 0;
        int ansr = ans.length - 1;
        while (L < R) {
            if (dp[L][R - 1] == dp[L][R] - 1) { // 依赖于左边（情况一）
                ans[ansl++] = str[R];
                ans[ansr--] = str[R--];
            } else if (dp[L + 1][R] == dp[L][R] - 1) { // 依赖于下边（情况二）
                ans[ansl++] = str[L];
                ans[ansr--] = str[L++];
            } else { // 依赖于左下（情况三）
                ans[ansl++] = str[L++];
                ans[ansr--] = str[R--];
            }
        }
        if (L == R) {
            ans[ansl] = str[L];
        }
        return String.valueOf(ans);
    }

    // 本题第三问，返回所有可能的结果
    public static List<String> minInsertionsAllWays(String s) {
        List<String> ans = new ArrayList<>();
        if (s == null || s.length() < 2) {
            ans.add(s);
        } else {
            char[] str = s.toCharArray();
            int N = str.length;
            int[][] dp = new int[N][N];
            for (int i = 0; i < N - 1; i++) {
                dp[i][i + 1] = str[i] == str[i + 1] ? 0 : 1;
            }
            for (int i = N - 3; i >= 0; i--) {
                for (int j = i + 2; j < N; j++) {
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i + 1][j]) + 1;
                    if (str[i] == str[j]) {
                        dp[i][j] = Math.min(dp[i][j], dp[i + 1][j - 1]);
                    }
                }
            }
            int M = N + dp[0][N - 1];
            char[] path = new char[M];
            process(str, dp, 0, N - 1, path, 0, M - 1, ans);
        }
        return ans;
    }

    // 当前来到的动态规划中的格子，(L,R)
    // path ....  [pl....pr] ....
    public static void process(char[] str, int[][] dp, int L, int R, char[] path, int pl, int pr, List<String> ans) {
        if (L >= R) { // L > R  L==R
            if (L == R) {
                path[pl] = str[L];
            }
            ans.add(String.valueOf(path));
        } else {
            if (dp[L][R - 1] == dp[L][R] - 1) { // 左
                path[pl] = str[R];
                path[pr] = str[R];
                process(str, dp, L, R - 1, path, pl + 1, pr - 1, ans);
            }
            if (dp[L + 1][R] == dp[L][R] - 1) { // 下
                path[pl] = str[L];
                path[pr] = str[L];
                process(str, dp, L + 1, R, path, pl + 1, pr - 1, ans);
            }
            // L == R - 1 剩下两个字符，比如aa 或 等于左下
            if (str[L] == str[R] && (L == R - 1 || dp[L + 1][R - 1] == dp[L][R])) {
                path[pl] = str[L];
                path[pr] = str[R];
                process(str, dp, L + 1, R - 1, path, pl + 1, pr - 1, ans);
            }
        }
    }

    public static void main(String[] args) {
        String s = null;
        String ans2 = null;
        List<String> ans3 = null;

        System.out.println("本题第二问，返回其中一种结果测试开始");
        s = "mbadm";
        ans2 = minInsertionsOneWay(s);
        System.out.println(ans2);

        s = "leetcode";
        ans2 = minInsertionsOneWay(s);
        System.out.println(ans2);

        s = "aabaa";
        ans2 = minInsertionsOneWay(s);
        System.out.println(ans2);
        System.out.println("本题第二问，返回其中一种结果测试结束");

        System.out.println();

        System.out.println("本题第三问，返回所有可能的结果测试开始");
        s = "mbadm";
        ans3 = minInsertionsAllWays(s);
        for (String way : ans3) {
            System.out.println(way);
        }
        System.out.println();

        s = "leetcode";
        ans3 = minInsertionsAllWays(s);
        for (String way : ans3) {
            System.out.println(way);
        }
        System.out.println();

        s = "aabaa";
        ans3 = minInsertionsAllWays(s);
        for (String way : ans3) {
            System.out.println(way);
        }
        System.out.println();
        System.out.println("本题第三问，返回所有可能的结果测试结束");
    }
}
