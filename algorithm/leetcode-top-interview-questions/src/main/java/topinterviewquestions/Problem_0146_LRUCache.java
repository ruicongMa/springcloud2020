package topinterviewquestions;

import java.util.HashMap;

/**
 * @author Mark
 * @date 2022/3/25 14:07
 */
public class Problem_0146_LRUCache {

    /*
     * 在leetcode上提交时，把文字替换成下面的代码
     * 然后把类名、构造方法名从Problem_0146_LRUCache改为LRUCache即可
     */
    // LRU 缓存：https://leetcode.com/problems/lru-cache/
    private MyCache<Integer, Integer> cache;

    public Problem_0146_LRUCache(int capacity) {
        cache = new MyCache<>(capacity);
    }

    public int get(int key) {
        Integer ans = cache.get(key);
        return ans == null ? -1 : ans;
    }

    public void put(int key, int value) {
        cache.set(key, value);
    }

    // 节点结构
    public static class Node<K, V> {
        public K key;
        public V value;
        public Node<K, V> pre;
        public Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // 双向链表结构
    public static class NodeDoubleLinkedList<K, V> {
        private Node<K, V> head;
        private Node<K, V> tail;

        public NodeDoubleLinkedList() {
            head = null;
            tail = null;
        }

        // 尾部添加节点
        public void addNode(Node<K, V> newNode) {
            if (newNode == null) {
                return;
            }
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                newNode.pre = tail;
                tail = newNode;
            }
        }

        // 把链表上的节点移动到尾部
        public void moveNodeToTail(Node<K, V> node) {
            if (tail == node) {
                return;
            }
            // node 不是尾巴
            if (head == node) {
                head = node.next;
                head.pre = null;
            } else {
                node.pre.next = node.next;
                node.next.pre = node.pre;
            }
            node.pre = tail;
            node.next = null;
            tail.next = node;
            tail = node;
        }

        // 移除头部节点
        public Node<K, V> removeHead() {
            if (head == null) {
                return null;
            }
            Node<K, V> res = head;
            if (head == tail) { // 链表中只有一个节点的时候
                head = null;
                tail = null;
            } else {
                head = res.next;
                res.next = null;
                head.pre = null;
            }
            return res;
        }

    }

    public static class MyCache<K, V> {
        private HashMap<K, Node<K, V>> keyNodeMap;
        private NodeDoubleLinkedList<K, V> nodeList;
        private final int capacity;

        public MyCache(int cap) {
            if (cap < 1) {
                throw new RuntimeException("should be more than 0.");
            }
            keyNodeMap = new HashMap<>();
            nodeList = new NodeDoubleLinkedList<>();
            capacity = cap;
        }

        public V get(K key) {
            if (keyNodeMap.containsKey(key)) {
                Node<K, V> res = keyNodeMap.get(key);
                nodeList.moveNodeToTail(res);
                return res.value;
            }
            return null;
        }

        public void set(K key, V value) {
            if (keyNodeMap.containsKey(key)) {
                Node<K, V> node = keyNodeMap.get(key);
                node.value = value;
                nodeList.moveNodeToTail(node);
            } else {
                if (keyNodeMap.size() == capacity) {
                    removeMostUnusedCache();
                }
                Node<K, V> newNode = new Node<>(key, value);
                keyNodeMap.put(key, newNode);
                nodeList.addNode(newNode);
            }
        }

        private void removeMostUnusedCache() {
            Node<K, V> removeNode = nodeList.removeHead();
            keyNodeMap.remove(removeNode.key);
        }

    }
}
