package toplikedquestions;

import java.util.HashMap;

/**
 * @author Mark
 * @date 2022/4/3 12:22
 */
public class Problem_0437_PathSumIII {

    // 路径总和 III：https://leetcode.com/problems/path-sum-iii/
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> preSumMap = new HashMap<>();
        preSumMap.put(0, 1);
        // preAll：之前的累加和
        return process(root, sum, 0, preSumMap);
    }

    // 返回方法数，先序遍历
    public static int process(TreeNode x, int sum, int preAll, HashMap<Integer, Integer> preSumMap) {
        if (x == null) {
            return 0;
        }
        int all = preAll + x.val;
        int ans = 0;
        // 以x.val结尾的路径有没有
        if (preSumMap.containsKey(all - sum)) {
            ans = preSumMap.get(all - sum); // 当前值
        }
        if (!preSumMap.containsKey(all)) {
            preSumMap.put(all, 1);
        } else {
            preSumMap.put(all, preSumMap.get(all) + 1);
        }
        // 左树值
        ans += process(x.left, sum, all, preSumMap);
        // 右树值
        ans += process(x.right, sum, all, preSumMap);
        if (preSumMap.get(all) == 1) { // 清理map
            preSumMap.remove(all);
        } else {
            preSumMap.put(all, preSumMap.get(all) - 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        node1.left = node2;
        System.out.println(pathSum(node1, 1));
    }
}
