package toplikedquestions;

import java.util.HashMap;

/**
 * @author Mark
 * @date 2022/4/3 11:52
 */
public class Problem_0560_SubarraySumEqualsK {

    // 和为K的子数组：https://leetcode.com/problems/subarray-sum-equals-k/
    public static int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> preSumTimesMap = new HashMap<>();
        preSumTimesMap.put(0, 1);
        int all = 0; // 0..i
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            all += nums[i]; // 0....i 整体的前缀和
            if (preSumTimesMap.containsKey(all - k)) {
                ans += preSumTimesMap.get(all - k);
            }
            if (!preSumTimesMap.containsKey(all)) {
                preSumTimesMap.put(all, 1);
            } else {
                preSumTimesMap.put(all, preSumTimesMap.get(all) + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int k = 3;
        System.out.println(subarraySum(nums, k));
    }
}
