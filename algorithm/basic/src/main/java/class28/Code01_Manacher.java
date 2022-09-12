package class28;

/**
 * @author Mark
 * @date 2022/3/1 12:59
 */
public class Code01_Manacher {

    // Manacher算法

    /**
     * 假设字符串str长度为N，想返回最长回文子串的长度
     * 时间复杂度O(N)
     */
    public static int manacher(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        // "12132" -> "#1#2#1#3#2#"
        char[] str = manacherString(s);
        // 回文半径的大小（起到加速的作用）
        int[] pArr = new int[str.length];
        int C = -1; // 中心点向左向右扩
        // 讲述中：R代表最右的扩成功的位置
        // coding：最右的扩成功位置的，再下一个位置
        int R = -1;
        int max = Integer.MIN_VALUE;
        // int end = 0;
        for (int i = 0; i < str.length; i++) { // 0 1 2
            // R第一个违规的位置，i>= R
            // i位置扩出来的答案，i位置扩的区域，至少是多大。
            // R > i 说明i在R范围内，否则i不在R范围内，则至少1个回文半径
            // 2*C-i就是i'的回文半径
            pArr[i] = R > i ? Math.min(pArr[2 * C - i], R - i) : 1;
            while (i + pArr[i] < str.length && i - pArr[i] > -1) {
                if (str[i + pArr[i]] == str[i - pArr[i]]) {
                    pArr[i]++;
                } else {
                    break;
                }
            }
            if (i + pArr[i] > R) { // 只要向右能扩动，则R更新，C更新
                // end = R - 1;
                R = i + pArr[i];
                C = i;
            }
            max = Math.max(max, pArr[i]);
        }
        // System.out.println(end);
        return max - 1; // 最大回文半径 - 1 就是原始字符串最长的回文子串长度
    }

    // 对原字符串做处理，使得即支持奇数长度字符串的回文，又支持偶数长度字符串的回文
    private static char[] manacherString(String str) {
        char[] charArr = str.toCharArray();
        char[] res = new char[str.length() * 2 + 1];
        int index = 0;
        for (int i = 0; i != res.length; i++) {
            // i&1==0，为偶数，否则为奇数
            res[i] = (i & 1) == 0 ? '#' : charArr[index++];
        }
        return res;
    }

    // for test 暴力解，时间复杂度O(N²)
    public static int right(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] str = manacherString(s);
        int max = 0;
        for (int i = 0; i < str.length; i++) {
            int L = i - 1;
            int R = i + 1;
            while (L >= 0 && R < str.length && str[L] == str[R]) {
                L--;
                R++;
            }
            max = Math.max(max, R - L - 1);
        }
        return max / 2;
    }

    // for test
    public static String getRandomString(int possibilities, int size) {
        char[] ans = new char[(int) (Math.random() * size) + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = (char) ((int) (Math.random() * possibilities) + 'a');
        }
        return String.valueOf(ans);
    }

    public static void main(String[] args) {
        System.out.println(manacher("aa12321"));
        // int possibilities = 5;
        // int strSize = 20;
        // int testTimes = 5000000;
        // System.out.println("test begin");
        // for (int i = 0; i < testTimes; i++) {
        //     String str = getRandomString(possibilities, strSize);
        //     if (manacher(str) != right(str)) {
        //         System.out.println("Oops!");
        //     }
        // }
        // System.out.println("test finish");
    }
}
