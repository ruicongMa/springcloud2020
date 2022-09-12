package toplikedquestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Mark
 * @date 2022/4/3 12:48
 */
public class Problem_0438_FindAllAnagramsInAString {

    // 找到字符串中所有字母异位词：https://leetcode.com/problems/find-all-anagrams-in-a-string/
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()) {
            return ans;
        }
        char[] str = s.toCharArray();
        int N = str.length;
        char[] pst = p.toCharArray();
        int M = pst.length;
        // 词频统计，得出欠账表
        HashMap<Character, Integer> map = new HashMap<>();
        for (char cha : pst) {
            if (!map.containsKey(cha)) {
                map.put(cha, 1);
            } else {
                map.put(cha, map.get(cha) + 1);
            }
        }
        int all = M; // 总记账数
        for (int end = 0; end < M - 1; end++) { // 窗口先形成 0~M-2 规模
            if (map.containsKey(str[end])) {
                int count = map.get(str[end]);
                if (count > 0) {
                    all--;
                }
                map.put(str[end], count - 1);
            }
        }
        for (int end = M - 1, start = 0; end < N; end++, start++) { // 窗口从M-1开始往右滑
            if (map.containsKey(str[end])) {
                int count = map.get(str[end]);
                if (count > 0) {
                    all--;
                }
                map.put(str[end], count - 1);
            }
            if (all == 0) {
                ans.add(start);
            }
            if (map.containsKey(str[start])) { // start在出窗口前，需要把字符还回来
                int count = map.get(str[start]);
                if (count >= 0) { // 只有总记录数大于等于0才更新
                    all++;
                }
                map.put(str[start], count + 1);
            }
        }
        return ans;
    }
}
