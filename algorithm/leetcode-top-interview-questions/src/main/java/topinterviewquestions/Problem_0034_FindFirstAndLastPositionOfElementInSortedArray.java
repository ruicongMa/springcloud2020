package topinterviewquestions;

/**
 * @author Mark
 * @date 2022/3/10 21:42
 */
public class Problem_0034_FindFirstAndLastPositionOfElementInSortedArray {

    // 在排序数组中查找元素的第一个和最后一个位置：https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

    public static int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        if (nums == null || nums.length == 0) {
            return ans;
        }
        ans[0] = findFirst(nums, target);
        ans[1] = findLast(nums, target);
        return ans;
    }

    public static int findFirst(int[] arr, int num) {
        int L = 0;
        int R = arr.length - 1;
        int ans = -1;
        int mid = 0;
        while (L <= R) {
            mid = L + ((R - L) >> 1);
            if (arr[mid] < num) {
                L = mid + 1;
            } else if (arr[mid] > num) {
                R = mid - 1;
            } else {
                ans = mid;
                R = mid - 1;
            }
        }
        return ans;
    }

    public static int findLast(int[] arr, int num) {
        int L = 0;
        int R = arr.length - 1;
        int ans = -1;
        int mid = 0;
        while (L <= R) {
            mid = L + ((R - L) >> 1);
            if (arr[mid] < num) {
                L = mid + 1;
            } else if (arr[mid] > num) {
                R = mid - 1;
            } else {
                ans = mid;
                L = mid + 1;
            }
        }
        return ans;
    }
}
