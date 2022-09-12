package topinterviewquestions;

/**
 * @author Mark
 * @date 2022/3/28 9:44
 */
public class Problem_0287_FindTheDuplicateNumber {

    // 寻找重复数：https://leetcode.com/problems/find-the-duplicate-number/
    public static int findDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) {
            return -1;
        }
        int slow = nums[0]; // 刚开始慢指针一次走一步
        int fast = nums[nums[0]]; // 刚开始快指针一次走两步
        while (slow != fast) { // 只要快慢指针没相遇就继续
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0; // 快慢指针相遇时，快指针从头开始
        while (slow != fast) {
            fast = nums[fast]; // 快指针一次走一步
            slow = nums[slow]; // 慢指针一次走一步
        }
        // 再次相遇就是入环节点，也就是重复数字
        return slow;
    }
}
