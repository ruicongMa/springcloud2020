package topinterviewquestions;

/**
 * @author Mark
 * @date 2022/3/27 9:56
 */
public class Problem_0191_NumberOf1Bits {

    // 位1的个数：https://leetcode-cn.com/problems/number-of-1-bits/
    public static int hammingWeight1(int n) {
        int bits = 0;
        int rightOne = 0;
        while (n != 0) {
            bits++;
            rightOne = n & (-n); // 提取最右侧的1
            n ^= rightOne;
        }
        return bits;
    }

    public static int hammingWeight2(int n) {
        n = (n & 0x55555555) + ((n >>> 1) & 0x55555555);
        n = (n & 0x33333333) + ((n >>> 2) & 0x33333333);
        n = (n & 0x0f0f0f0f) + ((n >>> 4) & 0x0f0f0f0f);
        n = (n & 0x00ff00ff) + ((n >>> 8) & 0x00ff00ff);
        n = (n & 0x0000ffff) + ((n >>> 16) & 0x0000ffff);
        return n;
    }
}
