package topinterviewquestions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author Mark
 * @date 2022/3/12 13:22
 */
public class Problem_0047_PermutationsII {

    // 全排列II：https://leetcode.com/problems/permutations-ii/
    // 数组有重复数的全排列
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        process(nums, 0, ans);
        return ans;
    }

    public static void process(int[] nums, int index, List<List<Integer>> ans) {
        if (index == nums.length) {
            ArrayList<Integer> cur = new ArrayList<>();
            for (int num : nums) {
                cur.add(num);
            }
            ans.add(cur);
        } else {
            HashSet<Integer> set = new HashSet<>();  // 防重
            for (int j = index; j < nums.length; j++) {
                if (!set.contains(nums[j])) {
                    set.add(nums[j]);
                    swap(nums, index, j);
                    process(nums, index + 1, ans);
                    swap(nums, index, j);
                }
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
