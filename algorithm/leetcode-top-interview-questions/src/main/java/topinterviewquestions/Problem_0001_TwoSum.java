package topinterviewquestions;

import java.util.HashMap;

/**
 * @author Mark
 * @date 2022/3/8 18:49
 */
public class Problem_0001_TwoSum {

    // 两数之和：https://leetcode.com/problems/two-sum/
    public static int[] twoSum(int[] nums, int target) {
        // key 某个之前的数   value 这个数出现的位置
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
