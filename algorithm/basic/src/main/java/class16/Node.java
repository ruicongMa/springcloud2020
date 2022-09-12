package class16;

import java.util.ArrayList;

/**
 * @author Mark
 * @date 2022/2/21 17:44
 */
// 点（节点）的定义模型
public class Node {

    public int value;
    public int in; // 哪些节点指向它的个数
    public int out; // 它指向哪些节点的个数
    public ArrayList<Node> nexts; // 它指向的节点（邻居）
    public ArrayList<Edge> edges; // 它指向的节点（邻居）所用的边

    public Node(int value) {
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}
