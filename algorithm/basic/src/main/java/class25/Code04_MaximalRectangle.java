package class25;

import java.util.Stack;

/**
 * @author Mark
 * @date 2022/2/27 18:53
 */
public class Code04_MaximalRectangle {

    // 测试链接：https://leetcode.com/problems/maximal-rectangle/

    /**
     * 给定一个二维数组matrix，其中的值不是0就是1，
     * 返回全部由1组成的最大子矩形，内部有多少个1
     */
    // 压缩数组技巧 + 单调栈
    // 单调栈的时间复杂度为O(N)，N*N的矩阵有N行，时间复杂度为O(N²)
    public static int maximalRectangle(char[][] map) {
        if (map == null || map.length == 0 || map[0].length == 0) {
            return 0;
        }
        int maxArea = 0;
        int[] height = new int[map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                height[j] = map[i][j] == '0' ? 0 : height[j] + 1;
            }
            maxArea = Math.max(maxRecFromBottom(height), maxArea);
        }
        return maxArea;
    }

    // height是正方图数组
    private static int maxRecFromBottom(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int maxArea = 0;
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
}
