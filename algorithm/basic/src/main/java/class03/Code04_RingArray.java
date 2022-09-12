package class03;

/**
 * @author Mark
 * @date 2022/2/14 12:05
 */
public class Code04_RingArray {

    // 环形数组实现队列
    // 数组实现队列 先进先出
    public static class MyQueue<T> {
        private Object[] arr;
        private int offerIndex;
        private int pollIndex;
        private int size;
        private final int limit;

        public MyQueue(int limit) {
            this.arr = new Object[limit];
            this.offerIndex = 0;
            this.pollIndex = 0;
            this.size = 0;
            this.limit = limit;
        }

        private boolean isFull() {
            return size == limit;
        }

        private boolean isEmpty() {
            return size == 0;
        }

        // 入队
        public void offer(Object data) {
            if (isFull()) {
                throw new RuntimeException("队列已满，不能再添加了！");
            }
            size++;
            arr[offerIndex] = data;
            offerIndex = nextIndex(offerIndex);
        }

        // 出队
        public T poll() {
            if (isEmpty()) {
                throw new RuntimeException("队列已空，不能再取出了！");
            }
            size--;
            T ans = (T) arr[pollIndex];
            pollIndex = nextIndex(pollIndex);
            return ans;
        }

        // 如果现在的下标是i，返回下一个位置
        private int nextIndex(int i) {
            return i < limit - 1 ? i + 1 : 0;
        }
    }

}
