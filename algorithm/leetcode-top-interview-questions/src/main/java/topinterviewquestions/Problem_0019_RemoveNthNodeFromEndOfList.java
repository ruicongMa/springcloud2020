package topinterviewquestions;

/**
 * @author Mark
 * @date 2022/3/10 11:49
 */
public class Problem_0019_RemoveNthNodeFromEndOfList {

    // 删除链表的倒数第 N 个结点：https://leetcode.com/problems/remove-nth-node-from-end-of-list/

    public static class ListNode {
        public int val;
        public ListNode next;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            n--;
            if (n == -1) {
                pre = head;
            }
            if (n < -1) {
                pre = pre.next;
            }
            cur = cur.next;
        }
        if (n > 0) {
            return head;
        }
        if (pre == null) {
            return head.next;
        }
        pre.next = pre.next.next;
        return head;
    }
}
