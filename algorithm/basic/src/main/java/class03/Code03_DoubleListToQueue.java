package class03;

/**
 * @author Mark
 * @date 2022/2/14 12:35
 */
public class Code03_DoubleListToQueue {

    // 双向链表或双端队列实现队列

    /**
     * 双端队列：头部即可添加也可取出，尾部即可添加也可取出。
     * <p>
     * 队列满足先进先出，即头部添加，尾部取出。或者尾部添加，头部取出都满足队列特性。
     */

    public static class DoubleNode<T> {
        T val;
        DoubleNode<T> pre;
        DoubleNode<T> next;

        public DoubleNode(T data) {
            this.val = data;
        }
    }

    // 队列
    public static class MyQueue<T> {
        MyDeque<T> deque;

        public MyQueue() {
            this.deque = new MyDeque<>();
        }

        // 添加
        public void offer(T data) {
            deque.offerFromHead(data);
        }

        // 取出
        public T poll() {
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
