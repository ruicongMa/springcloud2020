package topinterviewquestions;

/**
 * @author Mark
 * @date 2022/3/31 20:06
 */
public class Problem_0334_IncreasingTripletSubsequence {

    // 递增的三元子序列：https://leetcode.com/problems/increasing-triplet-subsequence/
    public static boolean increasingTriplet(int[] arr) {
        if (arr == null || arr.length < 3) {
            return false;
        }
        int[] ends = new int[3];
        ends[0] = arr[0];
        int right = 0;
        int l = 0;
        int r = 0;
        int m = 0;
        for (int i = 1; i < arr.length; i++) {
            l = 0;
            r = right;
            while (l <= r) {
                m = (l + r) / 2;
                if (arr[i] > ends[m]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            right = Math.max(right, l);
            if (right > 1) {
                return true;
            }
            ends[l] = arr[i];
        }
        return false;
    }
}
