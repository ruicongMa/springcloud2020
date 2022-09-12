package class16;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Mark
 * @date 2022/2/21 17:45
 */
// 图的定义模型
public class Graph {

    public HashMap<Integer, Node> nodes; // 点
    public HashSet<Edge> edges; // 边

    public Graph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}
