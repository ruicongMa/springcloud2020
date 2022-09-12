package class28;

/**
 * @author Mark
 * @date 2022/3/1 16:57
 */
public class Code02_AddShortestEnd {

    /**
     * 在一个字符串中，只能从后边添加字符，想让它整体是回文串，至少需要添加几个字符？
     * 其实质是必须包含最后一个字符的情况下，最长回文子串是多长？
     * 前边不是的部分逆序过来就是要添的
     */
    public static String shortestEnd(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        char[] str = manacherString(s);
        int[] pArr = new int[str.length];
        int C = -1;
        int R = -1;
        int maxContainsEnd = -1;
        for (int i = 0; i != str.length; i++) {
            pArr[i] = R > i ? Math.min(pArr[2 * C - i], R - i) : 1;
            while (i + pArr[i] < str.length && i - pArr[i] > -1) {
                if (str[i + pArr[i]] == str[i - pArr[i]])
                    pArr[i]++;
                else {
                    break;
                }
            }
            if (i + pArr[i] > R) {
                R = i + pArr[i];
                C = i;
            }
            if (R == str.length) {
                maxContainsEnd = pArr[i];
                break;
            }
        }
        // maxContainsEnd - 1 必须以字符串结尾的原始字符串最长回文字串
        // 原始字符串的长度 - (maxContainsEnd - 1) = s.length - maxContainsEnd + 1 就是需要添的字符长度
        char[] res = new char[s.length() - maxContainsEnd + 1];
        for (int i = 0; i < res.length; i++) {
            res[res.length - 1 - i] = str[i * 2 + 1];
        }
        return String.valueOf(res);
    }

    public static char[] manacherString(String str) {
        char[] charArr = str.toCharArray();
        char[] res = new char[str.length() * 2 + 1];
        int index = 0;
        for (int i = 0; i != res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : charArr[index++];
        }
        return res;
    }

    public static void main(String[] args) {
        String str1 = "abcd123321";
        System.out.println(shortestEnd(str1));
    }
}
