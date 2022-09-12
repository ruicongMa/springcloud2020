package topinterviewquestions;

import java.util.Stack;

/**
 * @author Mark
 * @date 2022/3/15 15:20
 */
public class Problem_0084_LargestRectangleInHistogram {

    // 柱状图中最大的矩形：https://leetcode.com/problems/largest-rectangle-in-histogram/
    public static int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int maxArea = 0;
        // 只放下标
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] <= height[stack.peek()]) {
                int j = stack.pop();
                int k = stack.isEmpty() ? -1 : stack.peek();
                int curArea = (i - k - 1) * height[j];
                maxArea = Math.max(maxArea, curArea);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int j = stack.pop();
            int k = stack.isEmpty() ? -1 : stack.peek();
            int curArea = (height.length - k - 1) * height[j];
            maxArea = Math.max(maxArea, curArea);
        }
        return maxArea;
    }

    // 数组实现的单调栈
    public static int largestRectangleArea2(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int N = height.length;
        int[] stack = new int[N];
        int si = 0;
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            while (si != 0 && height[i] <= height[stack[si - 1]]) {
                int j = stack[--si];
                int k = si == 0 ? -1 : stack[si - 1];
                int curArea = (i - k - 1) * height[j];
                maxArea = Math.max(maxArea, curArea);
            }
            stack[si++] = i;
        }
        while (si != 0) {
            int j = stack[--si];
            int k = si == 0 ? -1 : stack[si - 1];
            int curArea = (height.length - k - 1) * height[j];
            maxArea = Math.max(maxArea, curArea);
        }
        return maxArea;
    }
}
