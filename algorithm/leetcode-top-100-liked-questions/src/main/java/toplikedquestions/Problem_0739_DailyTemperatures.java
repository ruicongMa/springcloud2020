package toplikedquestions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Mark
 * @date 2022/4/5 15:22
 */
public class Problem_0739_DailyTemperatures {

    // 每日温度：https://leetcode.com/problems/daily-temperatures/
    public static int[] dailyTemperatures(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }
        int N = arr.length;
        int[] ans = new int[N];
        Stack<List<Integer>> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && arr[stack.peek().get(0)] < arr[i]) {
                List<Integer> popIs = stack.pop();
                for (Integer popi : popIs) {
                    ans[popi] = i - popi;
                }
            }
            if (!stack.isEmpty() && arr[stack.peek().get(0)] == arr[i]) {
                stack.peek().add(Integer.valueOf(i));
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                stack.push(list);
            }
        }
        return ans;
    }
}
