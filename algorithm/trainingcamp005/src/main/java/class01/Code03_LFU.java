package class01;


import java.util.HashMap;

/**
 * @author Mark
 * @date 2022/5/26 15:58
 */
public class Code03_LFU {

    // 节点的数据结构
    public static class Node<K, V> {
        public K key;
        public V value;
        public Integer times; // 这个节点发生get或者set的次数总和
        public Node<K, V> up; // 节点之间是双向链表所以有上一个节点
        public Node<K, V> down;// 节点之间是双向链表所以有下一个节点

        public Node(K key, V value, int times) {
            this.key = key;
            this.value = value;
            this.times = times;
        }
    }

    // 桶结构
    public static class NodeList<K, V> {
        public Node<K, V> head; // 桶的头节点
        public Node<K, V> tail; // 桶的尾节点
        public NodeList<K, V> pre; // 桶之间是双向链表所以有前一个桶
        public NodeList<K, V> next; // 桶之间是双向链表所以有后一个桶

        public NodeList(Node<K, V> node) {
            this.head = node;
            this.tail = node;
        }

        // 把一个新的节点加入这个桶，新的节点都放在顶端变成新的头部
        public void addNodeFromHead(Node<K, V> newHead) {
            newHead.down = head;
            head.up = newHead;
            head = newHead;
        }

        // 判断这个桶是不是空的
        public boolean isEmpty() {
            return head == null;
        }

        // 删除node节点并保证node的上下环境重新连接
        public void deleteNode(Node<K, V> node) {
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                if (node == head) {
                    head = node.down;
                    head.up = null;
                } else if (node == tail) {
                    tail = node.up;
                    tail.down = null;
                } else {
                    node.up.down = node.down;
                    node.down.up = node.up;
                }
            }
            node.up = null;
            node.down = null;
        }
    }

    // 总的缓存结构
    public static class MyLFUCache<K, V> {
        private int capacity; // 缓存的大小限制，即K
        private int size; // 缓存目前有多少个节点
        private HashMap<K, Node<K, V>> records;// 表示key(Integer)由哪个节点(Node)代表
        private HashMap<Node<K, V>, NodeList<K, V>> heads; // 表示节点(Node)在哪个桶(NodeList)里
        private NodeList<K, V> headList; // 整个结构中位于最左的桶

        public MyLFUCache(int K) {
            this.capacity = K;
            this.size = 0;
            this.records = new HashMap<>();
            this.heads = new HashMap<>();
            headList = null;
        }

        // removeNodeList：刚刚减少了一个节点的桶
        // 这个函数的功能是，判断刚刚减少了一个节点的桶是不是已经空了。
        // 1）如果不空，什么也不做
        //
        // 2)如果空了，removeNodeList还是整个缓存结构最左的桶(headList)。
        // 删掉这个桶的同时也要让最左的桶变成removeNodeList的下一个。
        //
        // 3)如果空了，removeNodeList不是整个缓存结构最左的桶(headList)。
        // 把这个桶删除，并保证上一个的桶和下一个桶之间还是双向链表的连接方式
        //
        // 函数的返回值表示刚刚减少了一个节点的桶是不是已经空了，空了返回true；不空返回false
        private boolean modifyHeadList(NodeList<K, V> removeNodeList) {
            if (removeNodeList.isEmpty()) {
                if (headList == removeNodeList) {
                    headList = removeNodeList.next;
                    if (headList != null) {
                        headList.pre = null;
                    }
                } else {
                    removeNodeList.pre.next = removeNodeList.next;
                    if (removeNodeList.next != null) {
                        removeNodeList.next.pre = removeNodeList.pre;
                    }
                }
                return true;
            }
            return false;
        }

        // 函数的功能
        // node这个节点的次数+1了，这个节点原来在oldNodeList里。
        // 把node从oldNodeList删掉，然后放到次数+1的桶中
        // 整个过程既要保证桶之间仍然是双向链表，也要保证节点之间仍然是双向链表
        private void move(Node<K, V> node, NodeList<K, V> oldNodeList) {
            oldNodeList.deleteNode(node);
            // preList表示次数+1的桶的前一个桶是谁
            // 如果oldNodeList删掉node之后还有节点，oldNodeList就是次数+1的桶的前一个桶
            // 如果oldNodeList删掉node之后空了，oldNodeList是需要删除的，所以次数+1的桶的前一个桶，是oldNodeList的前一个
            NodeList<K, V> preList = modifyHeadList(oldNodeList) ? oldNodeList.pre
                    : oldNodeList;
            // nextList表示次数+1的桶的后一个桶是谁
            NodeList<K, V> nextList = oldNodeList.next;
            if (nextList == null) {
                NodeList<K, V> newList = new NodeList(node);
                if (preList != null) {
                    preList.next = newList;
                }
                newList.pre = preList;
                if (headList == null) {
                    headList = newList;
                }
                heads.put(node, newList);
            } else {
                if (nextList.head.times.equals(node.times)) {
                    nextList.addNodeFromHead(node);
                    heads.put(node, nextList);
                } else {
                    NodeList<K, V> newList = new NodeList(node);
                    if (preList != null) {
                        preList.next = newList;
                    }
                    newList.pre = preList;
                    newList.next = nextList;
                    nextList.pre = newList;
                    if (headList == nextList) {
                        headList = newList;
                    }
                    heads.put(node, newList);
                }
            }
        }

        public void put(K key, V value) {
            if (capacity == 0) {
                return;
            }
            if (records.containsKey(key)) {
                Node<K, V> node = records.get(key);
                node.value = value;
                node.times++;
                NodeList<K, V> curNodeList = heads.get(node);
                move(node, curNodeList);
            } else {
                if (size == capacity) {
                    Node<K, V> node = headList.tail;
                    headList.deleteNode(node);
                    modifyHeadList(headList);
                    records.remove(node.key);
                    heads.remove(node);
                    size--;
                }
                Node<K, V> node = new Node(key, value, 1);
                if (headList == null) {
                    headList = new NodeList(node);
                } else {
                    if (headList.head.times.equals(node.times)) {
                        headList.addNodeFromHead(node);
                    } else {
                        NodeList newList = new NodeList(node);
                        newList.next = headList;
                        headList.pre = newList;
                        headList = newList;
                    }
                }
                records.put(key, node);
                heads.put(node, headList);
                size++;
            }
        }

        public V get(K key) {
            if (!records.containsKey(key)) {
                return null;
            }
            Node<K, V> node = records.get(key);
            node.times++;
            NodeList<K, V> curNodeList = heads.get(node);
            move(node, curNodeList);
            return node.value;
        }

    }
}
