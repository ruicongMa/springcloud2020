import java.util.HashMap;
import java.util.HashSet;

/**
 * 图
 *
 * @author Mark
 * @date 2021/8/25 21:49
 */
public class Graph {
    HashMap<Integer, Node> nodes;
    HashSet<Edge> edges;

    public Graph() {
        this.nodes = new HashMap<>();
        this.edges = new HashSet<>();
    }
}
