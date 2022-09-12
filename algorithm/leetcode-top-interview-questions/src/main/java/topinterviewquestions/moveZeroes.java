package topinterviewquestions;

/**
 * @author Mark
 * @date 2022/3/30 14:16
 */
public class moveZeroes {

    // 移动零：https://leetcode.com/problems/move-zeroes/
    public static void moveZeroes(int[] nums) {
        int to = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, to++, i);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
