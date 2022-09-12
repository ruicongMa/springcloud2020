package class01;

/**
 * @author Mark
 * @date 2022/4/6 21:18
 */
public class Code04_ColorLeftRight {

    // 涂染最少正方形

    /**
     * 有一些排成一行的正方形。每个正方形已经被染成红色或者绿色。
     * 现在可以选择任意一个正方形然后用这两种颜色的任意一种进行染色,这个正方形的颜色将 会被覆盖。
     * 目标是在完成染色之后,每个红色R都比每个绿色G距离最左侧近。 返回最少需要涂染几个正方形。
     * 如样例所示: s = RGRGR 我们涂染之后变成RRRGG满足要求了,涂染的个数为2,没有比这个更好的涂染方案。
     */

    // RGRGR -> RRRGG
    // 时间复杂度O(N) 空间复杂度O(N)
    public static int minPaint(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        char[] str = s.toCharArray();
        int N = str.length;
        int[] right = new int[N];
        right[N - 1] = str[N - 1] == 'R' ? 1 : 0;
        for (int i = N - 2; i >= 0; i--) {
            right[i] = right[i + 1] + (str[i] == 'R' ? 1 : 0);
        }
        int ans = right[0]; // 如果数组所有的范围，都是右侧范围，都变成G
        int left = 0;
        for (int i = 0; i < N - 1; i++) { // 0..i 左侧 n-1..N-1
            left += str[i] == 'G' ? 1 : 0;
            ans = Math.min(ans, left + right[i + 1]);
        }
        // 0...N-1 左全部 右无
        ans = Math.min(ans, left + (str[N - 1] == 'G' ? 1 : 0));
        return ans;
    }

    // 最优解：时间复杂度O(N) 空间复杂度O(1)
    public static int minPaint2(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        char[] str = s.toCharArray();
        int N = str.length;
        int rAll = 0;
        for (int i = 0; i < N; i++) {
            rAll += str[i] == 'R' ? 1 : 0;
        }
        int ans = rAll; // 如果数组所有的范围，都是右侧范围，都变成G
        int left = 0;
        for (int i = 0; i < N - 1; i++) { // 0..i 左侧 n-1..N-1
            left += str[i] == 'G' ? 1 : 0;
            rAll -= str[i] == 'R' ? 1 : 0;
            ans = Math.min(ans, left + rAll);
        }
        // 0...N-1 左全部 右无
        ans = Math.min(ans, left + (str[N - 1] == 'G' ? 1 : 0));
        return ans;
    }

    public static void main(String[] args) {
        String test = "RGRRR";
        System.out.println(minPaint(test));
        // System.out.println(minPaint2(test));
    }
}
