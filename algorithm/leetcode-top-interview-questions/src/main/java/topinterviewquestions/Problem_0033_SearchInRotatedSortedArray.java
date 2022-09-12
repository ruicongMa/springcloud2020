package topinterviewquestions;

/**
 * @author Mark
 * @date 2022/3/10 19:39
 */
public class Problem_0033_SearchInRotatedSortedArray {

    // 搜索旋转排序数组：https://leetcode.com/problems/search-in-rotated-sorted-array/
    public static int search(int[] arr, int num) {
        int L = 0;
        int R = arr.length - 1;
        int M = 0;
        while (L <= R) {
            M = (L + R) / 2;
            if (arr[M] == num) {
                return M;
            }
            // arr[M] != num
            if (arr[L] == arr[M] && arr[M] == arr[R]) {
                while (L != M && arr[L] == arr[M]) {
                    L++;
                }
                // L和M没撞上，[L]!=[M] L,.....M
                if (L == M) {
                    L = M + 1;
                    continue;
                }
            }
            // arr[M] != num
            // [L] [M] [R] 不都一样的情况
            if (arr[L] != arr[M]) {
                if (arr[M] > arr[L]) {
                    if (num >= arr[L] && num < arr[M]) {
                        R = M - 1;
                    } else {
                        L = M + 1;
                    }
                } else { //  [L]  >  [M]
                    if (num > arr[M] && num <= arr[R]) {
                        L = M + 1;
                    } else {
                        R = M - 1;
                    }
                }
            } else { // [L] === [M] ->  [M]!=[R]
                if (arr[M] < arr[R]) {
                    if (num > arr[M] && num <= arr[R]) {
                        L = M + 1;
                    } else {
                        R = M - 1;
                    }
                } else {
                    if (num >= arr[L] && num < arr[M]) {
                        R = M - 1;
                    } else {
                        L = M + 1;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 2, 2, 1, 2};
        System.out.println(search(arr, 2));
    }
}
