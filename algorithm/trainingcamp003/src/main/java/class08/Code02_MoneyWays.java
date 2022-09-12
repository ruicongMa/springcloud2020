package class08;

/**
 * @author Mark
 * @date 2022/4/17 18:10
 */
public class Code02_MoneyWays {

    // 普通硬币和纪念币拼m值的方法数

    /**
     * 现有n1+n2种面值的硬币，其中前n1种为普通币，可以取任意枚，后n2种为纪念币， 每种最多只能取一枚，每种硬币有一个面值，问能用多少种方法拼出m的面值?
     */
    // arbitrary：普通货币，onlyone：纪念币，money：目标aim
    public static int moneyWays(int[] arbitrary, int[] onlyone, int money) {
        if (money < 0) {
            return 0;
        }
        if ((arbitrary == null || arbitrary.length == 0) && (onlyone == null || onlyone.length == 0)) {
            return money == 0 ? 1 : 0;
        }
        // 任意张 的数组， 一张的数组，不可能都没有
        int[][] dparb = getDpArb(arbitrary, money);
        int[][] dpone = getDpOne(onlyone, money);
        // 只有普通币
        if (dparb == null) { // 任意张的数组没有，一张的数组有
            return dpone[dpone.length - 1][money];
        }
        // 只有纪念币
        if (dpone == null) { // 任意张的数组有，一张的数组没有
            return dparb[dparb.length - 1][money];
        }
        // 既有普通币又有纪念币
        int res = 0;
        for (int i = 0; i <= money; i++) {
            res += dparb[dparb.length - 1][i] * dpone[dpone.length - 1][money - i];
        }
        return res;
    }

    // 生成普通币的二维dp表
    public static int[][] getDpArb(int[] arr, int money) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        int[][] dp = new int[arr.length][money + 1];
        // dp[i][j] 0..i券 自由选择张数， 搞定j元， 有多少方法？
        for (int i = 0; i < arr.length; i++) { // 第一列格子都填1，代表1种方法，这种方法表示不使用任何普通币
            dp[i][0] = 1;
        }
        // [0] 5元 0元 5元 10元 15元 20元
        for (int j = 1; arr[0] * j <= money; j++) { // 第一行格子，整数倍的货币（使用1张，2张，...）格子填1
            dp[0][arr[0] * j] = 1;
        }
        // 0行 0列 填完了，其余格子
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= money; j++) {
                dp[i][j] = dp[i - 1][j];
                dp[i][j] += j - arr[i] >= 0 ? dp[i][j - arr[i]] : 0;
            }
        }
        return dp;
    }

    // 生成纪念币的二维dp表
    public static int[][] getDpOne(int[] arr, int money) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        int[][] dp = new int[arr.length][money + 1];
        for (int i = 0; i < arr.length; i++) { // 第一列格子都填1，代表1种方法，这种方法表示不使用任何纪念币
            dp[i][0] = 1;
        }
        if (arr[0] <= money) { // 只能使用一种纪念币
            dp[0][arr[0]] = 1;
        }
        // 其余格子
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= money; j++) {
                dp[i][j] = dp[i - 1][j];
                dp[i][j] += j - arr[i] >= 0 ? dp[i - 1][j - arr[i]] : 0;
            }
        }
        return dp;
    }
}
