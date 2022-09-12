import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Mark
 * @date 2021/9/1 9:39
 */
public class Code01_SlidingWindowMaxArray {

    /**
     * 假设一个固定大小为W的窗口，依次划过arr，
     * 返回每一次滑出状况的最大值
     * 例如，arr = [4,3,5,4,3,3,6,7], W = 3
     * 返回：[5,5,5,4,6,7]
     */

    // 暴力解决
    public static int[] right(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        int N = arr.length;
        int L = 0;
        int R = w - 1;
        int[] ans = new int[N - w + 1];
        int index = 0;
        while (R < N) {
            int max = arr[L];
            for (int i = L + 1; i <= R; i++) {
                max = Math.max(max, arr[i]);
            }
            ans[index++] = max;
            R++;
            L++;
        }
        return ans;
    }

    // 利用滑动窗口，双端队列
    public static int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        LinkedList<Integer> queueMax = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int R = 0; R < arr.length; R++) {
            while (!queueMax.isEmpty() && arr[queueMax.peekLast()] <= arr[R]) {
                queueMax.pollLast();
            }
            queueMax.addLast(R);
            // 窗口过期下标
            if (queueMax.peekFirst() == R - w) {
                queueMax.pollFirst();
            }
            // 窗口预热，达到窗口大小时收集答案
            // 是否现在形成了正常窗口，窗口在未形成时，窗口属于培养期，不需要收集答案
            if (R >= w - 1) {
                res[index++] = arr[queueMax.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 5, 4, 3, 3, 6, 7};
        int w = 3;
        System.out.println(Arrays.toString(right(arr, w)));
        System.out.println(Arrays.toString(getMaxWindow(arr, w)));
    }

}
