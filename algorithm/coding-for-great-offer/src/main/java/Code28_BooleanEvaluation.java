/**
 * @author Mark
 * @date 2022/2/5 20:11
 */
public class Code28_BooleanEvaluation {

    // 本题测试链接 : https://leetcode-cn.com/problems/boolean-evaluation-lcci/

    public static int countEval(String express, int desired) {
        if (express == null || express.equals("")) {
            return 0;
        }
        char[] exp = express.toCharArray();
        int N = exp.length;
        Info[][] dp = new Info[N][N];
        Info allInfo = func(exp, 0, exp.length - 1, dp);
        return desired == 1 ? allInfo.t : allInfo.f;
    }

    public static class Info {
        public int t;
        public int f;

        public Info(int tr, int fa) {
            t = tr;
            f = fa;
        }
    }

    // 限制:
    // L...R上，一定有奇数个字符
    // L位置的字符和R位置的字符，非0即1，不能是逻辑符号！
    // 返回str[L...R]这一段，为true的方法数，和false的方法数
    public static Info func(char[] str, int L, int R, Info[][] dp) {
        if (dp[L][R] != null) {
            return dp[L][R];
        }
        int t = 0;
        int f = 0;
        if (L == R) { // base case
            t = str[L] == '1' ? 1 : 0;
            f = str[L] == '0' ? 1 : 0;
        } else { // L..R >=3
            // 每一个种逻辑符号，split枚举的东西
            // 都去试试最后结合
            for (int split = L + 1; split < R; split += 2) {
                Info leftInfo = func(str, L, split - 1, dp);
                Info rightInfo = func(str, split + 1, R, dp);
                int a = leftInfo.t;
                int b = leftInfo.f;
                int c = rightInfo.t;
                int d = rightInfo.f;
                switch (str[split]) {
                    case '&':
                        t += a * c;
                        f += b * c + b * d + a * d;
                        break;
                    case '|':
                        t += a * c + a * d + b * c;
                        f += b * d;
                        break;
                    case '^':
                        t += a * d + b * c;
                        f += a * c + b * d;
                        break;
                }
            }
        }
        dp[L][R] = new Info(t, f);
        return dp[L][R];
    }
}
