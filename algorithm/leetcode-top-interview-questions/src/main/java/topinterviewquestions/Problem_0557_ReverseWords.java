package topinterviewquestions;

import java.util.Stack;

/**
 * @author Mark
 * @date 2022/9/20 上午10:23
 */
public class Problem_0557_ReverseWords {

    // 反转字符串中的单词 III
    // https://leetcode.cn/problems/reverse-words-in-a-string-iii/
    public static void main(String[] args) {
        String str = "Let's take LeetCode contest";
        System.out.println(reverseWords(str));
    }

    // 给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。

    /**
     * 输入：s = "Let's take LeetCode contest"
     * 输出："s'teL ekat edoCteeL tsetnoc"
     */
    public static String reverseWords(String str) {
        if (str == null || str.trim().length() == 0) {
            return str;
        }
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c != ' ') {
                stack.push(c);
            } else {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(c);
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
