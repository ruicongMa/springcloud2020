package topinterviewquestions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Mark
 * @date 2022/3/29 23:36
 */
public class Problem_0269_AlienDictionary {

    // 火星词典：https://leetcode.com/problems/alien-dictionary
    public static String alienOrder(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        int N = words.length;
        // 字符入度统计，key：字符，value：入度数
        HashMap<Character, Integer> indegree = new HashMap<>();
        for (int i = 0; i < N; i++) {
            // 刚开始还没有发现边的时候，所有单词的字符入度都为0
            for (char c : words[i].toCharArray()) {
                indegree.put(c, 0);
            }
        }
        // 图的建立，key：字符，value：字符指向的不同字符，比如 a->b，a->c，key：a，value：{b,c}
        HashMap<Character, HashSet<Character>> graph = new HashMap<>();
        for (int i = 0; i < N - 1; i++) { // 只需要对比N-2次
            char[] cur = words[i].toCharArray(); // 当前单词
            char[] nex = words[i + 1].toCharArray(); // 下一个单词
            int len = Math.min(cur.length, nex.length);
            int j = 0;
            for (; j < len; j++) {
                if (cur[j] != nex[j]) { // 只要遇到不相同的字符就找到一条边
                    if (!graph.containsKey(cur[j])) {
                        graph.put(cur[j], new HashSet<>());
                    }
                    if (!graph.get(cur[j]).contains(nex[j])) { // 没有边才加入，有边不要重复加
                        graph.get(cur[j]).add(nex[j]);
                        indegree.put(nex[j], indegree.get(nex[j]) + 1);
                    }
                    break;
                }
            }
            // cur="abcd"，next="ab"，一定不存在字典序，cur长度要比next长，为什么要放在上边，应该放在下边
            if (j < cur.length && j == nex.length) {
                return "";
            }
        }
        StringBuilder ans = new StringBuilder();
        // 图的拓扑序惯用套路：入度为0的点先进入队列
        Queue<Character> q = new LinkedList<>();
        for (Character key : indegree.keySet()) {
            if (indegree.get(key) == 0) {
                q.offer(key);
            }
        }
        while (!q.isEmpty()) {
            char cur = q.poll();
            ans.append(cur);
            if (graph.containsKey(cur)) {
                // 遍历所有边
                for (char next : graph.get(cur)) {
                    indegree.put(next, indegree.get(next) - 1);
                    if (indegree.get(next) == 0) {
                        q.offer(next);
                    }
                }
            }
        }
        return ans.length() == indegree.size() ? ans.toString() : "";
    }

    public static void main(String[] args) {
        String[] words = {"zy", "zx"};
        System.out.println(alienOrder(words));
    }
}
