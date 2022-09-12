package topinterviewquestions;

/**
 * @author Mark
 * @date 2022/3/10 22:55
 */
public class Problem_0036_ValidSudoku {

    // 有效的数独：https://leetcode.com/problems/valid-sudoku/submissions/

    public static boolean isValidSudoku(char[][] board) {
        // 9行9列，行 0~8，能放的数字为1~9，所以定义长度为10
        boolean[][] row = new boolean[9][10]; // row[2][7]：代表第2行有没有放7，有的话设置为true，没有默认就是false
        boolean[][] col = new boolean[9][10]; // col[2][3]：代表第2列有没有放3，有的话设置为true，没有默认就是false
        boolean[][] bucket = new boolean[9][10]; // bucket[2][4]：代表第2个块有没有4，有的话设置为true，没有默认就是false
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int bid = 3 * (i / 3) + (j / 3);
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    if (row[i][num] || col[j][num] || bucket[bid][num]) {
                        return false;
                    }
                    row[i][num] = true;
                    col[j][num] = true;
                    bucket[bid][num] = true;
                }
            }
        }
        return true;
    }
}
