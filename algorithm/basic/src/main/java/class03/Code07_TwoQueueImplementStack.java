package class03;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Mark
 * @date 2022/2/14 16:23
 */
public class Code07_TwoQueueImplementStack {

    // 如何用队列结构实现栈结构
    public static class MyStack<T> {
        private Queue<T> queue;
        private Queue<T> help;

        public MyStack() {
            this.queue = new LinkedList<>();
            this.help = new LinkedList<>();
        }

        // 入栈
        public void push(T val) {
            queue.offer(val);
        }

        // 出栈
        public T pop() {
            while (queue.size() > 1) { // 剩一个数
                help.offer(queue.poll());
            }
            T ans = queue.poll();
            Queue<T> tmp = queue;
            queue = help;
            help = tmp;
            return ans;
        }

        public T peek() {
            while (queue.size() > 1) {
                help.offer(queue.poll());
            }
            T ans = queue.poll();
            help.offer(ans); // 拿出来再放回去
            Queue<T> tmp = queue;
            queue = help;
            help = tmp;
            return ans;
        }

        private boolean isEmpty() {
            return queue.isEmpty();
        }
    }

    public static void main(String[] args) {
        System.out.println("test begin");
        MyStack<Integer> myStack = new MyStack<>();
        Stack<Integer> test = new Stack<>();
        int testTime = 1000000;
        int max = 1000000;
        for (int i = 0; i < testTime; i++) {
            if (myStack.isEmpty()) {
                if (!test.isEmpty()) {
                    System.out.println("Oops");
                }
                int num = (int) (Math.random() * max);
                myStack.push(num);
                test.push(num);
            } else {
                if (Math.random() < 0.25) {
                    int num = (int) (Math.random() * max);
                    myStack.push(num);
                    test.push(num);
                } else if (Math.random() < 0.5) {
                    if (!myStack.peek().equals(test.peek())) {
                        System.out.println("Oops");
                    }
                } else if (Math.random() < 0.75) {
                    if (!myStack.pop().equals(test.pop())) {
                        System.out.println("Oops");
                    }
                } else {
                    if (myStack.isEmpty() != test.isEmpty()) {
                        System.out.println("Oops");
                    }
                }
            }
        }

        System.out.println("test finish!");

    }
}
