package topinterviewquestions;

/**
 * @author Mark
 * @date 2022/3/31 18:56
 */
public class Problem_0328_OddEvenLinkedList {

    // 奇偶链表：https://leetcode.com/problems/odd-even-linked-list/
    // 提交时不要提交这个类
    public static class ListNode {
        int val;
        ListNode next;
    }

    public ListNode oddEvenList(ListNode head) {
        ListNode firstOdd = null;
        ListNode firstEven = null;
        ListNode odd = null;
        ListNode even = null;
        ListNode next = null;
        int count = 1;
        while (head != null) {
            next = head.next;
            head.next = null;
            if ((count & 1) == 1) { // 奇数
                firstOdd = firstOdd == null ? head : firstOdd;
                if (odd != null) {
                    odd.next = head;
                }
                odd = head;
            } else { // 偶数
                firstEven = firstEven == null ? head : firstEven;
                if (even != null) {
                    even.next = head;
                }
                even = head;
            }
            count++;
            head = next;
        }
        if (odd != null) {
            odd.next = firstEven;
        }
        return firstOdd != null ? firstOdd : firstEven;
    }
}
