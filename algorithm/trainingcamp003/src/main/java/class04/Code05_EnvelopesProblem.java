package class04;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Mark
 * @date 2022/4/10 21:09
 */
public class Code05_EnvelopesProblem {

    // 信封最大的嵌套层数

    /**
     * 每个信封都有长和宽两个维度的数据，A信封如果想套在B信封里面，A信封必须在长和宽上都小于B信封才行。如果给你一批信封，返回最大的嵌套层数。
     */
    public static class Envelope {
        public int l; // 信封的长度
        public int h; // 信封的高度

        public Envelope(int weight, int height) {
            l = weight;
            h = height;
        }
    }

    // 先按照信封的长度从小到大排序，如果长度相等按照信封的高度从大到小排序
    public static class EnvelopeComparator implements Comparator<Envelope> {
        @Override
        public int compare(Envelope o1, Envelope o2) {
            return o1.l != o2.l ? o1.l - o2.l : o2.h - o1.h;
        }
    }

    public static Envelope[] getSortedEnvelopes(int[][] matrix) {
        Envelope[] res = new Envelope[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            res[i] = new Envelope(matrix[i][0], matrix[i][1]);
        }
        Arrays.sort(res, new EnvelopeComparator());
        return res;
    }

    public static int maxEnvelopes(int[][] matrix) {
        Envelope[] envelopes = getSortedEnvelopes(matrix);
        int[] ends = new int[matrix.length];
        ends[0] = envelopes[0].h;
        int right = 0; // 有效区
        int L = 0;
        int R = 0;
        int M = 0;
        for (int i = 1; i < envelopes.length; i++) {
            L = 0;
            R = right;
            while (L <= R) {
                M = (L + R) / 2;
                if (envelopes[i].h > ends[M]) {
                    L = M + 1;
                } else {
                    R = M - 1;
                }
            }
            // L = right + 1
            right = Math.max(right, L);
            ends[L] = envelopes[i].h;
        }
        return right + 1;
    }

    public static void main(String[] args) {
        int[][] test = {{3, 4}, {2, 3}, {4, 5}, {1, 3}, {2, 2}, {3, 6}, {1, 2}, {3, 2}, {2, 4}};
        System.out.println(maxEnvelopes(test));
    }
}
