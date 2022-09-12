package topinterviewquestions;

import java.util.HashMap;

/**
 * @author Mark
 * @date 2022/4/1 0:52
 */
public class Problem_0380_InsertDeleteGetRandom {

    // O(1)时间插入、删除和获取随机元素：https://leetcode.com/problems/insert-delete-getrandom-o1/
    public class RandomizedSet {

        private HashMap<Integer, Integer> keyIndexMap;
        private HashMap<Integer, Integer> indexKeyMap;
        private int size;

        public RandomizedSet() {
            keyIndexMap = new HashMap<Integer, Integer>();
            indexKeyMap = new HashMap<Integer, Integer>();
            size = 0;
        }

        public boolean insert(int val) {
            if (!keyIndexMap.containsKey(val)) {
                keyIndexMap.put(val, size);
                indexKeyMap.put(size++, val);
                return true;
            }
            return false;
        }

        public boolean remove(int val) {
            if (keyIndexMap.containsKey(val)) {
                int deleteIndex = keyIndexMap.get(val);
                int lastIndex = --size;
                int lastKey = indexKeyMap.get(lastIndex);
                keyIndexMap.put(lastKey, deleteIndex);
                indexKeyMap.put(deleteIndex, lastKey);
                keyIndexMap.remove(val);
                indexKeyMap.remove(lastIndex);
                return true;
            }
            return false;
        }

        public int getRandom() {
            if (size == 0) {
                return -1;
            }
            int randomIndex = (int) (Math.random() * size);
            return indexKeyMap.get(randomIndex);
        }
    }
}
