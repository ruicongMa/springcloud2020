package class51;

import java.util.*;

/**
 * @author Mark
 * @date 2022/4/22 11:01
 */
public class DesignSearchAutocomplete {

    // 系统设计题：自动补全 https://www.lintcode.com/problem/231/
    // 方法一：利用前缀树，时间复杂度O(M*N)，M为字典的大小
    class Typeahead {

        private final Trie trie; // 前缀树
        // 外挂方式，某个前缀树节点，不在这个节点内部，key:节点对象，value：记录原始单词的下标列表
        private final HashMap<Node, List<Integer>> nodeToIndexListMap = new HashMap<>();
        private final String[] words; // 字典，dict -> words，通过 List<Integer> 获取 原始单词列表

        public Typeahead(Set<String> dict) {
            this.words = new String[dict.size()];
            // 构建前缀树
            this.trie = new Trie();
            init(dict);
        }

        // 初始化字典
        private void init(Set<String> dict) {
            int index = 0;
            for (String word : dict) {
                if (word == null || word.isEmpty()) {
                    continue;
                }
                // 构建字典
                this.words[index] = word;
                for (int i = 0; i < word.length(); i++) {
                    String subStr = word.substring(i);
                    // 枚举所有开头的子串，添加进前缀树中
                    trie.insert(index, subStr);
                }
                index++;
            }
        }

        public List<String> search(String str) {
            List<String> ans = new ArrayList<>();
            List<Integer> indexList = trie.prefix(str);
            for (Integer index : indexList) {
                ans.add(words[index]);
            }
            return ans;
        }

        class Node {
            // 哈希表实现的前缀树路径，一个节点下不知道有多少条路
            // key：path 通往哪条路，value：路径上的节点
            private final HashMap<Integer, Node> nexts;

            public Node() {
                this.nexts = new HashMap<>();
            }
        }

        class Trie {
            private final Node root; // 前缀树根节点

            public Trie() {
                this.root = new Node();
            }

            public void insert(int index, String word) {
                if (word == null || word.isEmpty()) {
                    return;
                }
                char[] chs = word.toCharArray();
                Node node = root;
                int path = 0;
                for (int i = 0; i < chs.length; i++) {
                    path = chs[i];
                    if (!node.nexts.containsKey(path)) {
                        node.nexts.put(path, new Node());
                    }
                    node = node.nexts.get(path);
                    if (!nodeToIndexListMap.containsKey(node)) {
                        nodeToIndexListMap.put(node, new ArrayList<>());
                    }
                    List<Integer> ans = nodeToIndexListMap.get(node);
                    if (!ans.contains(index)) {
                        ans.add(index);
                    }
                }
            }

            // 所有加入的子串中，有几个是以pre作为前缀的
            public List<Integer> prefix(String pre) {
                if (pre == null) {
                    return new ArrayList<>();
                }
                char[] chs = pre.toCharArray();
                Node node = root;
                int path = 0;
                for (int i = 0; i < chs.length; i++) {
                    path = chs[i];
                    if (!node.nexts.containsKey(path)) {
                        return new ArrayList<>();
                    }
                    node = node.nexts.get(path);
                }
                return nodeToIndexListMap.get(node);
            }

        }

    }

    // 方法一：暴力解，枚举所有子串，时间复杂度O(M * N²)，M为字典大小
    class Typeahead2 {

        // key:子串，value：原始串列表
        Map<String, Set<String>> substrToWordMap;

        public Typeahead2(Set<String> dict) {
            this.substrToWordMap = new HashMap<>();
            for (String word : dict) {
                addSubStringToMap(word, substrToWordMap);
            }
        }

        private void addSubStringToMap(String word, Map<String, Set<String>> substrToWordMap) {
            // 枚举所有子串，并添加进substrToWordMap
            for (int start = 0; start < word.length(); start++) {
                for (int end = start; end < word.length(); end++) {
                    String substr = word.substring(start, end + 1);
                    Set<String> wordSet = substrToWordMap.getOrDefault(substr, new TreeSet());
                    wordSet.add(word);
                    substrToWordMap.put(substr, wordSet);
                }
            }
        }

        public List<String> search(String str) {
            List<String> resList = new ArrayList<>();
            if (!substrToWordMap.containsKey(str)) {
                return resList;
            }
            Set<String> wordList = substrToWordMap.get(str);
            resList.addAll(wordList);
            return resList;
        }
    }

}
