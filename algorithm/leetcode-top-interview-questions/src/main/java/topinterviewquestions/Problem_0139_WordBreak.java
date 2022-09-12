package topinterviewquestions;

import java.util.HashSet;
import java.util.List;

/**
 * @author Mark
 * @date 2022/3/24 22:36
 */
public class Problem_0139_WordBreak {

    // 单词拆分：https://leetcode.com/problems/word-break/
    public static boolean wordBreak(String s, List<String> wordDict) {
        Node root = new Node();
        for (String str : wordDict) {
            char[] chs = str.toCharArray();
            Node node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.nexts[index] == null) {
                    node.nexts[index] = new Node();
                }
                node = node.nexts[index];
            }
            node.end = true;
        }
        char[] str = s.toCharArray();
        int N = str.length;
        boolean[] dp = new boolean[N + 1];
        dp[N] = true;
        for (int i = N - 1; i >= 0; i--) {
            Node cur = root;
            for (int end = i; end < N; end++) {
                int path = str[end] - 'a';
                if (cur.nexts[path] == null) {
                    break;
                }
                cur = cur.nexts[path];
                if (cur.end && dp[end + 1]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }

    // 方法一，会超时
    public static boolean wordBreak2(String s, List<String> wordDict) {
        return process(s, 0, new HashSet<>(wordDict)) != 0;
    }

    // s[0......index-1]这一段，已经分解过了，不用在操心
    // s[index.....] 这一段字符串，返回能够被分解的方法数
    public static int process(String s, int index, HashSet<String> wordDict) {
        if (index == s.length()) { // base case
            return 1;
        }
        // index没到最后
        // index...index
        // index...index+1
        // index...index+2
        // index...end
        int ways = 0;
        for (int end = index; end < s.length(); end++) {
            // s[index...end]
            String pre = s.substring(index, end + 1);
            if (wordDict.contains(pre)) {
                ways += process(s, end + 1, wordDict); // 深度优先遍历
            }
        }
        return ways;
    }

    // 方法二：时间复杂度为O(N³)，
    public static boolean wordBreak3(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        int N = s.length();
        int[] dp = new int[N + 1];
        // dp[i] = process(s, i, set)的返回值
        dp[N] = 1;
        for (int index = N - 1; index >= 0; index--) { // O(N)
            int ways = 0;
            for (int end = index; end < s.length(); end++) { // O(N)
                // s[index....end]
                String pre = s.substring(index, end + 1); // substring、contains O(N)
                if (set.contains(pre)) {
                    ways += dp[end + 1];
                }
            }
            dp[index] = ways;
        }
        return dp[0] != 0;
    }

    public static class Node {
        public boolean end;
        public Node[] nexts;

        public Node() {
            end = false;
            nexts = new Node[26];
        }
    }

    // 方法三：利用前缀树，时间复杂度O(N²)
    public static boolean wordBreak4(String s, List<String> wordDict) {
        Node root = new Node();
        for (String str : wordDict) {
            char[] chs = str.toCharArray();
            Node node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.nexts[index] == null) {
                    node.nexts[index] = new Node();
                }
                node = node.nexts[index];
            }
            node.end = true;
        }
        char[] str = s.toCharArray();
        int N = str.length;
        int[] dp = new int[N + 1];
        dp[N] = 1;
        for (int index = N - 1; index >= 0; index--) { // O(N)
            Node cur = root;
            for (int end = index; end < N; end++) { // O(N)
                cur = cur.nexts[str[end] - 'a'];
                if (cur == null) { // 剪枝，如果没路了，则后续过程一定凑不出剩下的单词，提前退出
                    break;
                }
                if (cur.end) { // O(1)
                    dp[index] += dp[end + 1];
                }
            }
        }
        return dp[0] != 0;
    }
}
