package topinterviewquestions;

import java.util.LinkedList;

/**
 * @author Mark
 * @date 2022/3/28 21:34
 */
public class Problem_0239_SlidingWindowMaximum {

    // 滑动窗口最大值：https://leetcode.com/problems/sliding-window-maximum/
    public static int[] maxSlidingWindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int R = 0; R < arr.length; R++) {
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[R]) {
                qmax.pollLast();
            }
            qmax.addLast(R);
            if (qmax.peekFirst() == R - w) {
                qmax.pollFirst();
            }
            if (R >= w - 1) {
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }
}
