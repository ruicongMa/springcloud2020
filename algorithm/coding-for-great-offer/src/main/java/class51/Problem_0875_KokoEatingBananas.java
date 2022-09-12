package class51;

/**
 * @author Mark
 * @date 2022/4/22 15:41
 */
public class Problem_0875_KokoEatingBananas {

    // 爱吃香蕉的珂珂：https://leetcode-cn.com/problems/koko-eating-bananas/
    public static int minEatingSpeed(int[] piles, int h) {
        int L = 1;
        int R = 0;
        // 找出每堆中的最大香蕉数
        for (int pile : piles) {
            R = Math.max(R, pile);
        }
        int ans = 0;
        int M = 0;
        while (L <= R) {
            M = L + ((R - L) >> 1);
            if (hours(piles, M) <= h) {
                ans = M;
                R = M - 1;
            } else {
                L = M + 1;
            }
        }
        return ans;
    }

    // 以speed的速度吃完所有香蕉，需要几个小时
    // 时间向上取整
    public static int hours(int[] piles, int speed) {
        int ans = 0;
        int offset = speed - 1;
        for (int pile : piles) {
            ans += (pile + offset) / speed;
        }
        return ans;
    }
}
