package class03;

/**
 * @author Mark
 * @date 2022/4/9 10:34
 */
public class Code03_MinPathSum {

    // 二维矩阵最小路径和

    /**
     * 给定一个二维数组matrix，其中每个数都是正数，要求从左上到右下，每一步只能向右或者向下，沿途经过的数字要累加起来，最后请返回最小的路径和
     */
    // 方法一：二维dp
    public static int minPathSum1(int[][] m) {
        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
            return 0;
        }
        int row = m.length;
        int col = m[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = m[0][0];
        for (int i = 1; i < row; i++) { // 第一列格子只依赖上边格子
            dp[i][0] = dp[i - 1][0] + m[i][0];
        }
        for (int j = 1; j < col; j++) { // 第一行格子只依赖左边格子
            dp[0][j] = dp[0][j - 1] + m[0][j];
        }
        // 其他格子依赖于上边格子和左边格子
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + m[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }

    public static int minPathSum2(int[][] m) {
        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
            return 0;
        }
        int more = Math.max(m.length, m[0].length);
        int less = Math.min(m.length, m[0].length);
        boolean rowmore = more == m.length;
        int[] arr = new int[less];
        arr[0] = m[0][0];
        for (int i = 1; i < less; i++) {
            arr[i] = arr[i - 1] + (rowmore ? m[0][i] : m[i][0]);
        }
        for (int i = 1; i < more; i++) {
            arr[0] = arr[0] + (rowmore ? m[i][0] : m[0][i]);
            for (int j = 1; j < less; j++) {
                arr[j] = Math.min(arr[j - 1], arr[j])
                        + (rowmore ? m[i][j] : m[j][i]);
            }
        }
        return arr[less - 1];
    }

    // 方法二：一维dp，利用空间压缩技巧
    public static int minPathSum3(int[][] m) {
        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
            return 0;
        }
        int[] dp = new int[m[0].length];
        int N = m.length;
        int M = m[0].length;
        dp[0] = m[0][0];
        for (int col = 1; col < M; col++) { // 第一行格子只依赖左边格子
            dp[col] = dp[col - 1] + m[0][col];
        }
        for (int row = 1; row < N; row++) { // 从上往下整体更新dp值
            dp[0] = dp[0] + m[row][0];
            for (int col = 1; col < M; col++) {
                dp[col] = Math.min(dp[col - 1], dp[col]) + m[row][col];
            }
        }
        return dp[M - 1];
    }


    // for test
    public static int[][] generateRandomMatrix(int rowSize, int colSize) {
        if (rowSize < 0 || colSize < 0) {
            return null;
        }
        int[][] result = new int[rowSize][colSize];
        for (int i = 0; i != result.length; i++) {
            for (int j = 0; j != result[0].length; j++) {
                result[i][j] = (int) (Math.random() * 10);
            }
        }
        return result;
    }

    // for test
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // int[][] m = generateRandomMatrix(3, 4);
        int[][] m = {{1, 3, 5, 9}, {8, 1, 3, 4}, {5, 0, 6, 1},
                {8, 8, 4, 0}};
        printMatrix(m);
        System.out.println(minPathSum1(m));
        System.out.println(minPathSum2(m));
        System.out.println(minPathSum3(m));

    }
}
