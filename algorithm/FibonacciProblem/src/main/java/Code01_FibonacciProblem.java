import java.util.Arrays;

/**
 * @author Mark
 * @date 2021/9/3 14:28
 */
public class Code01_FibonacciProblem {

    /**
     * 斐波那契数列递归实现
     * 时间复杂度:O(n)
     */
    public static int f1(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return f1(n - 1) + f1(n - 2);
    }

    /**
     * 斐波那契数列非递归实现
     * 时间复杂度:O(n)
     */
    public static int f2(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int res = 1;
        int pre = 1;
        int tmp = 0;
        for (int i = 3; i <= n; i++) {
            tmp = res;
            res = res + pre;
            pre = tmp;
        }
        return res;
    }

    public static int f3(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        // [ 1 ,1 ]
        // [ 1, 0 ]
        int[][] base = {
                {1, 1},
                {1, 0}
        };
        int[][] res = matrixPower(base, n - 2);
        return res[0][0] + res[1][0];
    }

    public static int[][] matrixPower(int[][] m, int p) {
        int[][] res = new int[m.length][m[0].length];
        for (int i = 0; i < res.length; i++) {
            res[i][i] = 1;
        }

        // res = 矩阵中的1
        int[][] tmp = m;// 矩阵1次方
        for (; p != 0; p >>= 1) {
            if ((p & 1) != 0) {
                res = multiMatrix(res, tmp);
            }
            tmp = multiMatrix(tmp, tmp);
        }
        return res;
    }

    public static int[][] multiMatrix(int[][] m1, int[][] m2) {
        int[][] res = new int[m1.length][m2[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2[0].length; j++) {
                for (int k = 0; k < m2.length; k++) {
                    res[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] m1 = {{2, 1},
                {4, 3}};
        int[][] m2 = {{1, 2},
                {1, 0}};
        int[][] ans = multiMatrix(m1, m2);
        for (int[] row : ans) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println(f1(6));
        System.out.println(f2(6));
        System.out.println(f3(6));
    }
}
