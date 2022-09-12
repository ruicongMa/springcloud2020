package topinterviewquestions;

/**
 * @author Mark
 * @date 2022/3/10 16:13
 */
public class Problem_0026_RemoveDuplicatesFromSortedArray {

    // 删除有序数组中的重复项：https://leetcode.com/problems/remove-duplicates-from-sorted-array/

    public static int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length < 2) {
            return nums.length;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }

    public static int removeDuplicates2(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length < 2) {
            return nums.length;
        }
        int done = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[done]) {
                nums[++done] = nums[i];
            }
        }
        return done + 1;
    }
}
