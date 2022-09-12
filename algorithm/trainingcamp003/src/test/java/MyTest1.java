/**
 * @author Mark
 * @date 2022/4/16 10:59
 */
public class MyTest1 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode pre = newHead;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next = null;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return newHead.next;
    }

    public static ListNode reverse(ListNode leftNode, ListNode rightNode) {
        ListNode cur = leftNode;
        ListNode pre = null;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            if (pre == rightNode) {
                break;
            }
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        // ListNode node3 = new ListNode(3);
        // ListNode node4 = new ListNode(4);
        // ListNode node5 = new ListNode(5);
        node1.next = node2;
        // node2.next = node3;
        // node3.next = node4;
        // node4.next = node5;
        // ListNode head = reverse(node2, node4);
        // System.out.println(head);
        ListNode listNode = reverseBetween(node1, 1, 2);
        System.out.println(listNode);
    }
}
