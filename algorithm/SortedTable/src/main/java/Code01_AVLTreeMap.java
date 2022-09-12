/**
 * @author Mark
 * @date 2021/9/7 18:41
 */
public class Code01_AVLTreeMap {

    public static class AVLNode<K extends Comparable<K>, V> {
        K k;
        V v;
        AVLNode<K, V> l;
        AVLNode<K, V> r;
        int h;

        public AVLNode(K key, V value) {
            this.k = key;
            this.v = value;
            this.h = 1;
        }
    }

    public static class AVLTreeMap<K extends Comparable<K>, V> {
        private AVLNode<K, V> root;
        private int size;

        public AVLTreeMap() {
            root = null;
            size = 0;
        }

        private AVLNode<K, V> rightRotate(AVLNode<K, V> cur) {
            AVLNode<K, V> left = cur.l;
            cur.l = left.r;
            left.r = cur;
            cur.h = Math.max(cur.l != null ? cur.l.h : 0, cur.r != null ? cur.r.h : 0) + 1;
            left.h = Math.max(left.l != null ? left.l.h : 0, left.r != null ? left.r.h : 0) + 1;
            return left;
        }

        private AVLNode<K, V> leftRotate(AVLNode<K, V> cur) {
            AVLNode<K, V> right = cur.r;
            cur.r = right.l;
            right.l = cur;
            cur.h = Math.max(cur.l != null ? cur.l.h : 0, cur.r != null ? cur.r.h : 0) + 1;
            right.h = Math.max(right.l != null ? right.l.h : 0, right.r != null ? right.r.h : 0) + 1;
            return right;
        }

        private AVLNode<K, V> add(AVLNode<K, V> cur, K key, V value) {
            if (cur == null) {
                return new AVLNode<>(key, value);
            }
            if (key.compareTo(cur.k) < 0) {
                cur.l = add(cur.l, key, value);
            } else {
                cur.r = add(cur.r, key, value);
            }
            cur.h = Math.max(cur.l != null ? cur.l.h : 0, cur.r != null ? cur.r.h : 0) + 1;
            return maintain(cur);
        }

        private AVLNode<K, V> delete(AVLNode<K, V> cur, K key) {
            if (key.compareTo(cur.k) < 0) {
                cur.l = delete(cur.l, key);
            } else if (key.compareTo(cur.k) > 0) {
                cur.r = delete(cur.r, key);
            } else {
                if (cur.l == null && cur.r == null) {
                    cur = null;
                } else if (cur.l != null && cur.r == null) {
                    cur = cur.l;
                } else if (cur.l == null && cur.r != null) {
                    cur = cur.r;
                } else {
                    AVLNode<K, V> des = cur.r;
                    while (des.l != null) {
                        des = des.l;
                    }
                    cur.r = delete(cur.r, des.k);
                    des.l = cur.l;
                    des.r = cur.r;
                    cur = des;
                }
            }
            if (cur != null) {
                cur.h = Math.max(cur.l != null ? cur.l.h : 0, cur.r != null ? cur.r.h : 0) + 1;
            }
            return maintain(cur);
        }

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
                    if (leftLeftHeight < leftRightHeight) {
                        cur.l = leftRotate(cur.l);
                    }
                    cur = rightRotate(cur);
                } else {
                    int rightLeftHeight = cur.r != null && cur.r.l != null ? cur.r.l.h : 0;
                    int rightRightHeight = cur.r != null && cur.r.r != null ? cur.r.r.h : 0;
                    if (rightRightHeight < rightLeftHeight) {
                        cur.r = rightRotate(cur.r);
                    }
                    cur = leftRotate(cur);
                }
            }
            return cur;
        }
    }
}
