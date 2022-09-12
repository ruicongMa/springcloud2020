package class16;

import java.util.HashSet;
import java.util.Stack;

/**
 * @author Mark
 * @date 2022/2/21 19:36
 */
public class Code02_DFS {

    // 图的深度优先遍历
    public static void dfs(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();
        stack.add(node);
        set.add(node);
        System.out.println(node.value); // 入栈就打印
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            for (Node next : cur.nexts) {
                if (!set.contains(next)) {
                    stack.push(cur);
                    stack.push(next);
                    set.add(next);
                    System.out.println(next.value); // 入栈就打印
                    break;
                }
            }
        }
    }
}
