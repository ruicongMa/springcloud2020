import java.util.Stack;

/**
 * @author Mark
 * @date 2021/8/26 15:36
 */
public class Code04_ReverseStackUsingRecursive {

    /**
     * 给你一个栈，请你逆序这个栈，
     * 不能申请额外的数据结构，
     * 只能使用递归函数。 如何实现?
     */

    public static int f(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = f(stack);
            stack.push(result);
            return last;
        }
    }

    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int result = f(stack);
        reverse(stack);
        stack.push(result);
    }

    public static void main(String[] args) {
        Stack<Integer> test = new Stack<Integer>();
        test.push(5);
        test.push(4);
        test.push(3);
        test.push(2);
        test.push(1);
        reverse(test);
        while (!test.isEmpty()) {
            System.out.println(test.pop());
        }
    }
}
