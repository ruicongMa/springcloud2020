package topinterviewquestions;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Mark
 * @date 2022/3/31 23:26
 */
public class Problem_0349_IntersectionOfTwoArrays {

    // 两个数组的交集 II：https://leetcode.com/problems/intersection-of-two-arrays/
    public static int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        for (int num : nums1) {
            if (!map1.containsKey(num)) {
                map1.put(num, 1);
            } else {
                map1.put(num, map1.get(num) + 1);
            }
        }
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for (int num : nums2) {
            if (!map2.containsKey(num)) {
                map2.put(num, 1);
            } else {
                map2.put(num, map2.get(num) + 1);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int key : map1.keySet()) {
            if (map2.containsKey(key)) {
                list.add(key);
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
