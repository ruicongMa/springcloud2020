package topinterviewquestions;

/**
 * @author Mark
 * @date 2022/3/9 15:51
 */
public class Problem_0011_ContainerWithMostWater {

    // 盛最多水的容器：https://leetcode.com/problems/container-with-most-water/

    public static int maxArea(int[] h) {
        int max = 0;
        int l = 0;
        int r = h.length - 1;
        while (l < r) {
            max = Math.max(max, Math.min(h[l], h[r]) * (r - l));
            if (h[l] > h[r]) {
                r--;
            } else {
                l++;
            }
        }
        return max;
    }
}
