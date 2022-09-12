import java.util.Arrays;

/**
 * 绳子最大能盖住的点
 *
 * @author Mark
 * @date 2021/9/15 17:23
 */
public class Code01_CordCoverMaxPoint {

    /**
     * 给定一个有序数组arr，代表坐落在X轴上的点
     * 给定一个正数K，代表绳子的长度
     * 返回绳子最多压中几个点？
     * 即使绳子边缘处盖住点也算盖住
     */

    /**
     * 贪心：绳子的末尾处放到每个元素的时候，往前判断能盖住几个点
     * 方法一：时间复杂度O(N * logN)
     */
    // 1 3 4 7 12 13
    // 4
    public static int maxPoint1(int[] arr, int L) {
        int ans = 1;
        for (int i = 0; i < arr.length; i++) {
            int nearestIndex = nearestIndex(arr, i, arr[i] - L);
            ans = Math.max(ans, i - nearestIndex + 1);
        }
        return ans;
    }

    // O(logN)
    private static int nearestIndex(int[] arr, int R, int value) {
        int L = 0;
        int index = R;
        while (L <= R) {
            int M = L + ((R - L) >> 1);
            if (arr[M] >= value) {
                index = M;
                R = M - 1;
            } else {
                L = M + 1;
            }
        }
        return index;
    }

    /**
     * 方法二：时间复杂度O(N)
     * 类似时间滑动窗口，不回退
     */
    // 1 3 4 7 12 13
    // 4
    public static int maxPoint2(int[] arr, int L) {
        int left = 0;
        int right = 0;
        int N = arr.length;
        int max = 0;
        while (left < N) {
            while (right < N && arr[right] - arr[left] <= L) {
                right++;
            }
            max = Math.max(max, right - (left++));
        }
        return max;
    }

    // for test
    public static int test(int[] arr, int L) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int pre = i - 1;
            while (pre >= 0 && arr[i] - arr[pre] <= L) {
                pre--;
            }
            max = Math.max(max, i - pre);
        }
        return max;
    }

    // for test
    public static int[] generateArray(int len, int max) {
        int[] ans = new int[(int) (Math.random() * len) + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = (int) (Math.random() * max);
        }
        Arrays.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        int len = 100;
        int max = 1000;
        int testTime = 100000;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int L = (int) (Math.random() * max);
            int[] arr = generateArray(len, max);
            int ans1 = maxPoint1(arr, L);
            int ans2 = maxPoint2(arr, L);
            int ans3 = test(arr, L);
            if (ans1 != ans2 || ans2 != ans3) {
                System.out.println("oops!");
                break;
            }
        }
        System.out.println("测试结束");
    }
}
