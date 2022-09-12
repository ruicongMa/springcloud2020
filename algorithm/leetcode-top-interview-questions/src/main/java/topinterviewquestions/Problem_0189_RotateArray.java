package topinterviewquestions;

/**
 * @author Mark
 * @date 2022/3/26 23:50
 */
public class Problem_0189_RotateArray {

    // 轮转数组：https://leetcode.com/problems/rotate-array/
    public void rotate1(int[] nums, int k) {
        int N = nums.length;
        k = k % N; // 取模操作，k有可能大于数组的长度
        if (k == 0) {
            return;
        }
        reverse(nums, 0, N - k - 1); // 左边反转
        reverse(nums, N - k, N - 1); // 右边反转
        reverse(nums, 0, N - 1); // 整体反转
    }

    public static void reverse(int[] nums, int L, int R) {
        while (L < R) {
            int tmp = nums[L];
            nums[L++] = nums[R];
            nums[R--] = tmp;
        }
    }

    public static void rotate2(int[] nums, int k) {
        int N = nums.length;
        k = k % N;
        if (k == 0) {
            return;
        }
        int L = 0;
        int R = N - 1;
        int lpart = N - k;
        int rpart = k;
        int same = Math.min(lpart, rpart);
        int diff = lpart - rpart;
        exchange(nums, L, R, same);
        while (diff != 0) {
            if (diff > 0) {
                L += same;
                lpart = diff;
            } else {
                R -= same;
                rpart = -diff;
            }
            same = Math.min(lpart, rpart);
            diff = lpart - rpart;
            exchange(nums, L, R, same);
        }
    }

    public static void exchange(int[] nums, int start, int end, int size) {
        int i = end - size + 1;
        int tmp = 0;
        while (size-- != 0) {
            tmp = nums[start];
            nums[start] = nums[i];
            nums[i] = tmp;
            start++;
            i++;
        }
    }
}
