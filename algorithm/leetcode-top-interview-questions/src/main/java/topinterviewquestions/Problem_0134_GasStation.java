package topinterviewquestions;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Mark
 * @date 2022/3/24 19:41
 */
public class Problem_0134_GasStation {

    // 加油站：https://leetcode.com/problems/gas-station/

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        // -2,-2,-2,3,3
        // -2,-4,-6,-3,0,-2,-4,-6,-3,0
        canCompleteCircuit1(gas, cost);
        // test();
    }

    public static int canCompleteCircuit1(int[] gas, int[] cost) {
        boolean[] good = goodArray(gas, cost);
        for (int i = 0; i < gas.length; i++) {
            if (good[i]) {
                return i;
            }
        }
        return -1;
    }

    // public static void test() {
    //     int[] arr = {6, 5, 3, 7, 5, 1, 7, 6, 4, 8, 6, 2};
    //     LinkedList<Integer> w = new LinkedList<>();
    //     int N = 6;
    //     for (int i = 0; i < N; i++) {
    //         while (!w.isEmpty() && arr[w.peekLast()] >= arr[i]) {
    //             w.pollLast();
    //         }
    //         w.addLast(i);
    //     }
    //     System.out.println(w);
    //     boolean[] ans = new boolean[N];
    //     for (int offset = 0, i = 0, j = N; j < 12; offset = arr[i++], j++) {
    //         if (arr[w.peekFirst()] - offset >= 0) {
    //             ans[i] = true;
    //         }
    //         if (w.peekFirst() == i) {
    //             w.pollFirst();
    //         }
    //         while (!w.isEmpty() && arr[w.peekLast()] >= arr[j]) {
    //             w.pollLast();
    //         }
    //         w.addLast(j);
    //     }
    //     System.out.println(Arrays.toString(ans));
    // }

    public static boolean[] goodArray(int[] g, int[] c) {
        int N = g.length;
        int M = N << 1;
        int[] arr = new int[M];
        for (int i = 0; i < N; i++) {
            arr[i] = g[i] - c[i];
            arr[i + N] = g[i] - c[i];
        }
        for (int i = 1; i < M; i++) {
            arr[i] += arr[i - 1];
        }
        LinkedList<Integer> w = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            while (!w.isEmpty() && arr[w.peekLast()] >= arr[i]) {
                w.pollLast();
            }
            w.addLast(i);
        }
        boolean[] ans = new boolean[N];
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

    // 这个方法的时间复杂度O(N)，额外空间复杂度O(1) 训练营讲了
    public static int canCompleteCircuit2(int[] gas, int[] cost) {
        if (gas == null || gas.length == 0) {
            return -1;
        }
        if (gas.length == 1) {
            return gas[0] < cost[0] ? -1 : 0;
        }
        boolean[] good = stations(cost, gas);
        for (int i = 0; i < gas.length; i++) {
            if (good[i]) {
                return i;
            }
        }
        return -1;
    }

    public static boolean[] stations(int[] cost, int[] gas) {
        if (cost == null || gas == null || cost.length < 2 || cost.length != gas.length) {
            return null;
        }
        int init = changeDisArrayGetInit(cost, gas);
        return init == -1 ? new boolean[cost.length] : enlargeArea(cost, init);
    }

    public static int changeDisArrayGetInit(int[] dis, int[] oil) {
        int init = -1;
        for (int i = 0; i < dis.length; i++) {
            dis[i] = oil[i] - dis[i];
            if (dis[i] >= 0) {
                init = i;
            }
        }
        return init;
    }

    public static boolean[] enlargeArea(int[] dis, int init) {
        boolean[] res = new boolean[dis.length];
        int start = init;
        int end = nextIndex(init, dis.length);
        int need = 0;
        int rest = 0;
        do {
            // 当前来到的start已经在连通区域中，可以确定后续的开始点一定无法转完一圈
            if (start != init && start == lastIndex(end, dis.length)) {
                break;
            }
            // 当前来到的start不在连通区域中，就扩充连通区域
            if (dis[start] < need) { // 当前start无法接到连通区的头部
                need -= dis[start];
            } else { // 当前start可以接到连通区的头部，开始扩充连通区域的尾巴
                rest += dis[start] - need;
                need = 0;
                while (rest >= 0 && end != start) {
                    rest += dis[end];
                    end = nextIndex(end, dis.length);
                }
                // 如果连通区域已经覆盖整个环，当前的start是良好出发点，进入2阶段
                if (rest >= 0) {
                    res[start] = true;
                    connectGood(dis, lastIndex(start, dis.length), init, res);
                    break;
                }
            }
            start = lastIndex(start, dis.length);
        } while (start != init);
        return res;
    }

    // 已知start的next方向上有一个良好出发点
    // start如果可以达到这个良好出发点，那么从start出发一定可以转一圈
    public static void connectGood(int[] dis, int start, int init, boolean[] res) {
        int need = 0;
        while (start != init) {
            if (dis[start] < need) {
                need -= dis[start];
            } else {
                res[start] = true;
                need = 0;
            }
            start = lastIndex(start, dis.length);
        }
    }

    public static int lastIndex(int index, int size) {
        return index == 0 ? (size - 1) : index - 1;
    }

    public static int nextIndex(int index, int size) {
        return index == size - 1 ? 0 : (index + 1);
    }
}
