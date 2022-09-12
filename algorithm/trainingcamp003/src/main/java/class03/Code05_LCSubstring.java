package class03;

/**
 * @author Mark
 * @date 2022/4/9 12:29
 */
public class Code05_LCSubstring {

    // 最长公共子串

    /**
     * 请注意区分子串和子序列的不同，给定两个字符串str1和str2，求两个字符串的最长公共子串
     */
    public static String lcst1(String str1, String str2) {
        if (str1 == null || str2 == null || str1.equals("") || str2.equals("")) {
            return "";
        }
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        int[][] dp = getdp(chs1, chs2);
        int end = 0; // 记录最大公共子串长度时的位置
        int max = 0; // 记录最大公共子串长度
        for (int i = 0; i < chs1.length; i++) {
            for (int j = 0; j < chs2.length; j++) {
                if (dp[i][j] > max) {
                    end = i;
                    max = dp[i][j];
                }
            }
        }
        return str1.substring(end - max + 1, end + 1);
    }

    public static int[][] getdp(char[] str1, char[] str2) {
        int N = str1.length;
        int M = str2.length;
        int[][] dp = new int[N][M];
        for (int i = 0; i < N; i++) {
            if (str1[i] == str2[0]) { // 第一列格子
                dp[i][0] = 1;
            }
        }
        for (int j = 1; j < M; j++) {
            if (str1[0] == str2[j]) { // 第一行格子
                dp[0][j] = 1;
            }
        }
        // 剩下格子
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                if (str1[i] == str2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
            }
        }
        return dp;
    }

    public static String lcst2(String s1, String s2) {
        if (s1 == null || s2 == null || s1.equals("") || s2.equals("")) {
            return "";
        }
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        int row = 0; // 出发点的行号
        int col = str2.length - 1; // 出发点的列号
        int max = 0; // 记录最大公共子串长度
        int end = 0; // 记录最大公共子串长度时的位置
        while (row < str1.length) {
            // 每个开始位置的格子坐标为(i,j)
            int i = row;
            int j = col;
            int len = 0;
            // 向右下方移动的这一轮
            while (i < str1.length && j < str2.length) {
                if (str1[i] != str2[j]) {
                    len = 0;
                } else {
                    len++;
                }
                // len
                if (len > max) {
                    end = i;
                    max = len;
                }
                // i++，j++，就是斜着填格子
                i++;
                j++;
            }
            if (col > 0) { // 第一行的出发点从最右边的格子依次往左这么走
                col--;
            } else { // col==0时，下一行
                row++;
            }
        }
        // s1或s2中截取都行，最大公共子串长度max知道，位置也知道，就可以截取
        return s1.substring(end - max + 1, end + 1);
    }

    public static void main(String[] args) {
        String str1 = "ABC1234567DEFG";
        String str2 = "HIJKL1234567MNOP";
        System.out.println(lcst1(str1, str2));
        System.out.println(lcst2(str1, str2));

    }
}
