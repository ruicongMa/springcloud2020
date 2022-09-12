/**
 * 先序遍历构建二叉搜索树
 * https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
 *
 * @author Mark
 * @date 2021/10/22 15:45
 */
public class Code11_ConstructBinarySearchTreeFromPreOrderTraversal {

    // 不用提交这个类
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 已知一棵搜索二叉树上没有重复值的节点，
     * 现在有一个数组arr，是这棵搜索二叉树先序遍历的结果
     * 请根据arr生成整棵树并返回头节点
     */

    /**
     * 递归
     */
    public TreeNode bstFromPreorder(int[] pre) {
        if (pre == null || pre.length == 0) {
            return null;
        }
        return process(pre, 0, pre.length - 1);
    }

    private TreeNode process(int[] pre, int L, int R) {
        if (L > R) {
            return null;
        }
        int firstBig = L + 1;
        for (; firstBig <= R; firstBig++) {
            if (pre[firstBig] > pre[L]) {
                break;
            }
        }
        TreeNode head = new TreeNode(pre[L]);
        head.left = process(pre, L + 1, firstBig - 1);
        head.right = process(pre, firstBig, R);
        return head;
    }

    /**
     * TODO
     * 利用单调栈优化
     */

    /**
     * TODO
     * 采用数组单调栈优化
     */
}
