package topinterviewquestions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mark
 * @date 2022/3/13 13:18
 */
public class Problem_0054_SpiralMatrix {

    // 螺旋矩阵：https://leetcode.com/problems/spiral-matrix/
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return ans;
        }
        // 左上点坐标（a,b)
        int a = 0;
        int b = 0;
        // 右下点坐标（c,d）
        int c = matrix.length - 1;
        int d = matrix[0].length - 1;
        while (a <= c && b <= d) {
            addEdge(matrix, a++, b++, c--, d--, ans);
        }
        return ans;
    }

    public static void addEdge(int[][] m, int a, int b, int c, int d, List<Integer> ans) {
        if (a == c) { // 一横
            for (int i = b; i <= d; i++) {
                ans.add(m[a][i]);
            }
        } else if (b == d) { // 一竖
            for (int i = a; i <= c; i++) {
                ans.add(m[i][b]);
            }
        } else {
            int curC = b;
            int curR = a;
            while (curC != d) { // 上边
                ans.add(m[a][curC]);
                curC++;
            }
            while (curR != c) { // 右边
                ans.add(m[curR][d]);
                curR++;
            }
            while (curC != b) { // 下边
                ans.add(m[c][curC]);
                curC--;
            }
            while (curR != a) { // 左边
                ans.add(m[curR][b]);
                curR--;
            }
        }
    }
}
