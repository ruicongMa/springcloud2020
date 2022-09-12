package topinterviewquestions;

/**
 * @author Mark
 * @date 2022/3/9 12:37
 */
public class Problem_0007_ReverseInteger {

    // 整数反转：https://leetcode.com/problem-list/top-interview-questions/

    public static int reverse(int x) {
        // 无符号右移，把最高位（符号位）向右移动31位
        // 如果最高位符号位为1，则为负数，如果最高位符号位为0，则正数
        boolean neg = ((x >>> 31) & 1) == 1;
        x = neg ? x : -x;
        int m = Integer.MIN_VALUE / 10;
        int o = Integer.MIN_VALUE % 10;
        int res = 0;
        while (x != 0) {
            // 溢出判断
            if (res < m || (res == m && x % 10 < o)) {
                return 0;
            }
            res = res * 10 + x % 10;
            x /= 10;
        }
        return neg ? res : Math.abs(res);
    }

    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE); // -2147483648
        System.out.println(Integer.MAX_VALUE); // 2147483647
        System.out.println('0' - '0');
        System.out.println('0' - '1');
    }
}
