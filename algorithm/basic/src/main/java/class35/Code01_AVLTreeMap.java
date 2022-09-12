package class35;

/**
 * @author Mark
 * @date 2022/3/6 17:49
 */
public class Code01_AVLTreeMap {

    public static class AVLNode<K extends Comparable<K>, V> {
        public K k;
        public V v;
        public AVLNode<K, V> l;
        public AVLNode<K, V> r;
        public int h;

        public AVLNode(K key, V value) {
            k = key;
            v = value;
            h = 1;
        }
    }

    public static class AVLTreeMap<K extends Comparable<K>, V> {
        private AVLNode<K, V> root;
        private int size;

        public AVLTreeMap() {
            root = null;
            size = 0;
        }

        // 右旋
        private AVLNode<K, V> rightRotate(AVLNode<K, V> cur) {
            AVLNode<K, V> left = cur.l;
            cur.l = left.r;
            left.r = cur;
            cur.h = Math.max((cur.l != null ? cur.l.h : 0), (cur.r != null ? cur.r.h : 0)) + 1;
            left.h = Math.max((left.l != null ? left.l.h : 0), (left.r != null ? left.r.h : 0)) + 1;
            return left;
        }

        // 左旋
        private AVLNode<K, V> leftRotate(AVLNode<K, V> cur) {
            AVLNode<K, V> right = cur.r;
            cur.r = right.l;
            right.l = cur;
            cur.h = Math.max((cur.l != null ? cur.l.h : 0), (cur.r != null ? cur.r.h : 0)) + 1;
            right.h = Math.max((right.l != null ? right.l.h : 0), (right.r != null ? right.r.h : 0)) + 1;
            return right;
        }

        // 调整平衡性：添加、删除
        private AVLNode<K, V> maintain(AVLNode<K, V> cur) {
            if (cur == null) {
                return null;
            }
            int leftHeight = cur.l != null ? cur.l.h : 0;
            int rightHeight = cur.r != null ? cur.r.h : 0;
            if (Math.abs(leftHeight - rightHeight) > 1) {
                if (leftHeight > rightHeight) {
                    int leftLeftHeight = cur.l != null && cur.l.l != null ? cur.l.l.h : 0;
                    int leftRightHeight = cur.l != null && cur.l.r != null ? cur.l.r.h : 0;
                    if (leftLeftHeight < leftRightHeight) { // LR型（先左旋，后右旋）
                        cur.l = leftRotate(cur.l); // 左旋
                    }
                    cur = rightRotate(cur); // 右旋（LL型，只右旋）
                } else {
                    int rightLeftHeight = cur.r != null && cur.r.l != null ? cur.r.l.h : 0;
                    int rightRightHeight = cur.r != null && cur.r.r != null ? cur.r.r.h : 0;
                    if (rightRightHeight < rightLeftHeight) { // RL型（先右旋，后左旋）
                        cur.r = rightRotate(cur.r); // 右旋
                    }
                    cur = leftRotate(cur); // 左旋（RR型，只左旋）
                }
            }
            return cur;
        }

        // 查找最近的
        private AVLNode<K, V> findLastIndex(K key) {
            AVLNode<K, V> pre = root;
            AVLNode<K, V> cur = root;
            while (cur != null) {
                pre = cur;
                if (key.compareTo(cur.k) == 0) {
                    break;
                } else if (key.compareTo(cur.k) < 0) {
                    cur = cur.l;
                } else {
                    cur = cur.r;
                }
            }
            return pre;
        }

        // ≥ key 最近的
        private AVLNode<K, V> findLastNoSmallIndex(K key) {
            AVLNode<K, V> ans = null;
            AVLNode<K, V> cur = root;
            while (cur != null) {
                if (key.compareTo(cur.k) == 0) {
                    ans = cur;
                    break;
                } else if (key.compareTo(cur.k) < 0) {
                    ans = cur;
                    cur = cur.l;
                } else {
                    cur = cur.r;
                }
            }
            return ans;
        }

        // ≤ key 最近的
        private AVLNode<K, V> findLastNoBigIndex(K key) {
            AVLNode<K, V> ans = null;
            AVLNode<K, V> cur = root;
            while (cur != null) {
                if (key.compareTo(cur.k) == 0) {
                    ans = cur;
                    break;
                } else if (key.compareTo(cur.k) < 0) {
                    cur = cur.l;
                } else {
                    ans = cur;
                    cur = cur.r;
                }
            }
            return ans;
        }

        private AVLNode<K, V> add(AVLNode<K, V> cur, K key, V value) {
            if (cur == null) {
                return new AVLNode<K, V>(key, value);
            }
            if (key.compareTo(cur.k) < 0) {
                cur.l = add(cur.l, key, value); // 有可能cur的left存在换头的情况
            } else {
                cur.r = add(cur.r, key, value); // 有可能cur的right存在换头的情况
            }
            // 调整当前节点树的高度
            cur.h = Math.max(cur.l != null ? cur.l.h : 0, cur.r != null ? cur.r.h : 0) + 1;
            return maintain(cur); // 调整平衡性
        }

        // 在cur这棵树上，删掉key所代表的节点
        // 返回cur这棵树的新头部
        private AVLNode<K, V> delete(AVLNode<K, V> cur, K key) {
            if (key.compareTo(cur.k) > 0) { // 去右边删
                cur.r = delete(cur.r, key);
            } else if (key.compareTo(cur.k) < 0) { // 去左边删
                cur.l = delete(cur.l, key);
            } else {
                if (cur.l == null && cur.r == null) { // 当前节点无左节点和右节点
                    cur = null;
                } else if (cur.l == null && cur.r != null) { // 当前节点无左节点，有右节点
                    cur = cur.r;
                } else if (cur.l != null && cur.r == null) { // 当前节点有左节点，无右节点
                    cur = cur.l;
                } else { // 当前节点有左节点和右节点
                    AVLNode<K, V> des = cur.r;
                    while (des.l != null) { // 找到cur的右节点的最左节点
                        des = des.l;
                    }
                    cur.r = delete(cur.r, des.k); // 从cur的右节点开始，删除cur的右节点的最左节点，调完平衡性
                    des.l = cur.l;
                    des.r = cur.r;
                    cur = des;
                }
            }
            if (cur != null) { // 调整当前节点树的高度
                cur.h = Math.max(cur.l != null ? cur.l.h : 0, cur.r != null ? cur.r.h : 0) + 1;
            }
            return maintain(cur); // 调整平衡性
        }

        public int size() {
            return size;
        }

        public boolean containsKey(K key) {
            if (key == null) {
                return false;
            }
            AVLNode<K, V> lastNode = findLastIndex(key);
            return lastNode != null && key.compareTo(lastNode.k) == 0 ? true : false;
        }

        // 添加节点
        public void put(K key, V value) {
            if (key == null) {
                return;
            }
            AVLNode<K, V> lastNode = findLastIndex(key);
            if (lastNode != null && key.compareTo(lastNode.k) == 0) { // 找到，则更新
                lastNode.v = value;
            } else { // 没找到，则添加
                size++;
                root = add(root, key, value);
            }
        }

        // 删除节点
        public void remove(K key) {
            if (key == null) {
                return;
            }
            if (containsKey(key)) {
                size--;
                root = delete(root, key);
            }
        }

        // 获取节点
        public V get(K key) {
            if (key == null) {
                return null;
            }
            AVLNode<K, V> lastNode = findLastIndex(key);
            if (lastNode != null && key.compareTo(lastNode.k) == 0) {
                return lastNode.v;
            }
            return null;
        }

        public K firstKey() {
            if (root == null) {
                return null;
            }
            AVLNode<K, V> cur = root;
            while (cur.l != null) {
                cur = cur.l;
            }
            return cur.k;
        }

        public K lastKey() {
            if (root == null) {
                return null;
            }
            AVLNode<K, V> cur = root;
            while (cur.r != null) {
                cur = cur.r;
            }
            return cur.k;
        }

        public K floorKey(K key) {
            if (key == null) {
                return null;
            }
            AVLNode<K, V> lastNoBigNode = findLastNoBigIndex(key);
            return lastNoBigNode == null ? null : lastNoBigNode.k;
        }

        public K ceilingKey(K key) {
            if (key == null) {
                return null;
            }
            AVLNode<K, V> lastNoSmallNode = findLastNoSmallIndex(key);
            return lastNoSmallNode == null ? null : lastNoSmallNode.k;
        }

    }
}
