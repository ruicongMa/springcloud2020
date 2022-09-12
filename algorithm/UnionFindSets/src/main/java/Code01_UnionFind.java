import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * 并查集基本结构
 *
 * @author Mark
 * @date 2021/8/23 15:05
 */
public class Code01_UnionFind {

    public static class Node<V> {
        V value;

        public Node(V value) {
            this.value = value;
        }
    }

    public static class UnionFind<V> {
        HashMap<V, Node<V>> nodes;
        HashMap<Node<V>, Node<V>> parents;
        HashMap<Node<V>, Integer> sizeMap;

        public UnionFind(List<V> values) {
            this.nodes = new HashMap<>();
            this.parents = new HashMap<>();
            this.sizeMap = new HashMap<>();
            for (V value : values) {
                Node<V> node = new Node<>(value);
                this.nodes.put(value, node);
                this.parents.put(node, node);
                this.sizeMap.put(node, 1);
            }
        }

        public Node<V> findFather(Node<V> cur) {
            Stack<Node> path = new Stack<>();
            while (cur != parents.get(cur)) {
                path.push(cur);
                cur = parents.get(cur);
            }
            while (!path.isEmpty()) {
                parents.put(path.pop(), cur);
            }
            return cur;
        }

        public boolean isSameSet(V a, V b) {
            return findFather(nodes.get(a)) == findFather(nodes.get(b));
        }

        public void union(V a, V b) {
            Node<V> aHead = findFather(nodes.get(a));
            Node<V> bHead = findFather(nodes.get(b));
            if (aHead != bHead) {
                Integer aSize = sizeMap.get(aHead);
                Integer bSize = sizeMap.get(bHead);
                Node<V> big = aSize >= bSize ? aHead : bHead;
                Node<V> small = big == aHead ? bHead : aHead;
                parents.put(small, big);
                sizeMap.put(big, aSize + bSize);
                sizeMap.remove(small);
            }
        }

        public int sets() {
            return sizeMap.size();
        }
    }


    public static void main(String[] args) {
        List<String> values = Arrays.asList("a", "b", "c", "d", "e", "f");
        UnionFind<String> unionFind = new UnionFind<>(values);
        unionFind.union("a", "b");
        unionFind.union("a", "c");

        unionFind.union("d", "e");
        unionFind.union("e", "f");

        unionFind.union("a", "d");
    }

}
