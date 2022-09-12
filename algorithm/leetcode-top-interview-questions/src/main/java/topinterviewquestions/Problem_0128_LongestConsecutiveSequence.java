package topinterviewquestions;

import java.util.HashMap;

/**
 * @author Mark
 * @date 2022/3/24 11:15
 */
public class Problem_0128_LongestConsecutiveSequence {

    // 最长连续序列：https://leetcode.com/problems/longest-consecutive-sequence/
    public static int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = 0;
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
                int preLen = map.containsKey(num - 1) ? map.get(num - 1) : 0;
                int posLen = map.containsKey(num + 1) ? map.get(num + 1) : 0;
                int all = preLen + posLen + 1;
                map.put(num - preLen, all); // 只更新头
                map.put(num + posLen, all); // 只更新尾
                len = Math.max(len, all);
            }
        }
        return len;
    }
}
