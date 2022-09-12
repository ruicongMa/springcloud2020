package topinterviewquestions;

import java.util.Stack;

/**
 * @author Mark
 * @date 2022/3/25 23:32
 */
public class Problem_0150_EvaluateReversePolishNotation {

    // 逆波兰表达式求值：https://leetcode.com/problems/evaluate-reverse-polish-notation/
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String str : tokens) {
            if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
                compute(stack, str);
            } else {
                stack.push(Integer.valueOf(str));
            }
        }
        return stack.peek();
    }

    public static void compute(Stack<Integer> stack, String op) {
        int num2 = stack.pop();
        int num1 = stack.pop();
        int ans = 0;
        switch (op) {
            case "+":
                ans = num1 + num2;
                break;
            case "-":
                ans = num1 - num2;
                break;
            case "*":
                ans = num1 * num2;
                break;
            case "/":
                ans = num1 / num2;
                break;
        }
        stack.push(ans);
    }
}
