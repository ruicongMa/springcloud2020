package topinterviewquestions;

/**
 * @author Mark
 * @date 2022/4/1 8:20
 */
public class Problem_0387_FirstUniqueCharacterInString {

    // 字符串中的第一个唯一字符：https://leetcode.com/problems/first-unique-character-in-a-string/
    public int firstUniqChar(String s) {
        char[] str = s.toCharArray();
        int N = str.length;
        int count[] = new int[26];
        for (int i = 0; i < N; i++) {
            count[str[i] - 'a']++;
        }
        for (int i = 0; i < N; i++) {
            if (count[str[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
