package topinterviewquestions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Mark
 * @date 2022/3/16 21:40
 */
public class Problem_0103_BinaryTreeZigzagLevelOrderTraversal {

    // 二叉树的锯齿形层序遍历：https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        LinkedList<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        int size = 0;
        boolean isHead = true; // 头尾交替
        while (!deque.isEmpty()) {
            size = deque.size();
            List<Integer> curLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                // 头的话从头取，尾的话从尾取
                TreeNode cur = isHead ? deque.pollFirst() : deque.pollLast();
                curLevel.add(cur.val);
                if (isHead) { // 头的话，子节点从尾进
                    if (cur.left != null) {
                        deque.addLast(cur.left);
                    }
                    if (cur.right != null) {
                        deque.addLast(cur.right);
                    }
                } else { // 尾的话，子节点从头进
                    if (cur.right != null) {
                        deque.addFirst(cur.right);
                    }
                    if (cur.left != null) {
                        deque.addFirst(cur.left);
                    }
                }
            }
            ans.add(curLevel);
            isHead = !isHead;
        }
        return ans;
    }
}
