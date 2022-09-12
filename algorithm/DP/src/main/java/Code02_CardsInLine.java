/**
 * @author Mark
 * @date 2021/8/27 10:19
 */
public class Code02_CardsInLine {

    /**
     * 给定一个整型数组arr，代表数值不同的纸牌排成一条线
     * 玩家A和玩家B依次拿走每张纸牌
     * 规定玩家A先拿，玩家B后拿
     * 但是每个玩家每次只能拿走最左或最右的纸牌
     * 玩家A和玩家B都绝顶聪明
     * 请返回最后获胜者的分数。
     */

    public static int win1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int first = f1(arr, 0, arr.length - 1);
        int second = g1(arr, 0, arr.length - 1);
        return Math.max(first, second);
    }

    // arr[L...R]，先手获得的最好分数返回
    private static int f1(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }
        int p1 = arr[L] + g1(arr, L + 1, R);
        int p2 = arr[R] + g1(arr, L, R - 1);
        return Math.max(p1, p2);
    }

    // arr[L...R]，后手获得的最好分数返回
    private static int g1(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }
        // 对手拿走了L位置的数，后手只能从arr[L + 1, R]上选
        int p1 = f1(arr, L + 1, R);
        // 对手拿走了R位置的数，后手只能从arr[L, R - 1]上选
        int p2 = f1(arr, L, R - 1);
        return Math.min(p1, p2);
    }

    public static int win2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int N = arr.length;
        int[][] fdp = new int[N][N];
        int[][] gdp = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                fdp[i][j] = -1;
                gdp[i][j] = -1;
            }
        }
        int first = f2(arr, 0, arr.length - 1, fdp, gdp);
        int second = g2(arr, 0, arr.length - 1, fdp, gdp);
        return Math.max(first, second);
    }

    // arr[L...R]，先手获得的最好分数返回
    private static int f2(int[] arr, int L, int R, int[][] fdp, int[][] gdp) {
        if (fdp[L][R] != -1) {
            return fdp[L][R];
        }
        int ans = 0;
        if (L == R) {
            ans = arr[L];
        } else {
            int p1 = arr[L] + g2(arr, L + 1, R, fdp, gdp);
            int p2 = arr[R] + g2(arr, L, R - 1, fdp, gdp);
            ans = Math.max(p1, p2);
        }
        fdp[L][R] = ans;
        return ans;
    }

    // arr[L...R]，后手获得的最好分数返回
    private static int g2(int[] arr, int L, int R, int[][] fdp, int[][] gdp) {
        if (gdp[L][R] != -1) {
            return gdp[L][R];
        }
        int ans = 0;
        if (L != R) {
            // 对手拿走了L位置的数，后手只能从arr[L + 1, R]上选
            int p1 = f2(arr, L + 1, R, fdp, gdp);
            // 对手拿走了R位置的数，后手只能从arr[L, R - 1]上选
            int p2 = f2(arr, L, R - 1, fdp, gdp);
            ans = Math.min(p1, p2);
        }
        gdp[L][R] = ans;
        return ans;
    }

    public static int win3(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int N = arr.length;
        int[][] fdp = new int[N][N];
        int[][] gdp = new int[N][N];
        for (int i = 0; i < N; i++) {
            fdp[i][i] = arr[i];
        }
        for (int startCol = 1; startCol < N; startCol++) {
            int L = 0;
            int R = startCol;
            while (R < N) {
                fdp[L][R] = Math.max(arr[L] + gdp[L + 1][R], arr[R] + gdp[L][R - 1]);
                gdp[L][R] = Math.min(fdp[L + 1][R], fdp[L][R - 1]);
                L++;
                R++;
            }
        }
        return Math.max(fdp[0][N - 1], gdp[0][N - 1]);
    }

    public static void main(String[] args) {
        int[] arr = {5, 7, 4, 5, 8, 1, 6, 0, 3, 4, 6, 1, 7};
        System.out.println(win1(arr));
        System.out.println(win2(arr));
        System.out.println(win3(arr));
    }
}
