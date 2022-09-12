package topinterviewquestions;

/**
 * @author Mark
 * @date 2022/3/16 22:04
 */
public class Problem_0104_MaximumDepthOfBinaryTree {

    // 二叉树的最大深度：https://leetcode.com/problems/maximum-depth-of-binary-tree/
    /*
     * 注意最小高度比这个复杂，要额外小心判断空
     * */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
