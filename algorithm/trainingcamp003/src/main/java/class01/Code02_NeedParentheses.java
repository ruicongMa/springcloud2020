package class01;

/**
 * @author Mark
 * @date 2022/4/6 11:40
 */
public class Code02_NeedParentheses {

    // 有效括号配对问题I

    /**
     * 括号有效配对是指：
     * 1）任何一个左括号都能找到和其正确配对的右括号
     * 2）任何一个右括号都能找到和其正确配对的左括号
     * 有效的：    (())  ()()   (()())  等
     * 无效的：     (()   )(     等
     * 问题一：怎么判断一个括号字符串有效？
     * 问题二：如果一个括号字符串无效，返回至少填几个字符能让其整体有效
     */
    public static boolean valid(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        char[] str = s.toCharArray();
        int count = 0;
        for (int i = 0; i < str.length; i++) {
            count += str[i] == '(' ? 1 : -1;
            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }

    public static int needParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] str = s.toCharArray();
        int count = 0;
        int need = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == '(') {
                count++;
            } else { // 遇到的是')'
                if (count == 0) {
                    need++;
                } else {
                    count--;
                }
            }
        }
        return count + need;
    }
}
