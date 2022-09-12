package topinterviewquestions;

/**
 * @author Mark
 * @date 2022/4/1 0:01
 */
public class Problem_0371_SumOfTwoIntegers {

    // 两整数之和：https://leetcode.com/problems/sum-of-two-integers/
    public int getSum(int a, int b) {
        int sum = a;
        while (b != 0) { // 进位信息为0时停止
            sum = a ^ b; // 无进位相加
            b = (a & b) << 1; // 进位信息
            a = sum;
        }
        return sum;
    }
}
