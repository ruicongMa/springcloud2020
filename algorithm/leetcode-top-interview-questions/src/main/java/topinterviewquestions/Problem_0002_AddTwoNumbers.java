package topinterviewquestions;

/**
 * @author Mark
 * @date 2022/3/8 19:23
 */
public class Problem_0002_AddTwoNumbers {

    // 两数相加：https://leetcode.com/problems/add-two-numbers/

    // 不要提交这个类描述
    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int value) {
            this.val = value;
        }
    }

    // 方法一：新的链表，每个节点指向前边（左），最后再反转链表
    public static ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        int ca = 0; // 表示进位
        int n1 = 0; // 链表1上每位值
        int n2 = 0; // 链表2上每位值
        int n = 0; // 链表1每位上的值加上链表2每位上的值的结果
        ListNode c1 = head1;
        ListNode c2 = head2;
        ListNode node = null;
        ListNode pre = null;
        while (c1 != null || c2 != null) {
            n1 = c1 != null ? c1.val : 0;
            n2 = c2 != null ? c2.val : 0;
            n = n1 + n2 + ca;
            pre = node;
            node = new ListNode(n % 10); // %10表示结果
            node.next = pre;
            ca = n / 10; // /10表示进位
            c1 = c1 != null ? c1.next : null;
            c2 = c2 != null ? c2.next : null;
        }
        if (ca == 1) { // 最后如果有进位，则再补一个节点
            pre = node;
            node = new ListNode(1);
            node.next = pre;
        }
        return reverseList(node);
    }

    private static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    // 方法二：新的链表，每个节点指向后边（右），不用反转
    public static ListNode addTwoNumbers2(ListNode head1, ListNode head2) {
        int ca = 0;
        int n1 = 0;
        int n2 = 0;
        int n = 0;
        ListNode c1 = head1;
        ListNode c2 = head2;
        ListNode node = null;
        ListNode head = null;
        ListNode pre = null;
        while (c1 != null || c2 != null) {
            n1 = c1 != null ? c1.val : 0;
            n2 = c2 != null ? c2.val : 0;
            n = n1 + n2 + ca;
            node = new ListNode(n % 10);
            if (head == null) {
                head = node;
            }
            if (pre != null) {
                pre.next = node;
            }
            pre = node;
            ca = n / 10;
            c1 = c1 != null ? c1.next : null;
            c2 = c2 != null ? c2.next : null;
        }
        if (ca == 1) {
            node = new ListNode(1);
            if (pre != null) {
                pre.next = node;
            }
        }
        return head;
    }

}
