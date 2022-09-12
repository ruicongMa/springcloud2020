package class03;

import java.util.Stack;

/**
 * @author Mark
 * @date 2022/2/14 15:42
 */
public class Code05_GetMinStack {

    /**
     * 实现一个特殊的栈，在基本功能的基础上，再实现返回栈中最小元素的功能
     * <p>
     * - pop、push、getMin操作的时间复杂度都是 O(1)
     * - 设计的栈类型可以使用现成的栈结构
     */
    // 实现一个特殊的栈，在基本功能的基础上，在实现返回栈中的最小元素的功能
    public static class MyStack1 {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MyStack1() {
            this.stackData = new Stack<>();
            this.stackMin = new Stack<>();
        }

        // 添加
        public void push(int newNum) {
            if (stackMin.isEmpty()) {
                stackMin.push(newNum);
            } else if (newNum <= getMin()) {
                stackMin.push(newNum);
            }
            stackData.push(newNum);
        }

        // 弹出
        public int pop() {
            if (stackData.isEmpty()) {
                throw new RuntimeException("Your stack is Empty.");
            }
            int val = stackData.pop();
            if (val == getMin()) {
                stackMin.pop();
            }
            return val;
        }

        public int getMin() {
            if (stackMin.isEmpty()) {
                throw new RuntimeException("Your stack is Empty.");
            }
            return stackMin.peek();
        }
    }

    public static class MyStack2 {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MyStack2() {
            this.stackData = new Stack<>();
            this.stackMin = new Stack<>();
        }

        public void push(int newNum) {
            if (stackMin.isEmpty()) {
                stackMin.push(newNum);
            } else if (newNum < getMin()) {
                stackMin.push(newNum);
            } else {
                int val = getMin();
                stackMin.push(val);
            }
            stackData.push(newNum);
        }

        public int pop() {
            if (stackData.isEmpty()) {
                throw new RuntimeException("Your stack is Empty.");
            }
            stackMin.pop();
            return stackData.pop();
        }

        public int getMin() {
            if (stackMin.isEmpty()) {
                throw new RuntimeException("Your stack is Empty.");
            }
            return stackMin.peek();
        }
    }

    public static void main(String[] args) {
        MyStack1 stack1 = new MyStack1();
        stack1.push(3);
        System.out.println(stack1.getMin());
        stack1.push(4);
        System.out.println(stack1.getMin());
        stack1.push(1);
        System.out.println(stack1.getMin());
        System.out.println(stack1.pop());
        System.out.println(stack1.getMin());

        System.out.println("=============");

        MyStack1 stack2 = new MyStack1();
        stack2.push(3);
        System.out.println(stack2.getMin());
        stack2.push(4);
        System.out.println(stack2.getMin());
        stack2.push(1);
        System.out.println(stack2.getMin());
        System.out.println(stack2.pop());
        System.out.println(stack2.getMin());
    }

}
