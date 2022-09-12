package topinterviewquestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Mark
 * @date 2022/3/9 23:39
 */
public class Problem_0018_4Sum {

    // 四数之和：https://leetcode.com/problems/4sum/
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int N = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = N - 1; i > 2; i--) {
            if (i == N - 1 || nums[i] != nums[i + 1]) {
                List<List<Integer>> nexts = threeSum(nums, i - 1, target - nums[i]);
                for (List<Integer> cur : nexts) {
                    cur.add(nums[i]); // 效率高，直接添加到结尾
                    ans.add(cur);
                }
            }
        }
        return ans;
    }

    public static List<List<Integer>> threeSum(int[] nums, int end, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = end; i > 1; i--) { // 从后往前遍历
            if (i == end || nums[i] != nums[i + 1]) {
                List<List<Integer>> nexts = twoSum(nums, i - 1, target - nums[i]);
                for (List<Integer> cur : nexts) {
                    cur.add(nums[i]); // 效率高，直接添加到结尾
                    ans.add(cur);
                }
            }
        }
        return ans;
    }

    public static List<List<Integer>> twoSum(int[] nums, int end, int target) {
        int L = 0;
        int R = end;
        List<List<Integer>> ans = new ArrayList<>();
        while (L < R) {
            if (nums[L] + nums[R] > target) {
                R--;
            } else if (nums[L] + nums[R] < target) {
                L++;
            } else {
                if (L == 0 || nums[L - 1] != nums[L]) {
                    List<Integer> cur = new ArrayList<>();
                    cur.add(nums[L]);
                    cur.add(nums[R]);
                    ans.add(cur);
                }
                L++;
            }
        }
        return ans;
    }
}
