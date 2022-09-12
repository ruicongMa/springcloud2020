package topinterviewquestions;

/**
 * @author Mark
 * @date 2022/3/13 10:28
 */
public class Problem_0048_RotateImage {

    // 旋转图像：https://leetcode.com/problems/rotate-image/
    public static void rotate(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while (tR < dR) { // 需要几圈（几轮） 外->内
            process(matrix, tR++, tC++, dR--, dC--);
        }
    }

    // 每圈（每轮）上数字依次旋转
    private static void process(int[][] m, int tR, int tC, int dR, int dC) {
        int times = dC - tC; // 每轮交换的次数
        int tmp = 0;
        for (int i = 0; i < times; i++) {
            tmp = m[tR][tC + i];
            m[tR][tC + i] = m[dR - i][tC];
            m[dR - i][tC] = m[dR][dC - i];
            m[dR][dC - i] = m[tR + i][dC];
            m[tR + i][dC] = tmp;
        }
    }
}
