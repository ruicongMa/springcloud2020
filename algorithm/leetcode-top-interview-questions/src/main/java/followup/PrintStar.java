package followup;

/**
 * @author Mark
 * @date 2022/3/13 11:28
 */
public class PrintStar {

    public static void printStar(int N) {
        int leftUp = 0;
        int rightDown = N - 1;
        char[][] m = new char[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                m[i][j] = ' '; // 整体都填一个空格
            }
        }
        while (leftUp < rightDown) { // 需要几层
            set(m, leftUp, rightDown); // 每层*的结构
            leftUp += 2;
            rightDown -= 2;
        }
        // 整体打印
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void set(char[][] m, int leftUp, int rightDown) {
        for (int col = leftUp; col <= rightDown; col++) { // 上边*
            m[leftUp][col] = '*';
        }
        for (int row = leftUp + 1; row <= rightDown; row++) { // 右边*
            m[row][rightDown] = '*';
        }
        for (int col = rightDown - 1; col > leftUp; col--) { // 下边*
            m[rightDown][col] = '*';
        }
        for (int row = rightDown - 1; row > leftUp + 1; row--) { // 左边*
            m[row][leftUp + 1] = '*';
        }
    }

    public static void main(String[] args) {
        printStar(10);
    }
}
