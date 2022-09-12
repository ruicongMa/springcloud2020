package class14;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * @author Mark
 * @date 2022/2/20 22:46
 */
public class Code05_UnionFind {

    // 并查集的定义

    /**
     * 并查集的定义：
     * <p>
     * 1. 有若干个样本a、b、c、d…类型假设是V
     * <p>
     * 2. 在并查集中一开始认为每个样本都在单独的集合里
     * <p>
     * 3. 用户可以在任何时候调用如下两个方法：
     * <p>
     * boolean isSameSet(V x, V y) : 查询样本x和样本y是否属于一个集合
     * <p>
     * void union(V x, V y) : 把x和y各自所在集合的所有样本合并成一个集合
     * <p>
     * 4. isSameSet和union方法的代价越低越好
     */
    public static class Node<V> {
        V value;

        public Node(V v) {
            value = v;
        }
    }

    // HashMap实现的并查集
    public static class UnionFind<V> {
        public HashMap<V, Node<V>> nodes;
        public HashMap<Node<V>, Node<V>> parents;
        public HashMap<Node<V>, Integer> sizeMap;

        public UnionFind(List<V> values) {
            nodes = new HashMap<>();
            parents = new HashMap<>();
            sizeMap = new HashMap<>();
            for (V cur : values) {
                Node<V> node = new Node<>(cur);
                nodes.put(cur, node);
                parents.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        // 给你一个节点，请你往上到不能再往上，把代表返回
        private Node<V> findFather(Node<V> cur) {
            Stack<Node<V>> path = new Stack<>();
            while (cur != parents.get(cur)) {
                path.push(cur);
                cur = parents.get(cur);
            }
            while (!path.isEmpty()) {
                parents.put(path.pop(), cur);
            }
            return cur;
        }

        // 是否在同一个集合里
        public boolean isSameSet(V a, V b) {
            return findFather(nodes.get(a)) == findFather(nodes.get(b));
        }

        // 合并两个集合
        public void union(V a, V b) {
            Node<V> aHead = findFather(nodes.get(a));
            Node<V> bHead = findFather(nodes.get(b));
            if (aHead != bHead) {
                int aSetSize = sizeMap.get(aHead);
                int bSetSize = sizeMap.get(bHead);
                Node<V> big = aSetSize >= bSetSize ? aHead : bHead;
                Node<V> small = big == aHead ? bHead : aHead;
                parents.put(small, big);
                sizeMap.put(big, aSetSize + bSetSize);
                sizeMap.remove(small);
            }
        }

        public int sets() {
            return sizeMap.size();
        }

    }
}
