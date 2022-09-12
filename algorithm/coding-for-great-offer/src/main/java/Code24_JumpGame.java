import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Mark
 * @date 2022/1/27 14:47
 */
public class Code24_JumpGame {

    // 本题测试链接 : https://leetcode.com/problems/jump-game-ii/

    public static int jump(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int step = 0;
        int cur = 0;
        int next = 0;
        for (int i = 0; i < arr.length; i++) {
            if (cur < i) { // cover不住，增加步数step
                step++;
                cur = next;
            }
            next = Math.max(next, i + arr[i]);
        }
        return step;
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        priorityQueue.add(9);
        priorityQueue.add(2);
        priorityQueue.add(3);
        priorityQueue.add(1);
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }
    }
}
