package class19;

/**
 * @author Mark
 * @date 2022/2/23 9:54
 */
public class Code01_Knapsack {

    // 背包问题

    /**
     * 给定两个长度都为N的数组weights和values，
     * weights[i]和values[i]分别代表 i号物品的重量和价值。
     * 给定一个正数bag，表示一个载重bag的袋子，
     * 你装的物品不能超过这个重量。
     * 返回你能装下最多的价值是多少?
     */

    // 所有的货，重量和价值，都在w和v数组里
    // 为了方便，其中没有负数
    // bag背包容量，不能超过这个载重
    // 返回：不超重的情况下，能够得到的最大价值
    // 暴力递归
    public static int maxValue(int[] w, int[] v, int bag) {
        if (w == null || v == null || w.length != v.length || w.length == 0) {
            return 0;
        }
        // 尝试函数！
        return process(w, v, 0, bag);
    }

    // index 0~N
    // rest 负~bag
    // 当前考虑到了index号货物，index...所有的货物可以自由选择
    // 做的选择不能超过背包容量
    // 返回最大价值
    private static int process(int[] w, int[] v, int index, int rest) {
        if (rest < 0) { // base case
            return -1;
        }
        if (index == w.length) { // base case
            return 0;
        }
        int p1 = process(w, v, index + 1, rest);
        int p2 = 0;
        int next = process(w, v, index + 1, rest - w[index]);
        if (next != -1) {
            p2 = v[index] + next;
        }
        return Math.max(p1, p2);
    }

    // dp 加缓存
    public static int maxValue2(int[] w, int[] v, int bag) {
        if (w == null || v == null || w.length != v.length || w.length == 0) {
            return 0;
        }
        int N = w.length;
        int[][] dp = new int[N + 1][bag + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return process2(w, v, 0, bag, dp);
    }

    private static int process2(int[] w, int[] v, int index, int rest, int[][] dp) {
        if (rest < 0) { // base case
            return -1;
        }
        if (index == w.length) { // base case
            return 0;
        }
        if (dp[index][rest] != -1) {
            return dp[index][rest];
        }
        int ans = 0;
        int p1 = process2(w, v, index + 1, rest, dp);
        int p2 = 0;
        int next = process2(w, v, index + 1, rest - w[index], dp);
        if (next != -1) {
            p2 = v[index] + next;
        }
        ans = Math.max(p1, p2);
        dp[index][rest] = ans;
        return ans;
    }

    // dp 填表
    public static int dp(int[] w, int[] v, int bag) {
        if (w == null || v == null || w.length != v.length || w.length == 0) {
            return 0;
        }
        int N = w.length;
        int[][] dp = new int[N + 1][bag + 1];
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= bag; rest++) {
                int p1 = dp[index + 1][rest];
                int p2 = 0;
                int next = rest - w[index] < 0 ? -1 : dp[index + 1][rest - w[index]];
                if (next != -1) {
                    p2 = v[index] + next;
                }
                dp[index][rest] = Math.max(p1, p2);
            }
        }
        return dp[0][bag];
    }

    public static void main(String[] args) {
        int[] weights = {3, 2, 4, 7, 3, 1, 7};
        int[] values = {5, 6, 3, 19, 12, 4, 2};
        int bag = 15;
        System.out.println(maxValue(weights, values, bag));
        System.out.println(maxValue2(weights, values, bag));
        System.out.println(dp(weights, values, bag));
    }
}
