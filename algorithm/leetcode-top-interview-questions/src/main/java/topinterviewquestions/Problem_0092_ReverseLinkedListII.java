package topinterviewquestions;

/**
 * @author Mark
 * @date 2022/4/16 13:12
 */
public class Problem_0092_ReverseLinkedListII {

    // 反转链表II：https://leetcode-cn.com/problems/reverse-linked-list-ii/

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

    }

    // 方法一：找到反转链表的开始节点和结束节点，正常反转
    public ListNode reverseBetween2(ListNode head, int from, int to) {
        int len = 0;
        ListNode node1 = head;
        ListNode fPre = null; // from节点的前一个节点
        ListNode tPos = null; // to节点的下一个节点
        while (node1 != null) { // 找到反转链表开始节点的前一个节点和结束节点的下一个节点
            len++;
            fPre = len == from - 1 ? node1 : fPre;
            tPos = len == to + 1 ? node1 : tPos;
            node1 = node1.next;
        }
        if (from > to || from < 1 || to > len) {
            return head;
        }
        node1 = fPre == null ? head : fPre.next;
        ListNode node2 = node1.next;
        node1.next = tPos;
        ListNode next = null;
        while (node2 != tPos) { // 反转from到to上的节点
            next = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = next;
        }
        if (fPre != null) {
            fPre.next = node1;
            return head;
        }
        return node1;
    }

    // 方法二：反转链表头插法，最优解
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }
        ListNode newHead = new ListNode(0); // 补一个头节点，left从1开始
        newHead.next = head;
        ListNode pre = newHead;
        for (int i = 0; i < left - 1; i++) { // 找到left节点的前一个节点
            pre = pre.next;
        }
        ListNode cur = pre.next; // 当前节点
        ListNode next = null; // 下一个节点
        for (int i = 0; i < right - left; i++) {
            // 链表头插法
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return newHead.next;
    }


}
