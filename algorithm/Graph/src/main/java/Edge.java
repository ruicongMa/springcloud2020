/**
 * 边
 *
 * @author Mark
 * @date 2021/8/25 21:47
 */
public class Edge {
    int weight;
    Node from;
    Node to;

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }

}
