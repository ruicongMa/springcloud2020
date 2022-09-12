import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Mark
 * @date 2021/9/1 19:27
 */
public class Code01_MonotonousStack {

    /**
     * 一种特别设计的栈结构，为了解决如下的问题：
     *
     * 给定一个可能含有重复值的数组arr，i位置的数一定存在如下两个信息
     * 1）arr[i]的左侧离i最近并且小于(或者大于)arr[i]的数在哪？
     * 2）arr[i]的右侧离i最近并且小于(或者大于)arr[i]的数在哪？
     * 如果想得到arr中所有位置的两个信息，怎么能让得到信息的过程尽量快。
     *
     * 那么到底怎么设计呢？
     */

    // arr = [ 3, 1, 2, 3]
    //         0  1  2  3
    //  [
    //     0 : [-1,  1]
    //     1 : [-1, -1]
    //     2 : [ 1, -1]
    //     3 : [ 2, -1]
    //  ]

    /**
     * 数组中没有重复的数：栈
     */
    public static int[][] getNearLessNoRepeat(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        int N = arr.length;
        int[][] ans = new int[N][2];
        // 只存位置！
        Stack<Integer> stack = new Stack<>();
        // 遍历到i位置的数arr[i]
        for (int i = 0; i < N; i++) {
            // 当前位置的数比栈顶位置的数小，没有机会往上摞，则弹出栈顶
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                int j = stack.pop();
                int leftLessIndex = stack.isEmpty() ? -1 : stack.peek();
                ans[j][0] = leftLessIndex;
                ans[j][1] = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int j = stack.pop();
            int leftLessIndex = stack.isEmpty() ? -1 : stack.peek();
            ans[j][0] = leftLessIndex;
            ans[j][1] = -1;
        }
        return ans;
    }

    /**
     * 数组中存在重复的数的设计方案： 栈 + 链表（相同值存在一起）
     */
    public static int[][] getNearLess(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        int N = arr.length;
        int[][] ans = new int[N][2];
        Stack<List<Integer>> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && arr[stack.peek().get(0)] > arr[i]) {
                List<Integer> popIds = stack.pop();
                int leftLessIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
                for (Integer popId : popIds) {
                    ans[popId][0] = leftLessIndex;
                    ans[popId][1] = i;
                }
            }
            if (!stack.isEmpty() && arr[stack.peek().get(0)] == arr[i]) {
                stack.peek().add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                stack.push(list);
            }
        }
        while (!stack.isEmpty()) {
            List<Integer> popIds = stack.pop();
            int leftLessIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
            for (Integer popId : popIds) {
                ans[popId][0] = leftLessIndex;
                ans[popId][1] = -1;
            }
        }
        return ans;
    }

    // for test
    public static int[] getRandomArrayNoRepeat(int size) {
        int[] arr = new int[(int) (Math.random() * size) + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        for (int i = 0; i < arr.length; i++) {
            int swapIndex = (int) (Math.random() * arr.length);
            int tmp = arr[swapIndex];
            arr[swapIndex] = arr[i];
            arr[i] = tmp;
        }
        return arr;
    }

    // for test
    public static int[] getRandomArray(int size, int max) {
        int[] arr = new int[(int) (Math.random() * size) + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * max) - (int) (Math.random() * max);
        }
        return arr;
    }

    // for test
    public static int[][] rightWay(int[] arr) {
        int[][] res = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            int leftLessIndex = -1;
            int rightLessIndex = -1;
            int cur = i - 1;
            while (cur >= 0) {
                if (arr[cur] < arr[i]) {
                    leftLessIndex = cur;
                    break;
                }
                cur--;
            }
            cur = i + 1;
            while (cur < arr.length) {
                if (arr[cur] < arr[i]) {
                    rightLessIndex = cur;
                    break;
                }
                cur++;
            }
            res[i][0] = leftLessIndex;
            res[i][1] = rightLessIndex;
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[][] res1, int[][] res2) {
        if (res1.length != res2.length) {
            return false;
        }
        for (int i = 0; i < res1.length; i++) {
            if (res1[i][0] != res2[i][0] || res1[i][1] != res2[i][1]) {
                return false;
            }
        }

        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int size = 10;
        int max = 20;
        int testTimes = 2000000;
        System.out.println("测试开始");
        for (int i = 0; i < testTimes; i++) {
            int[] arr1 = getRandomArrayNoRepeat(size);
            int[] arr2 = getRandomArray(size, max);
            if (!isEqual(getNearLessNoRepeat(arr1), rightWay(arr1))) {
                System.out.println("Oops!");
                printArray(arr1);
                break;
            }
            if (!isEqual(getNearLess(arr2), rightWay(arr2))) {
                System.out.println("Oops!");
                printArray(arr2);
                break;
            }
        }
        System.out.println("测试结束");
    }
}
