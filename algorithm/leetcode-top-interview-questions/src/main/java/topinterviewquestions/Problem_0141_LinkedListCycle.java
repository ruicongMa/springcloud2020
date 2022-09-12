package topinterviewquestions;

/**
 * @author Mark
 * @date 2022/3/25 12:19
 */
public class Problem_0141_LinkedListCycle {

    // 环形链表：https://leetcode.com/problems/linked-list-cycle/
    public static class ListNode {
        int val;
        ListNode next;
    }

    public static boolean hasCycle(ListNode head) {
        return getFirstLoopNode(head) != null;
    }

    // 得到第一个入环节点
    public static ListNode getFirstLoopNode(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        ListNode slow = head.next; // 刚开始慢指针一次走一步
        ListNode fast = head.next.next; // 刚开始快指针一次走两步
        while (slow != fast) { // 只要不相遇就继续
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        // 第一次快慢指针相遇
        fast = head; // 快指针从头开始
        while (slow != fast) { // 只要不相遇就继续
            slow = slow.next; // 快指针一次走一步
            fast = fast.next; // 慢指针一次走一步
        }
        // 快慢指针相遇
        return slow;
    }
}
