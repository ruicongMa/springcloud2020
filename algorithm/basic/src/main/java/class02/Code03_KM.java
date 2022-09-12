package class02;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mark
 * @date 2022/2/13 20:24
 */
public class Code03_KM {

    public static int test(int[] arr, int k, int m) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (int num : map.keySet()) {
            if (map.get(num) == k) {
                return num;
            }
        }
        return -1;
    }

    // 一个数组中有一种数出现K次，其他数都出现了M次，M > 1,  K < M，找到出现了K次的数，要求额外空间复杂度O(1)，时间复杂度O(N)

    // 请保证arr中，只有一种数出现了K次，其他数都出现了M次
    // 时间复杂度O(N) 额外空间复杂度O(1)
    public static int onlyKTimes(int[] arr, int k, int m) {
        int[] t = new int[32]; // 额外空间复杂度O(1)
        // t[0] 0位置上的1出现了几个
        // t[i] i位置上的1出现了几个
        for (int num : arr) { // O(N)
            for (int i = 0; i <= 31; i++) { // 固定次数
                t[i] += (num >> i) & 1;
                // if (((num >> i) & 1) != 0) {
                //     t[i]++;
                // }
            }
        }
        int ans = 0; // 干干净净，往上填答案，构建答案
        for (int i = 0; i < 32; i++) { // 固定次数
            if (t[i] % m != 0) { // 说明k在i位上，有1
                ans |= (1 << i);
            }
        }
        return ans;
    }

    public static int[] randomArray(int maxKinds, int range, int k, int m) {
        return null;
    }

    public static void main(String[] args) {
        int kinds = 10;
        int range = 200;
        int testTime = 100000;
        int max = 9;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int a = (int) (Math.random() * max) + 1; // a 1 ~ 9
            int b = (int) (Math.random() * max) + 1; // a 1 ~ 9
            int k = Math.min(a, b);
            int m = Math.max(a, b);
            // k < m
            if (k == m) {
                m++;
            }
            int[] arr = randomArray(kinds, range, k, m);
            int ans1 = test(arr, k, m);
            int ans2 = onlyKTimes(arr, k, m);
            if (ans1 != ans2) {
                System.out.println("出错了！");
                break;
            }
        }
        System.out.println("测试结束");
    }
}
