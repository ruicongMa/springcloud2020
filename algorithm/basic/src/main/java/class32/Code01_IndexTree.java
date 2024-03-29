package class32;

/**
 * @author Mark
 * @date 2022/3/3 19:39
 */
public class Code01_IndexTree {

    /**
     * IndexTree
     * 特点：
     * 1）支持区间查询
     * 2）没有线段树那么强，但是非常容易改成一维、二维、三维的结构
     * 3）只支持单点更新
     */

    // 下标从1开始！
    public static class IndexTree {

        private int[] tree;
        private int N;

        // 0位置弃而不用！
        public IndexTree(int size) {
            N = size;
            tree = new int[N + 1];
        }

        // 1~index 累加和是多少？
        public int sum(int index) {
            int ret = 0;
            while (index > 0) {
                ret += tree[index];
                index -= index & -index; // 不断的减最右侧的1
            }
            return ret;
        }

        // index & -index : 提取出index最右侧的1出来
        // index :           0011001000
        // index & -index :  0000001000
        public void add(int index, int d) {
            while (index <= N) {
                tree[index] += d;
                index += index & -index; // 不断的加最右侧的1
            }
        }
    }

    public static class Right {
        private int[] nums;
        private int N;

        // 0位置不用，从1开始
        public Right(int size) {
            N = size + 1;
            nums = new int[N + 1];
        }

        public int sum(int index) {
            int ret = 0;
            for (int i = 1; i <= index; i++) {
                ret += nums[i];
            }
            return ret;
        }

        public void add(int index, int d) {
            nums[index] += d;
        }

    }

    public static void main(String[] args) {
        int N = 100;
        int V = 100;
        int testTime = 2000000;
        IndexTree tree = new IndexTree(N);
        Right test = new Right(N);
        System.out.println("test begin");
        for (int i = 0; i < testTime; i++) {
            int index = (int) (Math.random() * N) + 1;
            if (Math.random() <= 0.5) {
                int add = (int) (Math.random() * V);
                tree.add(index, add);
                test.add(index, add);
            } else {
                if (tree.sum(index) != test.sum(index)) {
                    System.out.println("Oops!");
                }
            }
        }
        System.out.println("test finish");
    }
}
