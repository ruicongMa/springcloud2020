package class03;

/**
 * @author Mark
 * @date 2022/2/14 15:07
 */
public class Code03_ArrayToStack {

    // 数组实现栈
    public static class MyStack<T> {
        private Object[] arr;
        private int index;
        private int size;

        public MyStack(int size) {
            this.size = size;
            this.arr = new Object[size];
        }

        public boolean isEmpty() {
            return index == 0;
        }

        public boolean isFull() {
            return index == size;
        }

        // 添加
        public void push(Object data) {
            if (isFull()) {
                throw new RuntimeException("栈满了，不能再添加了~");
            }
            arr[index++] = data;
        }

        // 弹出
        public T pop() {
            if (isEmpty()) {
                throw new RuntimeException("栈空了，不能再弹出了~");
            }
            return (T) arr[--index];
        }
    }

}
