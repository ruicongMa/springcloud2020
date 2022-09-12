package class07;

/**
 * @author Mark
 * @date 2022/4/15 16:52
 */
public class Code01_MinLengthForSort {

    // 最短子数组长度的排序让数组整体有序

    /**
     * 给定一个无序数组arr，如果只能再一个子数组上排序
     * 返回如果让arr整体有序，需要排序的最短子数组长度
     */
    public static int getMinLength(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int min = arr[arr.length - 1];
        int noMinIndex = -1; // 画×的最小值从右往左过一遍，把不满足的记录下来
        for (int i = arr.length - 2; i != -1; i--) {
            if (arr[i] > min) {
                noMinIndex = i;
            } else {
                min = Math.min(min, arr[i]);
            }
        }
        if (noMinIndex == -1) {
            return 0;
        }
        int max = arr[0];
        int noMaxIndex = -1; // 画×的最大值从左往右过一遍，把不满足的记录下来
        for (int i = 1; i != arr.length; i++) {
            if (arr[i] < max) {
                noMaxIndex = i;
            } else {
                max = Math.max(max, arr[i]);
            }
        }
        return noMaxIndex - noMinIndex + 1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
        System.out.println(getMinLength(arr));
    }
}
