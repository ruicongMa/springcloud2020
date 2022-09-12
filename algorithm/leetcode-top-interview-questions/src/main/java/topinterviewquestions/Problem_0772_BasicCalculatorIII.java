package topinterviewquestions;

import java.util.LinkedList;

/**
 * @author Mark
 * @date 2022/3/28 16:13
 */
public class Problem_0772_BasicCalculatorIII {

    // 基本计算器 II：https://leetcode.com/problems/basic-calculator-ii/
    public static int calculate(String str) {
        return f(str.toCharArray(), 0)[0];
    }

    // 请从str[i...]往下算，遇到字符串终止位置或者右括号，就停止
    // 返回两个值，长度为2的数组
    // 0) 负责的这一段的结果是多少
    // 1) 负责的这一段计算到了哪个位置
    public static int[] f(char[] str, int i) {
        LinkedList<String> que = new LinkedList<String>();
        int cur = 0;
        int[] bra = null;
        // 从i出发，开始撸str
        while (i < str.length && str[i] != ')') {
            if (str[i] == ' ') {
                i++;
                continue;
            }
            if (str[i] >= '0' && str[i] <= '9') {
                cur = cur * 10 + str[i++] - '0';
            } else if (str[i] != '(') { // 遇到了运算符
                // que 接受的是str的东西，cur是一个整型
                addNum(que, cur); // 添加数
                que.addLast(String.valueOf(str[i++])); // 添加运算符
                cur = 0;
            } else { // 遇到i左括号了
                bra = f(str, i + 1); // 交给下一个函数算好返回
                cur = bra[0]; // 算好的结果
                i = bra[1] + 1; // 算到哪个位置了
            }
        }
        addNum(que, cur); // 别忘了最后一个数要加进去
        return new int[]{getNum(que), i};
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
