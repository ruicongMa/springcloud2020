package topinterviewquestions;

import java.util.PriorityQueue;

/**
 * @author Mark
 * @date 2022/3/30 17:34
 */
public class Problem_0295_FindMedianFromDataStream {

    // 数据流的中位数：https://leetcode.com/problems/find-median-from-data-stream/
    class MedianFinder {

        private PriorityQueue<Integer> maxh;
        private PriorityQueue<Integer> minh;

        public MedianFinder() {
            maxh = new PriorityQueue<>((a, b) -> b - a);
            minh = new PriorityQueue<>((a, b) -> a - b);
        }

        public void addNum(int num) {
            if (maxh.isEmpty()) { // 第一个数入大根堆
                maxh.add(num);
            } else {
                if (maxh.peek() >= num) {
                    maxh.add(num);
                } else {
                    minh.add(num);
                }
            }
            balance();
        }

        public double findMedian() {
            if (maxh.size() == minh.size()) {
                return (double) (maxh.peek() + minh.peek()) / 2;
            } else {
                return maxh.size() > minh.size() ? maxh.peek() : minh.peek();
            }
        }

        private void balance() {
            if (maxh.size() == minh.size() + 2) {
                minh.add(maxh.poll());
            }
            if (maxh.size() == minh.size() - 2) {
                maxh.add(minh.poll());
            }
        }

    }
}
