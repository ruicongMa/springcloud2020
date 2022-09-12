import java.util.ArrayList;

/**
 * 点
 *
 * @author Mark
 * @date 2021/8/25 21:45
 */
public class Node {
    int value;
    int in;
    int out;
    ArrayList<Node> nexts;
    ArrayList<Edge> edges;

    public Node(int value) {
        this.value = value;
        this.in = 0;
        this.out = 0;
        this.nexts = new ArrayList<>();
        this.edges = new ArrayList<>();
    }
}
