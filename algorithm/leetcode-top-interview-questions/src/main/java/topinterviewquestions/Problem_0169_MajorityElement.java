package topinterviewquestions;

/**
 * @author Mark
 * @date 2022/3/26 17:46
 */
public class Problem_0169_MajorityElement {

    // 多数元素：https://leetcode.com/problems/majority-element/
    public static int majorityElement(int[] nums) {
        int cand = 0; // 靶子
        int HP = 0; // 血量
        for (int i = 0; i < nums.length; i++) {
            if (HP == 0) { // 血量为0，立靶子，增加血量
                cand = nums[i];
                HP = 1;
            } else if (nums[i] == cand) { // 血量不为0
                HP++; // 相同靶子增加血量
            } else { // 血量不为0，不同靶子减少血量
                HP--;
            }
        }
        return cand;
    }
}
