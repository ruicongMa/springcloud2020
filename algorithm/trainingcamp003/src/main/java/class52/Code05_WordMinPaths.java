package class52;

import java.util.*;

/**
 * @author Mark
 * @date 2022/4/13 10:40
 */
public class Code05_WordMinPaths {

    // 字符串最短的变换路径

    /**
     * 给定两个字符串，记为start和to，再给定一个字符串列表list，list中一定包含to，list中没有重复字符串，所有的字符串都是小写的。
     * 规定: start每次只能改变一个字符，最终的目标是彻底变成to，但是每次变成的新字符串必须在list 中存在。
     * 请返回所有最短的变换路径。
     * 【举例】
     * start="abc",end="cab",list={"cab","acc","cbc","ccc","cac","cbb","aab","abb"}
     * 转换路径的方法有很多种，但所有最短的转换路径如下:
     * abc -> abb -> aab -> cab
     * abc -> abb -> cbb -> cab
     * abc -> cbc -> cac -> cab
     * abc -> cbc -> cbb -> cab
     */
    public static List<List<String>> findMinPaths(String start, String end, List<String> list) {
        list.add(start);
        // 生成所有字符串的邻居表，脑海里有这种图了
        HashMap<String, ArrayList<String>> nexts = getNexts(list);
        // 宽度优先遍历：任何字符串到start的距离，key：list中的任何字符串，value：字符串到start的距离
        HashMap<String, Integer> distances = getDistances(start, nexts);
        LinkedList<String> pathList = new LinkedList<>();
        List<List<String>> res = new ArrayList<>();
        // 深度优先遍历
        getShortestPaths(start, end, nexts, distances, pathList, res);
        return res;
    }

    // 根据list生成所有字符串对应的邻居表
    public static HashMap<String, ArrayList<String>> getNexts(List<String> words) {
        Set<String> dict = new HashSet<>(words); // List 所有东西放入 set
        HashMap<String, ArrayList<String>> nexts = new HashMap<>();
        for (int i = 0; i < words.size(); i++) {
            nexts.put(words.get(i), getNext(words.get(i), dict));
        }
        return nexts;
    }

    // 枚举字符串在字典中的所有邻居字符串
    private static ArrayList<String> getNext(String word, Set<String> dict) {
        ArrayList<String> res = new ArrayList<>();
        char[] chs = word.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            for (char cur = 'a'; cur <= 'z'; cur++) {
                if (chs[i] != cur) {
                    char tmp = chs[i];
                    chs[i] = cur;
                    if (dict.contains(String.valueOf(chs))) {
                        res.add(String.valueOf(chs));
                    }
                    chs[i] = tmp;
                }
            }
        }
        return res;
    }

    // 宽度优先遍历
    public static HashMap<String, Integer> getDistances(String start, HashMap<String, ArrayList<String>> nexts) {
        HashMap<String, Integer> distances = new HashMap<>();
        distances.put(start, 0);
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        HashSet<String> set = new HashSet<>();
        set.add(start);
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            for (String next : nexts.get(cur)) {
                if (!set.contains(next)) {
                    distances.put(next, distances.get(cur) + 1);
                    queue.add(next);
                    set.add(next);
                }
            }
        }
        return distances;
    }

    // 现在来到了什么：cur
    // 目的地：end
    // 邻居表：nexts
    // 最短距离表：distances
    // 沿途走过的路径：path上{....}
    // 答案往res里放，收集所有的最短路径
    private static void getShortestPaths(
            String cur, String to,
            HashMap<String, ArrayList<String>> nexts,
            HashMap<String, Integer> distances,
            LinkedList<String> path,
            List<List<String>> res) {

        path.add(cur);
        if (cur.equals(to)) { // base case 终于到目的地了，把路径添加进去
            res.add(new LinkedList<>(path));
        } else {
            for (String next : nexts.get(cur)) {
                if (distances.get(next) == distances.get(cur) + 1) {
                    getShortestPaths(next, to, nexts, distances, path, res);
                }
            }
        }
        // 深度优先遍历擦除现场
        path.pollLast();
    }

    public static void main(String[] args) {
        String start = "abc";
        String end = "cab";
        String[] test = {"abc", "cab", "acc", "cbc", "ccc", "cac", "cbb", "aab", "abb"};
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < test.length; i++) {
            list.add(test[i]);
        }
        List<List<String>> res = findMinPaths(start, end, list);
        for (List<String> obj : res) {
            for (String str : obj) {
                System.out.print(str + " -> ");
            }
            System.out.println();
        }
        /**
         * abc -> abb -> aab -> cab ->
         * abc -> abb -> cbb -> cab ->
         * abc -> cbc -> cac -> cab ->
         * abc -> cbc -> cbb -> cab ->
         */
    }
}
