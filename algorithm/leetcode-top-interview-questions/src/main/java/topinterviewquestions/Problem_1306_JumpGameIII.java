package topinterviewquestions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Mark
 * @date 2022/3/11 19:38
 */
public class Problem_1306_JumpGameIII {

    // 跳跃游戏 III：https://leetcode.com/problems/jump-game-iii/
    public static boolean canReach(int[] arr, int start) {
        if (arr == null || start < 0 || start > arr.length - 1) {
            return false;
        }
        Queue<Integer> queue = new LinkedList<>();
        HashMap<Integer, Integer> levelMap = new HashMap<>();
        queue.add(start);
        levelMap.put(start, 0);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int level = levelMap.get(cur);
            if (cur + arr[cur] < arr.length && arr[cur + arr[cur]] == 0) {
                return true;
            } else {
                int left = cur - arr[cur];
                if (left >= 0 && !levelMap.containsKey(left)) {
                    queue.add(left);
                    levelMap.put(left, level + 1);
                }
                int right = cur + arr[cur];
                if (right < arr.length && !levelMap.containsKey(right)) {
                    queue.add(right);
                    levelMap.put(right, level + 1);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1};
        System.out.println(canReach(arr, 1));
    }

}
