/**
 * @author Mark
 * @date 2021/8/29 16:11
 */
public class Code08_HorseJump {

    /**
     * 请同学们自行搜索或者想象一个象棋的棋盘，
     * 然后把整个棋盘放入第一象限，棋盘的最左下角是(0,0)位置
     * 那么整个棋盘就是横坐标上10条线、纵坐标上9条线的区域
     * 给你三个 参数 x，y，k
     * 返回“马”从(0,0)位置出发，必须走k步
     * 最后落在(x,y)上的方法数有多少种?
     */

    public static int ways1(int x, int y, int k) {
        return f(x, y, k);
    }

    // 马从(0,0)出发，有k步要走，并且一定要走完，最终来到x,y位置的方法数是多少
    private static int f(int x, int y, int k) {
        // 边界条件
        if (x < 0 || x > 9 || y < 0 || y > 8) {
            return 0;
        }
        // base case
        if (k == 0) {
            return x == 0 && y == 0 ? 1 : 0;
        }
        return f(x + 2, y - 1, k - 1)
                + f(x + 2, y + 1, k - 1)
                + f(x + 1, y + 2, k - 1)
                + f(x - 1, y + 2, k - 1)
                + f(x - 2, y + 1, k - 1)
                + f(x - 2, y - 1, k - 1)
                + f(x - 1, y - 2, k - 1)
                + f(x + 1, y - 2, k - 1);
    }

    public static int ways2(int x, int y, int k) {
        int[][][] dp = new int[10][9][k + 1];
        dp[0][0][0] = 1;
        for (int level = 1; level <= k; level++) {
            // level层，x y
            for (int i = 0; i < 10; i++) { // x可能性
                for (int j = 0; j < 9; j++) { // y的可能性
                    dp[i][j][level] = getValue(dp, i + 2, j - 1, level - 1)
                            + getValue(dp, i + 2, j + 1, level - 1)
                            + getValue(dp, i + 1, j + 2, level - 1)
                            + getValue(dp, i - 1, j + 2, level - 1)
                            + getValue(dp, i - 2, j + 1, level - 1)
                            + getValue(dp, i - 2, j - 1, level - 1)
                            + getValue(dp, i - 1, j - 2, level - 1)
                            + getValue(dp, i + 1, j - 2, level - 1);
                }
            }
        }
        return dp[x][y][k];
    }

    private static int getValue(int[][][] dp, int x, int y, int k) {
        if (x < 0 || x > 9 || y < 0 || y > 8) {
            return 0;
        }
        return dp[x][y][k];
    }

    public static int jump(int a, int b, int k) {
        return process(0, 0, k, a, b);
    }

    private static int process(int x, int y, int rest, int a, int b) {
        if (x < 0 || x > 9 || y < 0 || y > 8) {
            return 0;
        }
        if (rest == 0) {
            return (x == a && y == b) ? 1 : 0;
        }
        int ways = process(x + 2, y + 1, rest - 1, a, b);
        ways += process(x + 1, y + 2, rest - 1, a, b);
        ways += process(x - 1, y + 2, rest - 1, a, b);
        ways += process(x - 2, y + 1, rest - 1, a, b);
        ways += process(x - 2, y - 1, rest - 1, a, b);
        ways += process(x - 1, y - 2, rest - 1, a, b);
        ways += process(x + 1, y - 2, rest - 1, a, b);
        ways += process(x + 2, y - 1, rest - 1, a, b);
        return ways;
    }

    public static int dp(int a, int b, int k) {
        int[][][] dp = new int[10][9][k + 1];
        dp[a][b][0] = 1;
        for (int rest = 1; rest <= k; rest++) {
            for (int x = 0; x < 10; x++) {
                for (int y = 0; y < 9; y++) {
                    int ways = pick(dp, x + 2, y + 1, rest - 1);
                    ways += pick(dp, x + 1, y + 2, rest - 1);
                    ways += pick(dp, x - 1, y + 2, rest - 1);
                    ways += pick(dp, x - 2, y + 1, rest - 1);
                    ways += pick(dp, x - 2, y - 1, rest - 1);
                    ways += pick(dp, x - 1, y - 2, rest - 1);
                    ways += pick(dp, x + 1, y - 2, rest - 1);
                    ways += pick(dp, x + 2, y - 1, rest - 1);
                    dp[x][y][rest] = ways;
                }
            }
        }
        return dp[0][0][k];
    }

    private static int pick(int[][][] dp, int x, int y, int rest) {
        if (x < 0 || x > 9 || y < 0 || y > 8) {
            return 0;
        }
        return dp[x][y][rest];
    }

    public static void main(String[] args) {
        // int x = 7;
        // int y = 7;
        // int step = 10;
        int x = 5;
        int y = 4;
        int step = 3;
        System.out.println(ways1(x, y, step));
        System.out.println(ways2(x, y, step));
        System.out.println(dp(x, y, step));
        System.out.println(jump(x, y, step));
    }
}
