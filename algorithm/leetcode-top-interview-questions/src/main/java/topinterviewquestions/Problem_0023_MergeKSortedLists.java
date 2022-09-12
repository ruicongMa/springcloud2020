package topinterviewquestions;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Mark
 * @date 2022/3/10 15:49
 */
public class Problem_0023_MergeKSortedLists {

    // 合并K个升序链表：https://leetcode.com/problems/merge-k-sorted-lists/

    public static class ListNode {
        public int val;
        public ListNode next;
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }
        // 小根堆
        PriorityQueue<ListNode> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                heap.add(lists[i]);
            }
        }
        if (heap.isEmpty()) {
            return null;
        }
        ListNode head = heap.poll();
        ListNode pre = head;
        if (pre.next != null) {
            heap.add(pre.next);
        }
        while (!heap.isEmpty()) {
            ListNode cur = heap.poll();
            pre.next = cur;
            pre = cur;
            if (cur.next != null) {
                heap.add(cur.next);
            }
        }
        return head;
    }
}
