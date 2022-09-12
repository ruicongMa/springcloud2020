package topinterviewquestions;

/**
 * @author Mark
 * @date 2022/3/28 20:57
 */
public class Problem_0237_DeleteNodeInLinkedList {

    // 删除链表中的节点：https://leetcode.com/problems/delete-node-in-a-linked-list/
    public static class ListNode {
        int val;
        ListNode next;
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
