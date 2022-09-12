package topinterviewquestions;

/**
 * @author Mark
 * @date 2022/3/14 12:43
 */
public class Problem_0062_UniquePaths {

    // 不同路径：https://leetcode.com/problems/unique-paths/

    public static int uniquePaths(int m, int n) {
        int part = n - 1; // 两个方法只有这不同
        int all = m + n - 2;
        long o1 = 1;
        long o2 = 1;
        // all  C(9,3)  all = 9 part = 9 - 3 = 6
        // part + 1 ... = 7 ... 8 -> a
        // 1....
        for (int i = part + 1, j = 1; i <= all || j <= all - part; i++, j++) {
            o1 *= i;
            o2 *= j;
            long gcd = gcd(o1, o2);
            o1 /= gcd;
            o2 /= gcd;
        }
        return (int) o1;
    }

    public static int uniquePaths2(int m, int n) {
        int part = m - 1; // 两个方法只有这不同
        int all = m + n - 2;
        long o1 = 1;
        long o2 = 1;
        // all  C(9,3)  all = 9 part = 9 - 3 = 6
        // part + 1 ... = 7 ... 8 -> a
        // 1....
        for (int i = part + 1, j = 1; i <= all || j <= all - part; i++, j++) {
            o1 *= i;
            o2 *= j;
            long gcd = gcd(o1, o2);
            o1 /= gcd;
            o2 /= gcd;
        }
        return (int) o1;
    }

    // 调用的时候，请保证初次调用时，m和n都不为0
    // 求最大公约数
    public static long gcd(long m, long n) {
        return n == 0 ? m : gcd(n, m % n);
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
        System.out.println(uniquePaths(7, 3));
        System.out.println(uniquePaths2(3, 7));
        System.out.println(uniquePaths2(7, 3));

    }
}
