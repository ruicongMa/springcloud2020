/**
 * @author Mark
 * @date 2021/9/15 21:47
 */
public class Code06_AOE {

    /**
     * 给定两个非负数组x和hp，长度都是N，再给定一个正数range
     * x有序，x[i]表示i号怪兽在x轴上的位置；hp[i]表示i号怪兽的血量
     * 再给定一个正数range，表示如果法师释放技能的范围长度
     * 被打到的每只怪兽损失1点血量。
     * 返回要把所有怪兽血量清空，至少需要释放多少次AOE技能？
     */

    /**
     * 纯暴力
     */
    public static int minAoe1(int[] x, int[] hp, int range) {
        int N = x.length;
        int[] leftCover = new int[N];
        int[] rightCover = new int[N];
        int left = 0;
        int right = 0;
        for (int i = 0; i < N; i++) {

        }
        return 0;
    }

    /**
     * 贪心 + 线段树
     */
}
