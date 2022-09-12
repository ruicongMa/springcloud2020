import java.util.*;

/**
 * @author Mark
 * @date 2022/4/21 20:51
 */
public class MyTest03 {

    class Typeahead {
        private final Trie trie;
        private final String[] words;

        /*
         * @param dict: A dictionary of words dict
         */
        public Typeahead(Set<String> dict) {
            this.trie = new Trie();
            this.words = new String[dict.size()];
            init(dict);
        }

        /*
         * @param str: a string
         * @return: a list of words
         */
        public List<String> search(String str) {
            List<String> result = new ArrayList<>();

            Set<Integer> ids = trie.search(str);
            for (int i : ids) {
                result.add(words[i]);
            }

            return result;
        }

        private void init(Set<String> dict) {
            int i = 0;
            for (String word : dict) {
                if (word == null || word.isEmpty()) {
                    continue;
                }

                // Build words
                words[i] = word;

                // Add to trie
                for (int j = 0; j < word.length(); ++j) {
                    String s = word.substring(j);
                    trie.insert(s, i);
                }

                ++i;
            }
        }

        private class Trie {

            private final TrieNode root;

            public Trie() {
                this.root = new TrieNode();
            }

            public void insert(String word, int id) {
                if (word == null || word.isEmpty()) {
                    return;
                }

                TrieNode parent = root;
                for (char c : word.toCharArray()) {
                    TrieNode child = parent.children.get(c);

                    if (child == null) {
                        child = new TrieNode();
                        parent.children.put(c, child);
                    }

                    child.ids.add(id);
                    parent = child;
                }
            }

            public Set<Integer> search(String word) {
                Set<Integer> ids = new HashSet<>();

                if (word == null || word.isEmpty()) {
                    return ids;
                }

                TrieNode parent = root;
                for (char c : word.toCharArray()) {
                    TrieNode child = parent.children.get(c);

                    if (child == null) {
                        return ids;
                    }

                    parent = child;
                }

                return parent.ids;
            }
        }

        private class TrieNode {
            public final Map<Character, TrieNode> children;
            public final Set<Integer> ids;

            public TrieNode() {
                this.children = new HashMap<>();
                this.ids = new HashSet<>();
            }
        }
    }

}
