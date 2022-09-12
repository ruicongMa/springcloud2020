package topinterviewquestions;

/**
 * @author Mark
 * @date 2022/3/11 11:29
 */
public class Problem_0041_FirstMissingPositive {

    // 缺失的第一个正数：https://leetcode.com/problems/first-missing-positive/
    public static int firstMissingPositive(int[] arr) {
        // 数组长度为5，L开始指向0位置，R开始指向越界5位置
        // 1  2  3  4  5
        // 0  1  2  3  4  5
        // L              R
        int L = 0;
        int R = arr.length;
        while (L < R) {
            if (arr[L] == L + 1) { // 刚刚好
                L++;
            } else if (arr[L] <= L || arr[L] > R || arr[arr[L] - 1] == arr[L]) {
                // arr[L] <= L，负数出现或arr[0...L-1]上已经出现过，去垃圾区
                // arr[L] > R 超过R范围，去垃圾区
                // arr[arr[L]-1] == arr[L] 出现重复数字，去垃圾区
                swap(arr, L, --R);
            } else {
                // 没变差，在1~R范围内，不去垃圾区，继续看交换后的位置
                swap(arr, L, arr[L] - 1);
            }
        }
        return L + 1;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        // int[] arr = {3, 0, -5, 8};
        int[] arr = {1, 2, 3, 5, 6};
        System.out.println(firstMissingPositive(arr));
    }

}
