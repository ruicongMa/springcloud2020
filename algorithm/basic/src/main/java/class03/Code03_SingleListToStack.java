package class03;

/**
 * @author Mark
 * @date 2022/2/14 15:02
 */
public class Code03_SingleListToStack {

    // 单向链表实现栈，先进后出，后进先出，头部添加、头部移除即可实现栈
    public static class Node<T> {
        T val;
        Node<T> next;

        public Node(T val) {
            this.val = val;
        }
    }

    public static class MyStack<T> {
        Node<T> head;
        int size;

        public boolean isEmpty() {
            return size == 0;
        }

        // 入栈
        public void push(T data) {
            Node cur = new Node(data);
            if (head != null) {
                cur.next = head;
            }
            head = cur;
            size++;
        }

        // 出栈
        public T pop() {
            T ans = null;
            if (head != null) {
                ans = head.val;
                head = head.next;
                size--;
            }
            return ans;
        }
    }

}
