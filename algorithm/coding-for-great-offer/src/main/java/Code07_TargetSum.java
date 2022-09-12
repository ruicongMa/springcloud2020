import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/target-sum/
 *
 * @author Mark
 * @date 2021/9/15 18:49
 */
public class Code07_TargetSum {

    /**
     * 给定一个数组arr，你可以在每个数字之前决定+或者-
     * 但是必须所有数字都参与
     * 再给定一个数target，请问最后算出target的方法数是多少？
     */
    public static int findTargetSumWays1(int[] arr, int target) {
        return process1(arr, 0, target);
    }

    // arr[index...]
    private static int process1(int[] arr, int index, int rest) {
        if (index == arr.length) {
            return rest == 0 ? 1 : 0;
        }
        return process1(arr, index + 1, rest - arr[index])
                + process1(arr, index + 1, rest + arr[index]);
    }

    /**
     * 暴力递归->记忆化搜索（杀缓存）->动态规划（空间压缩技巧，二维变一维）
     */

    /**
     * 记忆化搜索
     */
    public static int findTargetSumWays2(int[] arr, int target) {
        return process2(arr, 0, target, new HashMap<>());
    }

    private static int process2(int[] arr, int index, int rest, Map<Integer, Map<Integer, Integer>> dp) {
        if (dp.containsKey(index) && dp.get(index).containsKey(rest)) {
            return dp.get(index).get(rest);
        }
        int ans = 0;
        if (index == arr.length) {
            ans = rest == 0 ? 1 : 0;
        } else {
            ans = process2(arr, index + 1, rest - arr[index], dp)
                    + process2(arr, index + 1, rest + arr[index], dp);
        }
        if (!dp.containsKey(index)) {
            dp.put(index, new HashMap<>());
        }
        dp.get(index).put(rest, ans);
        return ans;
    }
}
