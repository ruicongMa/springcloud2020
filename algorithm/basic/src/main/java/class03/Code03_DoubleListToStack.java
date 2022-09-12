package class03;

/**
 * @author Mark
 * @date 2022/2/14 15:04
 */
public class Code03_DoubleListToStack {

    /**
     * 栈：先进后出或者后进先出。
     * <p>
     * 双端队列实现栈：尾部添加、尾部取出。或者头部添加、头部取出都满足栈特性。
     */
    public static class DoubleNode<T> {
        T val;
        DoubleNode<T> pre;
        DoubleNode<T> next;

        public DoubleNode(T data) {
            this.val = data;
        }
    }

    // 栈
    public static class MyStack<T> {
        MyDeque<T> deque;

        public MyStack() {
            this.deque = new MyDeque<>();
        }

        // 入栈
        public void push(T data) {
            deque.offerFromTail(data);
        }

        // 出栈
        public T pop() {
            return deque.pollFromTail();
        }
    }

    // 双链表实现双端队列（头部既可以添加也可以取出，尾部既可以添加也可以取出）
    public static class MyDeque<T> {
        DoubleNode<T> head;
        DoubleNode<T> tail;
        int size;

        public boolean isEmpty() {
            return size == 0;
        }

        // 头部添加
        public void offerFromHead(T data) {
            DoubleNode cur = new DoubleNode(data);
            if (head == null) {
                head = tail = cur;
            } else {
                cur.next = head;
                head.pre = cur;
                head = cur;
            }
            size++;
        }

        // 头部取出
        public T pollFromHead() {
            T ans = null;
            if (head == null) {
                return ans;
            }
            size--;
            ans = head.val;
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
                head.pre = null;
            }
            return ans;
        }

        // 查看头部
        public T peekHead() {
            return head != null ? head.val : null;
        }

        // 尾部添加
        public void offerFromTail(T data) {
            DoubleNode cur = new DoubleNode(data);
            if (head == null) {
                head = tail = cur;
            } else {
                tail.next = cur;
                cur.pre = tail;
                tail = cur;
            }
            size++;
        }

        // 尾部取出
        public T pollFromTail() {
            T ans = null;
            if (head == null) {
                return ans;
            }
            size--;
            ans = tail.val;
            if (head == tail) {
                head = tail = null;
            } else {
                tail = tail.pre;
                tail.next = null;
            }
            return ans;
        }

        // 查看尾部
        public T peekTail() {
            return tail != null ? tail.val : null;
        }
    }
}
