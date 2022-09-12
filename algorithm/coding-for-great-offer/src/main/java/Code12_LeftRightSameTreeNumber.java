/**
 * @author Mark
 * @date 2021/10/22 16:43
 */
public class Code12_LeftRightSameTreeNumber {

    /**
     * 阿里笔试题：
     * 如果一个节点X，它左树结构和右树结构完全一样
     * 那么我们说以X为头的树是相等树
     * 给定一棵二叉树的头节点head
     * 返回head整棵树上有多少棵相等子树
     */

    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    // 时间复杂度O(N * logN) Master公式推导
    public static int sameNumber1(Node head) {
        if (head == null) {
            return 0;
        }
        return sameNumber1(head.left) + sameNumber1(head.right) + (same(head.left, head.right) ? 1 : 0);
    }

    private static boolean same(Node h1, Node h2) {
        if (h1 == null ^ h2 == null) {
            return false;
        }
        if (h1 == null && h2 == null) {
            return true;
        }
        // 两个都不为空
        return h1.val == h2.val && same(h1.left, h2.left) && same(h1.right, h2.right);
    }

    // 时间复杂度O(N)
    public static int sameNumber2(Node head) {
        String algorithm = "SHA-256";
        Hash hash = new Hash(algorithm);
        return process(head, hash).ans;
    }

    public static class Info {
        int ans;
        String str;

        public Info(int ans, String str) {
            this.ans = ans;
            this.str = str;
        }
    }

    public static Info process(Node head, Hash hash) {
        if (head == null) {
            return new Info(0, hash.hashCode("#,"));
        }
        Info l = process(head.left, hash);
        Info r = process(head.right, hash);
        int ans = (l.str.equals(r.str) ? 1 : 0) + l.ans + r.ans;
        String str = hash.hashCode(head.val + "," + l.str + r.str);
        return new Info(ans, str);
    }

    private static Node randomBinaryTree(int restLevel, int maxValue) {
        if (restLevel == 0) {
            return null;
        }
        Node head = Math.random() < 0.2 ? null : new Node((int) (Math.random() * maxValue));
        if (head != null) {
            head.left = randomBinaryTree(restLevel - 1, maxValue);
            head.right = randomBinaryTree(restLevel - 1, maxValue);
        }
        return head;
    }

    public static void main(String[] args) {
        int maxLevel = 8;
        int maxValue = 4;
        int testTime = 100000;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            Node head = randomBinaryTree(maxLevel, maxValue);
            int ans1 = sameNumber1(head);
            int ans2 = sameNumber2(head);
            if (ans1 != ans2) {
                System.out.println("出错了！");
                System.out.println(ans1);
                System.out.println(ans2);
            }
        }
        System.out.println("测试结束");

    }

}
