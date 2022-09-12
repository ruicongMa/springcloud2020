package topinterviewquestions;

import java.util.Stack;

/**
 * @author Mark
 * @date 2022/3/26 14:09
 */
public class Problem_0155_MinStack {

    /*
     * 在leetcode上提交时，把文字替换成下面的代码
     * 然后把类名、构造方法名从Problem_0155_MinStack改为MinStack即可
     */
    // 最小栈：https://leetcode.com/problems/min-stack/
    private Stack<Integer> data;
    private Stack<Integer> min;

    public Problem_0155_MinStack() {
        data = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        data.push(x);
        if (min.isEmpty()) {
            min.push(x);
        } else {
            min.push(Math.min(min.peek(), x));
        }
    }

    public void pop() {
        data.pop();
        min.pop();
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
