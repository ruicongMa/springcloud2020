package class07;

import java.util.Arrays;

/**
 * @author Mark
 * @date 2022/4/16 7:30
 */
public class Code03_MinPatches {

    // 累加出整个范围所有的数最少还需几个数

    /**
     * 给定一个有序的正数数组arr和一个正数aim，如果可以自由选择arr中的数字，想累加得 到 1~aim 范围上所有的数，返回arr最少还缺几个数。
     * 【举例】
     * arr = {1,2,3,7}， aim = 15
     * 想累加得到 1~15 范围上所有的数，arr 还缺 14 这个数，所以返回1
     * arr = {1,5,7}， aim = 15
     * 想累加得到 1~15 范围上所有的数，arr 还缺 2 和 4，所以返回2
     */
    // arr请保证有序，且正数
    public static int minPatches(int[] arr, int aim) {
        int patches = 0; // 缺多少个数字
        long range = 0; // 已经完成了1 ~ range的目标
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            // 1~range
            // 1 ~ arr[i]-1
            while (arr[i] - 1 > range) { // arr[i] 1 ~ arr[i]-1
                range += range + 1; // range + 1 是缺的数字
                patches++;
                if (range >= aim) {
                    return patches;
                }
            }
            range += arr[i];
            if (range >= aim) {
                return patches;
            }
        }
        while (aim >= range + 1) {
            range += range + 1;
            patches++;
        }
        return patches;
    }

    public static int minPatches2(int[] arr, int K) {
        int patches = 0; // 缺多少个数字
        int range = 0; // 已经完成了1 ~ range的目标
        for (int i = 0; i != arr.length; i++) {
            // 1~range
            // 1 ~ arr[i]-1
            while (arr[i] > range + 1) { // arr[i] 1 ~ arr[i]-1
                if (range > Integer.MAX_VALUE - range - 1) {
                    return patches + 1;
                }
                range += range + 1; // range + 1 是缺的数字
                patches++;
                if (range >= K) {
                    return patches;
                }
            }
            if (range > Integer.MAX_VALUE - arr[i]) {
                return patches;
            }
            range += arr[i];
            if (range >= K) {
                return patches;
            }
        }
        while (K >= range + 1) {
            if (K == range && K == Integer.MAX_VALUE) {
                return patches;
            }
            if (range > Integer.MAX_VALUE - range - 1) {
                return patches + 1;
            }
            range += range + 1;
            patches++;
        }
        return patches;
    }

    public static void main(String[] args) {
        int[] test = {1, 2, 31, 33};
        int n = 2147483647;
        System.out.println(minPatches(test, n));

    }
}
