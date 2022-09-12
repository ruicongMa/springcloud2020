package topinterviewquestions;

/**
 * @author Mark
 * @date 2022/3/24 20:59
 */
public class Problem_0136_SingleNumber {

    // 只出现一次的数字：https://leetcode.com/problems/single-number/
    public static int singleNumber(int[] nums) {
        int eor = 0;
        for (int num : nums) {
            eor ^= num;
        }
        return eor;
    }
}
