package class16;

/**
 * @author Mark
 * @date 2022/2/21 17:44
 */
// 边的定义模型
public class Edge {

    public int weight;
    public Node from;
    public Node to;

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
