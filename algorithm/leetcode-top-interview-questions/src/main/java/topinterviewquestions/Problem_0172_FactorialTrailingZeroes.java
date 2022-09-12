package topinterviewquestions;

/**
 * @author Mark
 * @date 2022/3/26 22:02
 */
public class Problem_0172_FactorialTrailingZeroes {

    // 阶乘后的零：https://leetcode.com/problems/factorial-trailing-zeroes/
    public static int trailingZeroes(int n) {
        int ans = 0;
        while (n != 0) {
            n /= 5;
            ans += n;
        }
        return ans;
    }
}
