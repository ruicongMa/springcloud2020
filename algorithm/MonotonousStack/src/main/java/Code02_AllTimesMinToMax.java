import java.util.Stack;

/**
 * @author Mark
 * @date 2021/9/2 11:16
 */
public class Code02_AllTimesMinToMax {

    /**
     * 给定一个只包含正数的数组arr，arr中任何一个子数组sub，
     * 一定都可以算出(sub累加和 )* (sub中的最小值)是什么，
     * 那么所有子数组中，这个值最大是多少？
     */

    // 暴力求解
    public static int max1(int[] arr) {
        int max = Integer.MIN_VALUE;
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                int minNum = Integer.MAX_VALUE;
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                    minNum = Math.min(minNum, arr[k]);
                }
                max = Math.max(max, sum * minNum);
            }
        }
        return max;
    }

    public static int max2(int[] arr) {
        int size = arr.length;
        int[] sums = new int[size];
        sums[0] = arr[0];
        for (int i = 1; i < size; i++) {
            sums[i] = sums[i - 1] + arr[i];
        }
        int max = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < size; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                int j = stack.pop();
                max = Math.max(max, (stack.isEmpty() ? sums[i - 1] : (sums[i - 1] - sums[stack.peek()])) * arr[j]);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int j = stack.pop();
            max = Math.max(max, (stack.isEmpty() ? sums[size - 1] : (sums[size - 1] - sums[stack.peek()])) * arr[j]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println("test begin");
        int[] arr = {3, 4, 5, 2, 7};
        if (max1(arr) != max2(arr)) {
            System.out.println("FUCK!");
            return;
        }
        System.out.println("test finish");
    }
}
