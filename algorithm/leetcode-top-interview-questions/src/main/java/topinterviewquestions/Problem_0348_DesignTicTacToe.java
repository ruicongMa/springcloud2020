package topinterviewquestions;

/**
 * @author Mark
 * @date 2022/3/31 23:07
 */
public class Problem_0348_DesignTicTacToe {

    // 设计井字棋：https://leetcode.com/problems/design-tic-tac-toe
    class TicTacToe {
        private int[][] rows;
        private int[][] cols;
        private int[] leftUp;
        private int[] rightUp;
        private boolean[][] matrix;
        private int N;

        // 0没用，1代表玩家1，2代表玩家2
        public TicTacToe(int n) {
            // 玩家1和玩家2在n行2列上玩 竖线
            rows = new int[n][3]; //0 1 2
            // 玩家1和玩家2在n列2行上玩 横线
            cols = new int[n][3]; // 0 1 2
            // 左对角线
            leftUp = new int[3]; //  1 2
            // 右对角线
            rightUp = new int[3]; // 1 2
            matrix = new boolean[n][n];
            N = n;
        }

        public int move(int row, int col, int player) {
            if (matrix[row][col]) {
                return 0;
            }
            matrix[row][col] = true;
            rows[row][player]++;
            cols[col][player]++;
            if (row == col) { // 左对角线
                leftUp[player]++; // 棋子加1
            }
            if (row + col == N - 1) { // 右对角线
                rightUp[player]++; // 棋子加1
            }
            // 横线、竖线、左对角线、右对角线上，只要棋子个数为N，就代表玩家赢了
            if (rows[row][player] == N || cols[col][player] == N || leftUp[player] == N || rightUp[player] == N) {
                return player;
            }
            return 0;
        }

    }
}
