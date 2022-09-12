package topinterviewquestions;

/**
 * @author Mark
 * @date 2022/3/28 22:50
 */
public class Problem_0251_Flatten2DVector {

    // 展开二维向量：https://leetcode.com/problems/flatten-2d-vector
    public static class Vector2D {
        private int[][] matrix;
        private int row;
        private int col;
        private boolean curUse;

        public Vector2D(int[][] v) {
            matrix = v;
            row = 0;
            col = -1;
            curUse = true;
            hasNext();
        }

        public int next() {
            int ans = matrix[row][col];
            curUse = true;
            hasNext();
            return ans;
        }

        public boolean hasNext() {
            if (row == matrix.length) {
                return false;
            }
            if (!curUse) {
                return true;
            }
            // (row，col)用过了
            if (col < matrix[row].length - 1) {
                col++;
            } else {
                col = 0;
                do {
                    row++;
                } while (row < matrix.length && matrix[row].length == 0);
            }
            // 新的(row，col)
            if (row != matrix.length) {
                curUse = false;
                return true;
            } else {
                return false;
            }
        }

    }

    public static void main(String[] args) {
        int[][] v = {{1, 2}, {3}, {}, {}, {4}, {}, {5, 8, 10}, {}, {12}};
        Vector2D iterator = new Vector2D(v);
        // 1 2 3 4 5 8 10 12
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
