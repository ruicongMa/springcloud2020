package class01;

/**
 * @author Mark
 * @date 2022/2/13 15:45
 */
public class Code06_BSAwesome {

    // 局部最小值问题
    public static int getLessIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr.length == 1 || arr[0] < arr[1]) {
            return arr[0];
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr[arr.length - 1];
        }
        // 说明0位置和N-1位置都不是最小值，则中间必存在最小，去找他
        int L = 1;
        int R = arr.length - 2;
        while (L < R) {
            int mid = L + ((R - L) >> 1);
            if (arr[mid] > arr[mid + 1]) {
                L = mid + 1;
            } else if (arr[mid] > arr[mid - 1]) {
                R = mid - 1;
            } else {
                return mid;
            }
        }
        return L;
    }

}
