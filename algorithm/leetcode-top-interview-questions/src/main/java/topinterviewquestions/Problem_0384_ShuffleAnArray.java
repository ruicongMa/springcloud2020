package topinterviewquestions;

/**
 * @author Mark
 * @date 2022/4/1 8:04
 */
public class Problem_0384_ShuffleAnArray {

    // 打乱数组：https://leetcode.com/problems/shuffle-an-array/
    class Solution {
        private int[] origin;
        private int[] shuffle;
        private int N;

        public Solution(int[] nums) {
            origin = nums.clone();
            N = nums.length;
            shuffle = new int[N];
            for (int i = 0; i < N; i++) {
                shuffle[i] = origin[i];
            }
        }

        public int[] reset() {
            return origin;
        }

        public int[] shuffle() {
            for (int i = N - 1; i >= 0; i--) {
                int r = (int) (Math.random() * (i + 1));
                int tmp = shuffle[r];
                shuffle[r] = shuffle[i];
                shuffle[i] = tmp;
            }
            return shuffle;
        }
    }
}
