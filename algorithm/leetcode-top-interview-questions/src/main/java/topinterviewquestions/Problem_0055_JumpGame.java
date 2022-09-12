package topinterviewquestions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Mark
 * @date 2022/3/11 17:21
 */
public class Problem_0055_JumpGame {

    // 跳跃游戏：https://leetcode.com/problems/jump-game/
    public static boolean canJump(int[] nums) {
        if (nums == null || nums.length < 2) {
            return true;
        }
        // max代表能跳到右侧的最大位置
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i > max) {
                return false;
            }
            max = Math.max(max, i + nums[i]);
        }
        return true;
    }

}
