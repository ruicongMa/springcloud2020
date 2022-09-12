/**
 * @author Mark
 * @date 2021/8/31 20:54
 */
public class Code14_NQueens {

    /**
     * N皇后问题是指在N*N的棋盘上要摆N个皇后，
     * 要求任何两个皇后不同行、不同列， 也不在同一条斜线上
     * 给定一个整数n，返回n皇后的摆法有多少种。  n=1，返回1
     * n=2或3，2皇后和3皇后问题无论怎么摆都不行，返回0
     * n=8，返回92
     */

    public static int num(int n) {
        if (n < 1) {
            return 0;
        }
        int[] record = new int[n];
        return process(0, record, n);
    }

    // 当前来到i行，一共是0~N-1行
    // 在i行放皇后，所有列都尝试
    // 必须要保证之前的所有皇后不打架
    // int[] record record[x] = y 之前的第x行的皇后，放在了y列上
    // 返回：不关心i以上发生了什么，i... 后续有多少合法的方法数
    private static int process(int i, int[] record, int n) {
        if (i == n) {
            return 1;
        }
        int res = 0;
        // i上的皇后，放哪一列呢？j列
        for (int j = 0; j < n; j++) {
            if (isValid(record, i, j)) {
                record[i] = j;
                res += process(i + 1, record, n);
            }
        }
        return res;
    }

    private static boolean isValid(int[] record, int i, int j) {
        // 0...i-1
        for (int k = 0; k < i; k++) {
            if (j == record[k] || Math.abs(i - k) == Math.abs(record[k] - j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(num(8));
    }
}
