import java.util.LinkedList;
import java.util.Queue;

/**
 * 实现二叉树的按层遍历
 * 1）其实就是宽度优先遍历，用队列
 * <p>
 * 2）可以通过设置flag变量的方式，来发现某一层的结束（看题目）
 *
 * @author Mark
 * @date 2021/8/21 16:36
 */
public class Code01_LevelTraversalBT {

    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void levelTraversalBT(Node head) {
        if (head == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.println(cur.val);
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    public static void main(String[] args) {
        Node node5 = new Node(5);
        node5.left = new Node(6);
        node5.right = new Node(8);
        node5.left.left = new Node(7);
        node5.left.right = new Node(4);
        node5.right.right = new Node(3);

        levelTraversalBT(node5);
    }

}
