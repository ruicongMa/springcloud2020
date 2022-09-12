package toplikedquestions;

/**
 * @author Mark
 * @date 2022/4/2 20:53
 */
public class Problem_0617_MergeTwoBinaryTrees {

    // 合并二叉树：https://leetcode.com/problems/merge-two-binary-trees/
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode merge = new TreeNode(t1.val + t2.val);
        merge.left = mergeTrees(t1.left, t2.left);
        merge.right = mergeTrees(t1.right, t2.right);
        return merge;
    }
}
