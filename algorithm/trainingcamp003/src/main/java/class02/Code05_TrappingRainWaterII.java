package class02;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Mark
 * @date 2022/4/8 8:53
 */
public class Code05_TrappingRainWaterII {

    // 接雨水II：https://leetcode-cn.com/problems/trapping-rain-water-ii/
    public static class Node {
        public int value;
        public int row;
        public int col;

        public Node(int v, int r, int c) {
            value = v;
            row = r;
            col = c;
        }

    }

    public static class NodeComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o1.value - o2.value;
        }

    }

    public static int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0] == null || heightMap[0].length == 0) {
            return 0;
        }
        int N = heightMap.length;
        int M = heightMap[0].length;
        // isEnter[i][j] == true  之前进过
        //  isEnter[i][j] == false 之前没进过
        boolean[][] isEnter = new boolean[N][M];
        // 小根堆
        PriorityQueue<Node> heap = new PriorityQueue<>(new NodeComparator());
        // 将外层一圈添加进小根堆，注意边界不要重复添加
        for (int col = 0; col < M - 1; col++) { // 最上边一行添加进小根堆
            isEnter[0][col] = true;
            heap.add(new Node(heightMap[0][col], 0, col));
        }
        for (int row = 0; row < N - 1; row++) { // 最右边一列添加进小根堆
            isEnter[row][M - 1] = true;
            heap.add(new Node(heightMap[row][M - 1], row, M - 1));
        }
        for (int col = M - 1; col > 0; col--) { // 最下边一行添加进小根堆
            isEnter[N - 1][col] = true;
            heap.add(new Node(heightMap[N - 1][col], N - 1, col));
        }
        for (int row = N - 1; row > 0; row--) { // 最左边一列添加进小根堆
            isEnter[row][0] = true;
            heap.add(new Node(heightMap[row][0], row, 0));
        }
        int water = 0; // 每个位置的水量，累加到water上去
        int max = 0; // 每个node在弹出的时候，如果value更大，更新max，否则max的值维持不变
        while (!heap.isEmpty()) {
            Node cur = heap.poll();
            max = Math.max(max, cur.value);
            int r = cur.row;
            int c = cur.col;
            if (r > 0 && !isEnter[r - 1][c]) { // 如果有上面的位置并且上面位置没进过堆
                water += Math.max(0, max - heightMap[r - 1][c]);
                isEnter[r - 1][c] = true;
                heap.add(new Node(heightMap[r - 1][c], r - 1, c));
            }
            if (r < N - 1 && !isEnter[r + 1][c]) { // 如果有下面的位置并且下面位置没进过堆
                water += Math.max(0, max - heightMap[r + 1][c]);
                isEnter[r + 1][c] = true;
                heap.add(new Node(heightMap[r + 1][c], r + 1, c));
            }
            if (c > 0 && !isEnter[r][c - 1]) { // 如果有左面的位置并且左面位置没进过堆
                water += Math.max(0, max - heightMap[r][c - 1]);
                isEnter[r][c - 1] = true;
                heap.add(new Node(heightMap[r][c - 1], r, c - 1));
            }
            if (c < M - 1 && !isEnter[r][c + 1]) { // 如果有右面的位置并且右面位置没进过堆
                water += Math.max(0, max - heightMap[r][c + 1]);
                isEnter[r][c + 1] = true;
                heap.add(new Node(heightMap[r][c + 1], r, c + 1));
            }
        }
        return water;
    }
}
