package topinterviewquestions;

import java.util.Stack;

/**
 * @author Mark
 * @date 2022/3/28 19:22
 */
public class Problem_0230_KthSmallestElementInBST {

    // 二叉搜索树中第K小的元素：https://leetcode.com/problems/kth-smallest-element-in-a-bst/


    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    // 中序遍历解法
    public static int kthSmallest2(TreeNode head, int k) {
        if (head == null) {
            return -1;
        }
        // 中序
        TreeNode cur = head;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if (k == 1) {
                    return cur.val;
                }
                k--;
                cur = cur.right;
            }
        }
        return -1;
    }

    // Morris遍历解法
    public static int kthSmallest(TreeNode head, int k) {
        if (head == null) {
            return -1;
        }
        TreeNode cur = head;
        TreeNode mostRight = null;
        int index = 1;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }
            if (index++ == k) {
                return cur.val;
            }
            cur = cur.right;
        }
        return -1;
    }
}
