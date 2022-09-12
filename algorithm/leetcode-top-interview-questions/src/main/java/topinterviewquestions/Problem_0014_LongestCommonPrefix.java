package topinterviewquestions;

/**
 * @author Mark
 * @date 2022/3/9 21:41
 */
public class Problem_0014_LongestCommonPrefix {

    // 最长公共前缀：https://leetcode.com/problems/longest-common-prefix/
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        char[] chs = strs[0].toCharArray();
        int min = Integer.MAX_VALUE;
        for (String str : strs) {
            char[] tmp = str.toCharArray();
            int index = 0;
            while (index < tmp.length && index < chs.length) {
                if (chs[index] != tmp[index]) {
                    break;
                }
                index++;
            }
            min = Math.min(index, min);
            if (min == 0) {
                return "";
            }
        }
        return strs[0].substring(0, min);
    }
}
