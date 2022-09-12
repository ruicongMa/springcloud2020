package topinterviewquestions;

import java.util.LinkedList;

/**
 * @author Mark
 * @date 2022/3/28 16:31
 */
public class Problem_0227_BasicCalculatorII {

    // 基本计算器 II：https://leetcode.com/problems/basic-calculator-ii/
    public static int calculate(String s) {
        char[] str = s.toCharArray();
        int cur = 0;
        LinkedList<String> que = new LinkedList<>();
        for (int i = 0; i < str.length; i++) {
            if (str[i] == ' ') {
                continue;
            }
            if (str[i] >= '0' && str[i] <= '9') {
                cur = cur * 10 + str[i] - '0';
            } else { // 遇到运算符
                addNum(que, cur); // 添加数
                que.addLast(String.valueOf(str[i])); // 添加运算符
                cur = 0;
            }
        }
        addNum(que, cur); // 别忘了最后一个数要加进去
        return getNum(que);
    }

    // 添加数，如果栈顶遇到乘或除，需要弹栈算好，在压栈
    public static void addNum(LinkedList<String> que, int num) {
        if (!que.isEmpty()) {
            int cur = 0;
            String top = que.pollLast();
            if (top.equals("+") || top.equals("-")) {
                que.addLast(top);
            } else {
                cur = Integer.valueOf(que.pollLast());
                num = top.equals("*") ? (cur * num) : (cur / num);
            }
        }
        que.addLast(String.valueOf(num));
    }

    // 剩下的就是加减操作
    public static int getNum(LinkedList<String> que) {
        int res = 0;
        boolean add = true;
        String cur = null;
        int num = 0;
        while (!que.isEmpty()) {
            cur = que.pollFirst();
            if (cur.equals("+")) {
                add = true;
            } else if (cur.equals("-")) {
                add = false;
            } else {
                num = Integer.valueOf(cur);
                res += add ? num : (-num);
            }
        }
        return res;
    }
}
