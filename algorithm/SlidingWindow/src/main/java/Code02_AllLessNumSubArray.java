import java.util.LinkedList;

/**
 * @author Mark
 * @date 2021/11/3 10:31
 */
public class Code02_AllLessNumSubArray {

    /**
     * 给定一个正整数数组arr，和一个整数num
     * 某个arr中的子数组sub，如果想达标，必须满足：
     * sub中最大值 – sub中最小值 <= num，
     * 返回arr中达标子数组的数量
     */

    /**
     * 结论：
     * 1）如果sub[L...R]范围内 sub中最大值 – sub中最小值 <= num,
     * 那么sub[L'...R']范围内 必然满足 sub中最大值 – sub中最小值 <= num
     * <p>
     * 2）如果sub[L...R]范围内 不满足条件，那么L向左扩或R向右扩，必然不达标
     */

    public static int getNum(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        LinkedList<Integer> qMin = new LinkedList<>();
        LinkedList<Integer> qMax = new LinkedList<>();
        int L = 0;
        int R = 0;
        int res = 0;
        // L是开头位置，尝试每一个开头
        while (L < arr.length) {
            // 如果此时窗口的开头是L,下面的while工作:R向右扩到违规为止
            // R是最后一个达标位置的再下一个
            while (R < arr.length) {
                // 小->大
                while (!qMin.isEmpty() && arr[qMin.peekLast()] >= arr[R]) {
                    qMin.pollLast();
                }
                qMin.addLast(R);
                // 大->小
                while (!qMax.isEmpty() && arr[qMax.peekLast()] <= arr[R]) {
                    qMax.pollLast();
                }
                qMax.addLast(R);
                if (arr[qMax.peekFirst()] - arr[qMin.peekFirst()] > num) {
                    break;
                }
                R++;
            }
            // R是最后一个达标位置的再下一个，第一个违规的位置
            res += R - L;
            if (qMin.peekFirst() == L) {
                qMin.pollFirst();
            }
            if (qMax.peekFirst() == L) {
                qMax.pollFirst();
            }
            L++;
        }
        return res;
    }

    // for test
    public static int[] getRandomArray(int len) {
        if (len < 0) {
            return null;
        }
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int) (Math.random() * 10);
        }
        return arr;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] arr = getRandomArray(30);
        int num = 5;
        printArray(arr);
        System.out.println(getNum(arr, num));
    }

}
