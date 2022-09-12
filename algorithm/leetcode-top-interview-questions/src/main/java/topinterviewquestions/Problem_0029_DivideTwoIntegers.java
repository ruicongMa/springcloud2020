package topinterviewquestions;

/**
 * @author Mark
 * @date 2022/3/10 17:51
 */
public class Problem_0029_DivideTwoIntegers {

    // 两数相除：https://leetcode.com/problems/divide-two-integers/
    public static int add(int a, int b) {
        int sum = a;
        while (b != 0) {
            sum = a ^ b; // 无进位相加
            b = (a & b) << 1; // 进位信息
            a = sum;
        }
        return sum;
    }

    public static int negNum(int n) {
        return add(~n, 1);
    }

    public static int minus(int a, int b) {
        return add(a, negNum(b));
    }

    public static int multi(int a, int b) {
        int res = 0;
        while (b != 0) {
            if ((b & 1) != 0) { // b二进制 最右不是1，则加进去 res + a
                res = add(res, a);
            }
            a <<= 1; // 有符号左移，高位用符号位补
            b >>>= 1; // 无符号右移，高位统一用0补
        }
        return res;
    }

    public static boolean isNeg(int n) {
        return n < 0;
    }

    public static int div(int a, int b) {
        int x = isNeg(a) ? negNum(a) : a; // 负数统一转为正数运算
        int y = isNeg(b) ? negNum(b) : b; // 负数统一转为正数运算
        int res = 0;
        for (int i = 31; i > negNum(1); i = minus(i, 1)) {
            if ((x >> i) >= y) {
                res |= (1 << i);
                x = minus(x, y << i);
            }
        }
        // 异或的特点：相同为假，不同为真
        return isNeg(a) ^ isNeg(b) ? negNum(res) : res;
    }

    public static int divide(int dividend, int divisor) {
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }
        // 除数不是系统最小
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == negNum(1)) {
                return Integer.MAX_VALUE;
            }
            int res = div(add(dividend, 1), divisor);
            return add(res, div(minus(dividend, multi(res, divisor)), divisor));
        }
        // dividend不是系统最小，divisor也不是系统最小
        return div(dividend, divisor);
    }

    // 打印一个数的二进制
    public static String printNumBinary(int num) {
        StringBuilder builder = new StringBuilder();
        for (int i = 31; i >= 0; i--) {
            builder.append(((num >> i) & 1) == 0 ? '0' : '1');
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(printNumBinary(-1));
        System.out.println(printNumBinary(-2));
        System.out.println(printNumBinary(Integer.MAX_VALUE));
        System.out.println(printNumBinary(Integer.MIN_VALUE));
    }
}
