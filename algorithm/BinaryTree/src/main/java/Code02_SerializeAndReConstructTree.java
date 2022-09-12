import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 实现二叉树的序列化和反序列化
 * <p>
 * 1）先序方式序列化和反序列化
 * <p>
 * 2）按层方式序列化和反序列化
 *
 * @author Mark
 * @date 2021/8/21 17:07
 */
public class Code02_SerializeAndReConstructTree {

    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    /**
     * 后序序列化
     */
    public static Queue<String> postSerial(Node head) {
        Queue<String> ans = new LinkedList<>();
        post(head, ans);
        return ans;
    }

    private static void post(Node head, Queue<String> ans) {
        if (head == null) {
            ans.add(null);
        } else {
            post(head.left, ans);
            post(head.right, ans);
            ans.add(String.valueOf(head.val));
        }
    }

    /**
     * 后序反序列化
     */
    public static Node buildByPostQueue(Queue<String> postList) {
        if (postList == null || postList.size() == 0) {
            return null;
        }
        Stack<String> stack = new Stack<>();
        while (!postList.isEmpty()) {
            stack.push(postList.poll());
        }
        return postBuild(stack);
    }

    public static Node postBuild(Stack<String> postStack) {
        String val = postStack.pop();
        if (val == null) {
            return null;
        }
        Node head = new Node(Integer.parseInt(val));
        head.right = postBuild(postStack);
        head.left = postBuild(postStack);
        return head;
    }

    /**
     * 先序序列化
     */
    public static Queue<String> preSerial(Node head) {
        Queue<String> ans = new LinkedList<>();
        pre(head, ans);
        return ans;
    }

    /**
     * 先序反序列化
     */
    public static Node buildByPreQueue(Queue<String> preList) {
        if (preList == null || preList.size() == 0) {
            return null;
        }
        return preBuild(preList);
    }

    private static Node preBuild(Queue<String> preList) {
        String val = preList.poll();
        if (val == null) {
            return null;
        }
        Node head = new Node(Integer.parseInt(val));
        head.left = preBuild(preList);
        head.right = preBuild(preList);
        return head;
    }

    private static void pre(Node head, Queue<String> ans) {
        if (head == null) {
            ans.add(null);
        } else {
            ans.add(String.valueOf(head.val));
            pre(head.left, ans);
            pre(head.right, ans);
        }
    }

    /**
     * 按层序列化
     */
    public static Queue<String> levelSerial(Node head) {
        Queue<String> ans = new LinkedList<>();
        if (head == null) {
            ans.add(null);
        } else {
            ans.add(String.valueOf(head.val));
            Queue<Node> queue = new LinkedList<>();
            queue.offer(head);
            while (!queue.isEmpty()) {
                Node cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                    ans.add(String.valueOf(cur.left.val));
                } else {
                    ans.add(null);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                    ans.add(String.valueOf(cur.right.val));
                } else {
                    ans.add(null);
                }
            }
        }
        return ans;
    }

    /**
     * 按层反序列化
     */
    public static Node buildByLevelQueue(Queue<String> levelList) {
        if (levelList == null || levelList.size() == 0) {
            return null;
        }
        Node head = generateNode(levelList.poll());
        Queue<Node> queue = new LinkedList<>();
        if (head != null) {
            queue.add(head);
        }
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            cur.left = generateNode(levelList.poll());
            cur.right = generateNode(levelList.poll());
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
        return head;
    }

    private static Node generateNode(String val) {
        return val == null ? null : new Node(Integer.parseInt(val));
    }

    // for test
    public static Node generateRandomBST(int maxLevel, int maxValue) {
        return generate(1, maxLevel, maxValue);
    }

    // for test
    public static Node generate(int level, int maxLevel, int maxValue) {
        if (level > maxLevel || Math.random() < 0.5) {
            return null;
        }
        Node head = new Node((int) (Math.random() * maxValue));
        head.left = generate(level + 1, maxLevel, maxValue);
        head.right = generate(level + 1, maxLevel, maxValue);
        return head;
    }

    // for test
    public static boolean isSameValueStructure(Node head1, Node head2) {
        if (head1 == null && head2 != null) {
            return false;
        }
        if (head1 != null && head2 == null) {
            return false;
        }
        if (head1 == null && head2 == null) {
            return true;
        }
        if (head1.val != head2.val) {
            return false;
        }
        return isSameValueStructure(head1.left, head2.left) && isSameValueStructure(head1.right, head2.right);
    }

    public static void main(String[] args) {
        int maxLevel = 5;
        int maxValue = 100;
        int testTimes = 1000000;
        System.out.println("test begin");
        for (int i = 0; i < testTimes; i++) {
            Node head = generateRandomBST(maxLevel, maxValue);
            Queue<String> pre = preSerial(head);
            Queue<String> pos = postSerial(head);
            Queue<String> level = levelSerial(head);
            Node preBuild = buildByPreQueue(pre);
            Node posBuild = buildByPostQueue(pos);
            Node levelBuild = buildByLevelQueue(level);
            if (!isSameValueStructure(preBuild, posBuild) || !isSameValueStructure(posBuild, levelBuild)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("test finish!");

        // Node node5 = new Node(5);
        // Node node6 = new Node(6);
        // Node node8 = new Node(8);
        // Node node7 = new Node(7);
        // Node node4 = new Node(4);
        // Node node3 = new Node(3);
        // node5.left = node6;
        // node5.right = node8;
        // node6.left = node7;
        // node6.right = node4;
        // node8.right = node3;
        //
        // System.out.println(postSerial(node5));
    }
}
