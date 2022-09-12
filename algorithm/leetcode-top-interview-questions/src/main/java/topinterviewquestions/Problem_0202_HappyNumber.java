package topinterviewquestions;

import java.util.HashSet;

/**
 * @author Mark
 * @date 2022/3/27 11:38
 */
public class Problem_0202_HappyNumber {

    // 快乐数：https://leetcode.com/problems/happy-number/
    public static boolean isHappy1(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (n != 1) {
            int sum = 0;
            while (n != 0) {
                int r = n % 10; // 每位上的数
                sum += r * r;
                n /= 10; // 下一位上的数
            }
            n = sum;
            if (set.contains(n)) {
                break;
            }
            set.add(n);
        }
        return n == 1;
    }

    public static boolean isHappy2(int n) {
        while (n != 1 && n != 4) {
            int sum = 0;
            while (n != 0) {
                sum += (n % 10) * (n % 10);
                n /= 10;
            }
            n = sum;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        for (int i = 1; i < 1000; i++) {
            System.out.println(i + " : " + isHappy1(i));
        }
    }
}
