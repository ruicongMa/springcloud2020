package topinterviewquestions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mark
 * @date 2022/3/15 17:41
 */
public class Problem_0094_BinaryTreeInorderTraversal {

    // 二叉树的中序遍历：https://leetcode.com/problems/binary-tree-inorder-traversal
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        TreeNode cur = root;
        TreeNode mostRight = null;
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
            ans.add(cur.val);
            cur = cur.right;
        }
        return ans;
    }
}
