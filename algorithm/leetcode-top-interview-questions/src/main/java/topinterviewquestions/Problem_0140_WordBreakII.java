package topinterviewquestions;

import java.util.*;

/**
 * @author Mark
 * @date 2022/3/25 10:42
 */
public class Problem_0140_WordBreakII {

    // 单词拆分 II：https://leetcode.com/problems/word-break-ii/

    // 方法一
    public static List<String> wordBreak2(String s, List<String> wordDict) {
        ArrayList<String> path = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        process2(s, 0, path, ans, new HashSet<>(wordDict));
        return ans;
    }

    public static void process2(String s, int index, ArrayList<String> path, List<String> ans, HashSet<String> wordDict) {
        if (index == s.length()) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < path.size() - 1; i++) {
                builder.append(path.get(i) + " ");
            }
            builder.append(path.get(path.size() - 1));
            ans.add(builder.toString());
        } else {
            // index没到最后
            // index...index
            // index...index+1
            // index...index+2
            // index...end
            for (int end = index; end < s.length(); end++) {
                // s[index....end]
                String pre = s.substring(index, end + 1);
                if (wordDict.contains(pre)) {
                    path.add(pre); // 添加答案
                    process2(s, end + 1, path, ans, wordDict); // 深度优先遍历
                    path.remove(path.size() - 1); // 清理现场
                }
            }
        }
    }

    public static void main(String[] args) {
        String s = "pineapplepenapple";
        List<String> worDict = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");
        System.out.println(wordBreak2(s, worDict));
    }

    public static class Node {
        public String path;
        public boolean end;
        public Node[] nexts;

        public Node() {
            path = null;
            end = false;
            nexts = new Node[26];
        }
    }

    // 方法二
    public static List<String> wordBreak(String s, List<String> wordDict) {
        char[] str = s.toCharArray();
        Node root = gettrie(wordDict);
        boolean[] dp = getdp(s, root);
        ArrayList<String> path = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        process(str, 0, root, dp, path, ans);
        return ans;
    }

    public static void process(char[] str, int index, Node root, boolean[] dp, ArrayList<String> path,
                               List<String> ans) {
        if (index == str.length) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < path.size() - 1; i++) {
                builder.append(path.get(i) + " ");
            }
            builder.append(path.get(path.size() - 1));
            ans.add(builder.toString());
        } else {
            Node cur = root;
            for (int end = index; end < str.length; end++) {
                cur = cur.nexts[str[end] - 'a'];
                if (cur == null) {
                    break;
                }
                if (cur.end && dp[end + 1]) {
                    path.add(cur.path);
                    process(str, end + 1, root, dp, path, ans);
                    path.remove(path.size() - 1);
                }
            }
        }
    }

    public static Node gettrie(List<String> wordDict) {
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
            node.path = str;
            node.end = true;
        }
        return root;
    }

    public static boolean[] getdp(String s, Node root) {
        char[] str = s.toCharArray();
        int N = str.length;
        boolean[] dp = new boolean[N + 1];
        dp[N] = true;
        for (int index = N - 1; index >= 0; index--) {
            Node cur = root;
            for (int end = index; end < N; end++) {
                cur = cur.nexts[str[end] - 'a'];
                if (cur == null) { // 剪枝，如果没路了，则后续过程一定凑不出剩下的单词，提前退出
                    break;
                }
                if (cur.end && dp[end + 1]) {
                    dp[index] = true;
                    break;
                }
            }
        }
        return dp;
    }
}
