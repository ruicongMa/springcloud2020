package topinterviewquestions;

/**
 * @author Mark
 * @date 2022/3/31 12:24
 */
public class Problem_0344_ReverseString {

    // 反转字符串：https://leetcode.com/problems/reverse-string/
    public void reverseString(char[] s) {
        int L = 0;
        int R = s.length - 1;
        while (L < R) {
            char tmp = s[L];
            s[L++] = s[R];
            s[R--] = tmp;
        }
    }
}
