package class04;

/**
 * @author Mark
 * @date 2022/4/11 23:40
 */
public class Code07_SubMatrixMaxSum {

    // 子矩阵的最大累加和

    /**
     * 给定一个整型矩阵，返回子矩阵的最大累加和。
     */
    public static int maxSum(int[][] m) {
        if (m == null || m.length == 0 || m[0].length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int cur = 0;
        int[] s = null;
        for (int i = 0; i < m.length; i++) { // 开始的行号i
            s = new int[m[0].length];
            for (int j = i; j < m.length; j++) { // 结束的行号j，i~j行是我讨论的范围
                cur = 0;
                for (int k = 0; k < s.length; k++) {
                    s[k] += m[j][k]; // 每列累加
                    cur += s[k]; // 一维数组最大累加和问题
                    max = Math.max(max, cur);
                    cur = cur < 0 ? 0 : cur;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] matrix = {{-90, 48, 78}, {64, -40, 64}, {-81, -7, 66}};
        System.out.println(maxSum(matrix));

    }
}
