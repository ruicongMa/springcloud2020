package topinterviewquestions;

/**
 * @author Mark
 * @date 2022/3/27 21:09
 */
public class Problem_0206_ReverseLinkedList {

    // 反转链表：https://leetcode.com/problems/reverse-linked-list/
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode reverseList(ListNode head) {
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

    //采用递归进行反转链表
    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newList = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newList;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode head = reverseList2(node1);
        System.out.println(head);

    }
}
