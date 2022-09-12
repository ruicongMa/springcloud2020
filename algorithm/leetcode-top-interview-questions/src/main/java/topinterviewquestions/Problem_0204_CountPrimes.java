package topinterviewquestions;

/**
 * @author Mark
 * @date 2022/3/27 11:58
 */
public class Problem_0204_CountPrimes {

    // 计数质数：https://leetcode.com/problems/count-primes/
    public static int countPrimes(int n) {
        if (n < 3) {
            return 0;
        }
        // f[i] == true 代表i不是质数
        // f[i] == false 代表i是质数
        boolean[] f = new boolean[n];
        int count = n / 2; // 砍掉一半偶数，在剩下的奇数里砍掉不是质数的数
        for (int i = 3; i * i < n; i += 2) { // 3 5 7 9...
            if (f[i]) { // 不是质数直接过滤
                continue;
            }
            for (int j = i * i; j < n; j += 2 * i) { // i*i i*i+2*i
                if (!f[j]) { // 是质数，画×
                    --count;
                    f[j] = true;
                }
            }
        }
        return count;
    }

    // 超时
    public static int countPrimes2(int n) {
        int num = 0;
        boolean sign;
        for (int i = 2; i < n; i++) {
            if (i % 2 == 0 && i != 2) continue; //偶数和1排除
            sign = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    sign = false;
                    break;
                }
            }
            if (sign) {
                num++;
                // System.out.print(i + " ");
            }
        }
        // System.out.println();
        return num;
    }

    public static int countPrimes3(int n) {
        int num = 0;
        boolean sign;
        for (int i = 2; i < n; i++) {
            if (i % 2 == 0 && i != 2) continue; //偶数和1排除
            sign = true;
            for (int j = 2; j < i / 2; j++) {
                if (i % j == 0) {
                    sign = false;
                    break;
                }
            }
            if (sign) {
                num++;
                // System.out.print(i + " ");
            }
        }
        // System.out.println();
        return num;
    }

    public static void main(String[] args) {
        int num = countPrimes2(100);
        System.out.println(num);
        num = countPrimes(100);
        System.out.println(num);
    }
}
