package topinterviewquestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Mark
 * @date 2022/3/27 22:22
 */
public class Problem_0207_CourseSchedule {

    // 课程表：https://leetcode.com/problems/course-schedule/
    // 一个node，就是一个课程
    // name是课程的编号
    // in是课程的入度
    // 图的拓扑结构
    public static class Node {
        public int name;
        public int in;
        public ArrayList<Node> nexts;

        public Node(int n) {
            name = n;
            in = 0;
            nexts = new ArrayList<>();
        }
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) {
            return true;
        }
        // key：课程的编号，value：课程Node
        HashMap<Integer, Node> nodes = new HashMap<>(); // 存放课程的依赖关系
        for (int[] arr : prerequisites) { // 构建图的拓扑结构
            int to = arr[0];
            int from = arr[1];
            if (!nodes.containsKey(to)) {
                nodes.put(to, new Node(to));
            }
            if (!nodes.containsKey(from)) {
                nodes.put(from, new Node(from));
            }
            Node t = nodes.get(to);
            Node f = nodes.get(from);
            f.nexts.add(t);
            t.in++;
        }
        int needPrerequisiteNums = nodes.size();
        Queue<Node> zeroInQueue = new LinkedList<>();
        for (Node node : nodes.values()) {
            if (node.in == 0) { // 依次入度为0的课进队列
                zeroInQueue.add(node);
            }
        }
        int count = 0;
        while (!zeroInQueue.isEmpty()) { // 依次入度为0的课出队列
            Node cur = zeroInQueue.poll();
            count++;
            for (Node next : cur.nexts) {
                if (--next.in == 0) {
                    zeroInQueue.add(next);
                }
            }
        }
        // 只要不相等，则说明存在循环依赖的课
        return count == needPrerequisiteNums;
    }
}
