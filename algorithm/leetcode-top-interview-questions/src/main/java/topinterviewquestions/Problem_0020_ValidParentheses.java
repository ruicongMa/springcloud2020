package topinterviewquestions;

import java.util.Stack;

/**
 * @author Mark
 * @date 2022/3/10 14:25
 */
public class Problem_0020_ValidParentheses {

    // 有效的括号：https://leetcode.com/problems/valid-parentheses/

    public static boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        char[] str = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length; i++) {
            char cha = str[i];
            if (cha == '(' || cha == '[' || cha == '{') {
                stack.add(cha == '(' ? ')' : (cha == '[' ? ']' : '}'));
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char last = stack.pop();
                if (cha != last) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static boolean isValid2(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        char[] str = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length; i++) {
            char cha = str[i];
            if (cha == '(' || cha == '[' || cha == '{') {
                stack.add(cha);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char last = stack.pop();
                if ((cha == ')' && last != '(') || (cha == ']' && last != '[') || (cha == '}' && last != '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
