package class08;

/**
 * @author Mark
 * @date 2022/4/16 23:02
 */
public class Code06_PalindromeMinAdd {

    // 最少添加几个字符让字符串整体都是回文串

    /**
     * 给定一个字符串，如果可以在字符串任意位置添加字符，最少添加几个能让字符串整体都是回文串。
     */
    // 通过dp表获取其中一种回文字符串
    public static String getPalindrome1(String str) {
        if (str == null || str.length() < 2) {
            return str;
        }
        char[] chas = str.toCharArray();
        int[][] dp = getDP(chas);
        char[] res = new char[chas.length + dp[0][chas.length - 1]];
        int i = 0;
        int j = chas.length - 1;
        int resl = 0;
        int resr = res.length - 1;
        while (i <= j) {
            if (chas[i] == chas[j]) {
                res[resl++] = chas[i++];
                res[resr--] = chas[j--];
            } else if (dp[i][j - 1] < dp[i + 1][j]) {
                res[resl++] = chas[j];
                res[resr--] = chas[j--];
            } else {
                res[resl++] = chas[i];
                res[resr--] = chas[i++];
            }
        }
        return String.valueOf(res);
    }

    // 生成dp表
    public static int[][] getDP(char[] str) {
        int[][] dp = new int[str.length][str.length];
        for (int j = 1; j < str.length; j++) {
            dp[j - 1][j] = str[j - 1] == str[j] ? 0 : 1;
            for (int i = j - 2; i > -1; i--) {
                if (str[i] == str[j]) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        String str = "AB1CD2EFG3H43IJK2L1MN";
        System.out.println(getPalindrome1(str));
    }
}
