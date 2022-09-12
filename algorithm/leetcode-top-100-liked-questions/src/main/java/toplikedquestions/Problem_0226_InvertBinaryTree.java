package toplikedquestions;

/**
 * @author Mark
 * @date 2022/4/2 18:51
 */
public class Problem_0226_InvertBinaryTree {

    // 翻转二叉树：https://leetcode.com/problems/invert-binary-tree/
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(left);
        return root;
    }
}
