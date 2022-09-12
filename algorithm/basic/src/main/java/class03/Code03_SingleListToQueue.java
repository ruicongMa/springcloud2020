package class03;

/**
 * @author Mark
 * @date 2022/2/14 12:30
 */
public class Code03_SingleListToQueue {

    // 单项链表实现队列 尾部添加、头部取出，即满足先进先出
    public static class Node<T> {
        T val;
        Node<T> next;

        public Node(T val) {
            this.val = val;
        }
    }

    public static class MyQueue<T> {
        Node<T> head;
        Node<T> tail;
        int size; // 可有可无，取决于是否需要提供队列大小的功能

        public boolean isEmpty() {
            return size == 0;
        }

        public void offer(T data) {
            Node cur = new Node(data);
            if (tail == null) {
                head = tail = cur;
            } else {
                tail.next = cur;
                tail = cur;
            }
            size++;
        }

        public T poll() {
            T ans = null;
            if (head != null) {
                ans = head.val;
                head = head.next;
                size--;
            } else {
                tail = null;
            }
            return ans;
        }

        public T peek() {
            if (head == null) {
                return null;
            }
            return head.val;
        }

    }
}