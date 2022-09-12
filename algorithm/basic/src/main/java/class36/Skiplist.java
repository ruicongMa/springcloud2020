package class36;

import java.util.ArrayList;

/**
 * @author Mark
 * @date 2022/3/7 15:03
 */
public class Skiplist {

    SkipListMap<Integer, Integer> skipListMap;

    public Skiplist() {
        this.skipListMap = new SkipListMap<>();
    }

    public boolean search(int target) {
        return skipListMap.containsKey(target);
    }

    public void add(int num) {
        skipListMap.put(num, num);
    }

    public boolean erase(int num) {
        if (!skipListMap.containsKey(num)) {
            return false;
        }
        skipListMap.remove(num);
        return true;
    }

    // 跳表的节点定义
    public static class SkipListNode<K extends Comparable<K>, V> {
        public K key;
        public V val;
        public ArrayList<SkipListNode<K, V>> nextNodes;

        public SkipListNode(K k, V v) {
            key = k;
            val = v;
            nextNodes = new ArrayList<>();
        }

        // 遍历的时候，如果是往右遍历到的null(next == null), 遍历结束
        // 头(null), 头节点的null，认为最小
        // node  -> 头，node(null, "")  node.isKeyLess(!null)  true
        // node里面的key是否比otherKey小，true，不是false
        public boolean isKeyLess(K otherKey) {
            //  otherKey == null -> false
            return otherKey != null && (key == null || key.compareTo(otherKey) < 0);
        }

        public boolean isKeyEqual(K otherKey) {
            return (key == null && otherKey == null)
                    || (key != null && otherKey != null && key.compareTo(otherKey) == 0);
        }

    }

    public static class SkipListMap<K extends Comparable<K>, V> {

        private static final double PROBABILITY = 0.5; // < 0.5 继续做，>=0.5 停
        private SkipListNode<K, V> head;
        private int maxLevel;

        public SkipListMap() {
            head = new SkipListNode<>(null, null);
            head.nextNodes.add(null); // 0
            maxLevel = 0;
        }

        // 从最高层开始，一路找下去，
        // 最终，找到第0层的<key的最右的节点
        private SkipListNode<K, V> mostRightLessNodeInTree(K key) {
            if (key == null) {
                return null;
            }
            int level = maxLevel;
            SkipListNode<K, V> cur = head;
            while (level >= 0) { // 从上层跳下层
                //  cur  level  -> level-1
                cur = mostRightLessNodeInLevel(key, cur, level--);
            }
            return cur;
        }

        // 在level层里，如何往右移动
        // 现在来到的节点是cur，来到了cur的level层，在level层上，找到<key最后一个节点并返回
        private SkipListNode<K, V> mostRightLessNodeInLevel(K key,
                                                            SkipListNode<K, V> cur,
                                                            int level) {
            SkipListNode<K, V> next = cur.nextNodes.get(level);
            while (next != null && next.isKeyLess(key)) {
                cur = next;
                next = cur.nextNodes.get(level);
            }
            return cur;
        }

        public boolean containsKey(K key) {
            if (key == null) {
                return false;
            }
            SkipListNode<K, V> less = mostRightLessNodeInTree(key);
            SkipListNode<K, V> next = less.nextNodes.get(0);
            return next != null && next.isKeyEqual(key);
        }

        // 新增、改value
        public void put(K key, V value) {
            if (key == null) {
                return;
            }
            // 0层上，最右一个，< key 的Node -> >key
            SkipListNode<K, V> less = mostRightLessNodeInTree(key);
            SkipListNode<K, V> find = less.nextNodes.get(0);
            if (find != null && find.isKeyEqual(key)) {
                // find.val = value;
                // 处理重复值问题，如果没有不允许重复，直接更新value即可，下边三行代码可以不写
                SkipListNode<K, V> newNode = new SkipListNode<>(key, value);
                newNode.nextNodes.add(find.nextNodes.get(0));
                find.nextNodes.set(0, newNode);
            } else { // find == null   8   7   9
                int newNodeLevel = 0;
                while (Math.random() < PROBABILITY) {
                    newNodeLevel++;
                }
                // newNodeLevel
                while (newNodeLevel > maxLevel) {
                    head.nextNodes.add(null);
                    maxLevel++;
                }
                SkipListNode<K, V> newNode = new SkipListNode<>(key, value);
                for (int i = 0; i <= newNodeLevel; i++) {
                    newNode.nextNodes.add(null);
                }
                int level = maxLevel;
                SkipListNode<K, V> pre = head;
                while (level >= 0) {
                    // level 层中，找到最右的 < key 的节点
                    pre = mostRightLessNodeInLevel(key, pre, level);
                    if (level <= newNodeLevel) {
                        newNode.nextNodes.set(level, pre.nextNodes.get(level));
                        pre.nextNodes.set(level, newNode);
                    }
                    level--;
                }
            }
        }

        public V get(K key) {
            if (key == null) {
                return null;
            }
            SkipListNode<K, V> less = mostRightLessNodeInTree(key);
            SkipListNode<K, V> next = less.nextNodes.get(0);
            return next != null && next.isKeyEqual(key) ? next.val : null;
        }

        public void remove(K key) {
            if (containsKey(key)) {
                int level = maxLevel;
                SkipListNode<K, V> pre = head;
                while (level >= 0) {
                    pre = mostRightLessNodeInLevel(key, pre, level);
                    SkipListNode<K, V> next = pre.nextNodes.get(level);
                    // 1）在这一层中，pre下一个就是key
                    // 2）在这一层中，pre的下一个key是>要删除key
                    if (next != null && next.isKeyEqual(key)) {
                        // free delete node memory -> C++
                        // level : pre -> next(key) -> ...
                        pre.nextNodes.set(level, next.nextNodes.get(level));
                    }
                    // 在level层只有一个节点了，就是默认节点head
                    if (level != 0 && pre == head && pre.nextNodes.get(level) == null) {
                        head.nextNodes.remove(level);
                        maxLevel--;
                    }
                    level--;
                }
            }
        }
    }
}
