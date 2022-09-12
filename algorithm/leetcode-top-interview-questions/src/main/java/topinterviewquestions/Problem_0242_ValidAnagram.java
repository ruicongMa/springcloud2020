package topinterviewquestions;

/**
 * @author Mark
 * @date 2022/3/28 22:18
 */
public class Problem_0242_ValidAnagram {

    // 有效的字母异位词：https://leetcode.com/problems/valid-anagram/
    public static boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        char[] str = s.toCharArray();
        char[] tar = t.toCharArray();
        int[] count = new int[256];
        for (char cha : str) {
            count[cha]++;
        }
        for (char cha : tar) {
            if (--count[cha] < 0) {
                return false;
            }
        }
        return true;
    }
}
