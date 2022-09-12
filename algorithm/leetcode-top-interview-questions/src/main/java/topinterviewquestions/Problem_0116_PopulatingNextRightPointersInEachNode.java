package topinterviewquestions;

/**
 * @author Mark
 * @date 2022/3/22 18:44
 */
public class Problem_0116_PopulatingNextRightPointersInEachNode {

    // 填充每个节点的下一个右侧节点指针：https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node(int value) {
            this.val = value;
        }
    }

    public static class MyQueue {
        public Node head;
        public Node tail;
        public int size;

        public MyQueue() {
            head = null;
            tail = null;
            size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void offer(Node cur) {
            size++;
            if (head == null) {
                head = cur;
                tail = cur;
            } else {
                tail.next = cur;
                tail = cur;
            }
        }

        public Node poll() {
            size--;
            Node ans = head;
            head = head.next;
            ans.next = null;
            return ans;
        }

    }

    public static Node connect(Node root) {
        if (root == null) {
            return root;
        }
        MyQueue queue = new MyQueue();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 第一个弹出的节点
            Node pre = null;
            int size = queue.size;
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                if (pre != null) {
                    pre.next = cur;
                }
                pre = cur;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        Node head = connect(a);
        System.out.println(head);
    }
}
