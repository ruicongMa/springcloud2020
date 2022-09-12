package class24;

import java.util.LinkedList;

/**
 * @author Mark
 * @date 2022/2/26 19:50
 */
public class Code03_GasStation {

    // https://leetcode.com/problems/gas-station/
    // 加油站的良好出发点问题
    // 这个方法的时间复杂度O(N)，额外空间复杂度O(N)
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        boolean[] good = goodArray(gas, cost);
        for (int i = 0; i < gas.length; i++) {
            if (good[i]) {
                return i;
            }
        }
        return -1;
    }

    public static boolean[] goodArray(int[] gas, int[] cost) {
        int N = gas.length;
        int M = N << 1; // 原始扩大1倍
        int[] arr = new int[M];
        // 前缀和
        for (int i = 0; i < N; i++) {
            arr[i] = gas[i] - cost[i];
            arr[i + N] = gas[i] - cost[i];
        }
        for (int i = 1; i < M; i++) {
            arr[i] += arr[i - 1];
        }
        LinkedList<Integer> w = new LinkedList<>();
        // 窗口大小为N，找到窗口内的最小值
        for (int i = 0; i < N; i++) {
            while (!w.isEmpty() && arr[w.peekLast()] >= arr[i]) {
                w.pollLast();
            }
            w.addLast(i);
        }
        boolean[] ans = new boolean[N];
        // 后续窗口形成时，依次找出窗口内的最小值，最小值 - offset = 原始数组累加和上的位置的数
        for (int offset = 0, i = 0, j = N; j < M; offset = arr[i++], j++) {
            if (arr[w.peekFirst()] - offset >= 0) {
                ans[i] = true;
            }
            if (w.peekFirst() == i) {
                w.pollFirst();
            }
            while (!w.isEmpty() && arr[w.peekLast()] >= arr[j]) {
                w.pollLast();
            }
            w.addLast(j);
        }
        return ans;
    }
}
