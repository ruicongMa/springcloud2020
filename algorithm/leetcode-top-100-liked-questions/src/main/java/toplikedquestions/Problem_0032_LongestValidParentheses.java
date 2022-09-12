package toplikedquestions;

/**
 * @author Mark
 * @date 2022/4/2 9:58
 */
public class Problem_0032_LongestValidParentheses {

    // 最长有效括号：https://leetcode.com/problems/longest-valid-parentheses/
    public static int longestValidParentheses(String str) {
        if (str == null || str.equals("")) {
            return 0;
        }
        char[] chas = str.toCharArray();
        int[] dp = new int[chas.length];
        int pre = 0;
        int res = 0;
        for (int i = 1; i < chas.length; i++) {
            if (chas[i] == ')') { // 只有右括号有必要讨论，遇到左括号直接为0
                // pre是，当前i位置的), 应该找哪个位置的左括号
                pre = i - dp[i - 1] - 1;
                if (pre >= 0 && chas[pre] == '(') {
                    dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
