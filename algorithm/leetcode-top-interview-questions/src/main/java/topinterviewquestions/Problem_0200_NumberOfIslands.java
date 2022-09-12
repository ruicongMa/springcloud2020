package topinterviewquestions;

/**
 * @author Mark
 * @date 2022/3/27 11:04
 */
public class Problem_0200_NumberOfIslands {

    // 岛屿数量（岛问题I）：https://leetcode.com/problems/number-of-islands/
    public static int numIslands(char[][] m) {
        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
            return 0;
        }
        int N = m.length;
        int M = m[0].length;
        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (m[i][j] == '1') {
                    res++;
                    infect(m, i, j, N, M);
                }
            }
        }
        return res;
    }

    // 目前来到m[i][j], 经历上下左右的感染过程
    public static void infect(char[][] m, int i, int j, int N, int M) {
        // 越界、0、感染过的（标记感染过的路，走过的路）都不用感染
        if (i < 0 || i >= N || j < 0 || j >= M || m[i][j] != '1') {
            return;
        }
        // 不越界而且是1
        m[i][j] = '2'; // 标记感染过，走过的路，不走回头路
        infect(m, i - 1, j, N, M); // 上
        infect(m, i + 1, j, N, M); // 下
        infect(m, i, j - 1, N, M); // 左
        infect(m, i, j + 1, N, M); // 右
    }
}
