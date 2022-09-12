package topinterviewquestions;

/**
 * @author Mark
 * @date 2022/3/15 17:42
 */
public class Problem_0098_ValidateBinarySearchTree {

    // 验证二叉搜索树：https://leetcode.com/problems/validate-binary-search-tree
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode cur = root;
        TreeNode mostRight = null;
        Integer pre = null;
        boolean ans = true;
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
            if (pre != null && pre >= cur.val) {
                ans = false;
            }
            pre = cur.val;
            cur = cur.right;
        }
        return ans;
    }
}
