package class03;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Mark
 * @date 2022/4/9 15:18
 */
public class Code06_TopKTimes {

    // 词频最大的前K个字符串

    /**
     * 给定一个由字符串组成的数组String[] strs，给定一个正数K
     * 返回词频最大的前K个字符串，假设结果是唯一的
     */
    public static class Node {
        public String str;
        public int times;

        public Node(String s, int t) {
            str = s;
            times = t;
        }
    }

    // 方法一：利用大根堆
    public static void printTopKAndRank1(String[] arr, int topK) {
        if (arr == null || arr.length == 0 || topK < 1 || topK > arr.length) {
            return;
        }
        HashMap<String, Integer> map = new HashMap<>();
        for (String str : arr) {
            if (!map.containsKey(str)) {
                map.put(str, 1);
            } else {
                map.put(str, map.get(str) + 1);
            }
        }
        topK = Math.min(arr.length, topK);
        // 大根堆
        PriorityQueue<Node> heap = new PriorityQueue<>((o1, o2) -> o2.times - o1.times);
        for (Map.Entry<String, Integer> entry : map.entrySet()) { // 把所有数据都加进去
            heap.add(new Node(entry.getKey(), entry.getValue()));
        }
        for (int i = 0; i < topK && !heap.isEmpty(); i++) { // 依次弹出topK
            Node node = heap.poll();
            System.out.println(node.str + "," + node.times);
        }
    }

    // 方法二：利用小根堆，空间更省
    public static void printTopKAndRank2(String[] arr, int topK) {
        if (arr == null || arr.length == 0 || topK < 1 || topK > arr.length) {
            return;
        }
        HashMap<String, Integer> map = new HashMap<>();
        for (String str : arr) {
            if (!map.containsKey(str)) {
                map.put(str, 1);
            } else {
                map.put(str, map.get(str) + 1);
            }
        }
        topK = Math.min(arr.length, topK);
        // 小根堆
        PriorityQueue<Node> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o.times));
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            Node cur = new Node(entry.getKey(), entry.getValue());
            if (heap.size() < topK) { // 只填加topK个数据
                heap.add(cur);
            } else {
                if (heap.peek().times < cur.times) {
                    heap.poll();
                    heap.add(cur);
                }
            }
        }
        while (!heap.isEmpty()) {  // 依次弹出topK
            Node node = heap.poll();
            System.out.println(node.str + "," + node.times);
        }
    }

    public static String[] generateRandomArray(int len, int max) {
        String[] res = new String[len];
        for (int i = 0; i != len; i++) {
            res[i] = String.valueOf((int) (Math.random() * (max + 1)));
        }
        return res;
    }

    public static void printArray(String[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String[] arr1 = {"A", "B", "A", "C", "A", "C", "B", "B", "K"};
        printTopKAndRank1(arr1, 2);
        printTopKAndRank2(arr1, 2);

        String[] arr2 = generateRandomArray(50, 10);
        int topK = 3;
        printArray(arr2);
        printTopKAndRank1(arr2, topK);
        System.out.println("================");
        printTopKAndRank2(arr2, topK);
    }
}
