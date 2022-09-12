package class03;

/**
 * @author Mark
 * @date 2022/4/8 23:40
 */
public class Code02_SnacksWays {

    // 背包问题

    /**
     * 背包容量为w，一共有n袋零食, 第i袋零食体积为v[i] > 0，总体积不超过背包容量的情况下，
     * 一共有多少种零食放法？(总体积为0也算一种放法，代表一个零食也不要)。
     */
    // 方法一：暴力递归
    public static int ways1(int[] arr, int w) {
        // arr[0...]
        return process(arr, 0, w);
    }

    // 从左往右的经典模型
    // 还剩的容量是rest，arr[index...]自由选择，
    // 返回选择方案
    // index ： 0～N
    // rest : 0~w
    public static int process(int[] arr, int index, int rest) {
        if (rest < 0) { // 没有容量了
            // -1 无方案的意思
            return -1;
        }
        // rest>=0,
        if (index == arr.length) { // 无零食可选
            return 1;
        }
        // rest >=0
        // 有零食index
        // index号零食，要 or 不要
        // index, rest
        // (index+1, rest)
        // (index+1, rest-arr[i])
        int next1 = process(arr, index + 1, rest); // 不要
        int next2 = process(arr, index + 1, rest - arr[index]); // 要
        return next1 + (next2 == -1 ? 0 : next2);
    }

    // 方法二：右暴力递归改动态规划
    public static int ways2(int[] arr, int w) {
        int N = arr.length;
        int[][] dp = new int[N + 1][w + 1];
        for (int rest = 0; rest <= w; rest++) {
            dp[N][rest] = 1;
        }
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= w; rest++) {
                dp[index][rest] = dp[index + 1][rest] + ((rest - arr[index] >= 0) ? dp[index + 1][rest - arr[index]] : 0);
            }
        }
        return dp[0][w];
    }

    // 方法三：重新定义dp[i][j]含义：0~i袋零食自由组合凑出体积必须为j的方法数是多少
    public static int ways3(int[] arr, int w) {
        int N = arr.length;
        int[][] dp = new int[N][w + 1];
        for (int i = 0; i < N; i++) { // 第一列全是1，代表一个零食也不要，也算是一种方法
            dp[i][0] = 1;
        }
        if (arr[0] <= w) {
            dp[0][arr[0]] = 1;
        }
        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= w; j++) {
                dp[i][j] = dp[i - 1][j] + ((j - arr[i]) >= 0 ? dp[i - 1][j - arr[i]] : 0);
            }
        }
        int ans = 0;
        for (int j = 0; j <= w; j++) {
            ans += dp[N - 1][j];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 9};
        int w = 8;
        System.out.println(ways1(arr, w));
        System.out.println(ways2(arr, w));
        System.out.println(ways3(arr, w));
    }
}
