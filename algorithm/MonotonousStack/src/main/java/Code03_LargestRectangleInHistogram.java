import java.util.Stack;

/**
 * @author Mark
 * @date 2021/9/2 14:11
 */
public class Code03_LargestRectangleInHistogram {

    /**
     * 测试链接：https://leetcode.com/problems/largest-rectangle-in-histogram
     * 给定一个非负数组arr，代表直方图
     * 返回直方图的最大长方形面积
     */

    public static int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        int N = height.length;
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && height[stack.peek()] >= height[i]) {
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
            int curArea = (N - k - 1) * height[j];
            maxArea = Math.max(maxArea, curArea);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(heights));
    }
}
