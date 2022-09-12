package topinterviewquestions;

/**
 * @author Mark
 * @date 2022/3/22 17:53
 */
public class Problem_0108_ConvertSortedArrayToBinarySearchTree {

    // 将有序数组转换为二叉搜索树：https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return process(nums, 0, nums.length - 1);
    }

    public static TreeNode process(int[] nums, int L, int R) {
        if (L > R) {
            return null;
        }
        if (L == R) {
            return new TreeNode(nums[L]);
        }
        int M = L + ((R - L) >> 1);
        TreeNode head = new TreeNode(nums[M]);
        head.left = process(nums, L, M - 1);
        head.right = process(nums, M + 1, R);
        return head;
    }
}
