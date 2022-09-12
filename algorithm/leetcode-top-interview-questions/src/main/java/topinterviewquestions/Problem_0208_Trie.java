package topinterviewquestions;

/**
 * @author Mark
 * @date 2022/3/27 22:49
 */
public class Problem_0208_Trie {

    // 实现 Trie (前缀树)：https://leetcode.com/problems/implement-trie-prefix-tree/
    public static class Node {
        public boolean end; // 结束位置，true代表路走完了
        public Node[] nexts; // 下层节点

        public Node() {
            end = false;
            nexts = new Node[26];
        }
    }

    private Node root;

    public Problem_0208_Trie() {
        root = new Node();
    }

    public void insert(String word) {
        if (word == null) {
            return;
        }
        char[] str = word.toCharArray();
        Node node = root;
        int path = 0;
        for (int i = 0; i < str.length; i++) {
            path = str[i] - 'a';
            if (node.nexts[path] == null) {
                node.nexts[path] = new Node();
            }
            node = node.nexts[path];
        }
        node.end = true;
    }

    public boolean search(String word) {
        if (word == null) {
            return false;
        }
        char[] chs = word.toCharArray();
        Node node = root;
        int path = 0;
        for (int i = 0; i < chs.length; i++) {
            path = chs[i] - 'a';
            if (node.nexts[path] == null) {
                return false;
            }
            node = node.nexts[path];
        }
        return node.end;
    }

    public boolean startsWith(String pre) {
        if (pre == null) {
            return false;
        }
        char[] chs = pre.toCharArray();
        Node node = root;
        int path = 0;
        for (int i = 0; i < chs.length; i++) {
            path = chs[i] - 'a';
            if (node.nexts[path] == null) {
                return false;
            }
            node = node.nexts[path];
        }
        return true;
    }
}
