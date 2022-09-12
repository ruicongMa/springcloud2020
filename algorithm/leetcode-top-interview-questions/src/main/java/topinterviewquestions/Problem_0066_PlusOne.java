package topinterviewquestions;

/**
 * @author Mark
 * @date 2022/3/14 16:51
 */
public class Problem_0066_PlusOne {

    // 加一：https://leetcode.com/problems/plus-one/

    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] ans = new int[n + 1];
        ans[0] = 1;
        return ans;
    }
}
