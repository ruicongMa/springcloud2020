package topinterviewquestions;

/**
 * @author Mark
 * @date 2022/3/30 16:26
 */
public class Problem_0289_GameOfLife {

    // 有关这个游戏更有意思、更完整的内容：
    // https://www.bilibili.com/video/BV1rJ411n7ri
    // 也推荐这个up主
    // 生命游戏：https://leetcode.com/problems/game-of-life/
    public static void gameOfLife(int[][] board) {
        int N = board.length;
        int M = board[0].length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int neighbors = neighbors(board, i, j);
                if (neighbors == 3 || (board[i][j] == 1 && neighbors == 2)) {
                    set(board, i, j);
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 获取下一状态设置进去
                board[i][j] = get(board, i, j);
            }
        }
    }

    // 统计当前点的邻居数
    public static int neighbors(int[][] board, int i, int j) {
        int count = 0;
        count += ok(board, i - 1, j - 1) ? 1 : 0; // 左上邻居
        count += ok(board, i - 1, j) ? 1 : 0; // 上邻居
        count += ok(board, i - 1, j + 1) ? 1 : 0; // 右上邻居
        count += ok(board, i, j - 1) ? 1 : 0; // 左邻居
        count += ok(board, i, j + 1) ? 1 : 0; // 右邻居
        count += ok(board, i + 1, j - 1) ? 1 : 0; // 左下邻居
        count += ok(board, i + 1, j) ? 1 : 0; // 下邻居
        count += ok(board, i + 1, j + 1) ? 1 : 0; // 右下邻居
        return count;
    }

    // 统计是否是活细胞
    public static boolean ok(int[][] board, int i, int j) {
        return i >= 0 && i < board.length && j >= 0 && j < board[0].length && (board[i][j] & 1) == 1;
    }

    // 2的二进制位 10
    // 如果当前格子是死细胞，则 00 | 10 为 10，当前格子还是死细胞，下一状态为活细胞
    // 如果当前格子是活细胞，则 01 | 10 为 11，当前格子还是活细胞，下一状态还是活细胞
    // 根据相邻数规则设置下一状态为活细胞还是死细胞
    public static void set(int[][] board, int i, int j) {
        board[i][j] |= 2;
    }

    // 获取下一状态值
    public static int get(int[][] board, int i, int j) {
        return board[i][j] >> 1;
    }
}
