import java.util.*;

/**
 * @author Mark
 * @date 2022/4/8 11:52
 */
public class MyTest {

    // public static void main(String[] args) {
    //     int[] nums = {0, 0, 8, 5, 4};
    //     System.out.println(isStraight(nums));
    //     System.out.println(isStraight2(nums));
    // }

    public static boolean isStraight(int[] nums) {
        Set<Integer> repeat = new HashSet<>();
        int max = 0, min = 14;
        for (int num : nums) {
            if (num == 0) continue; // 跳过大小王
            max = Math.max(max, num); // 最大牌
            min = Math.min(min, num); // 最小牌
            if (repeat.contains(num)) return false; // 若有重复，提前返回 false
            repeat.add(num); // 添加此牌至 Set
        }
        return max - min < 5; // 最大牌 - 最小牌 < 5 则可构成顺子
    }

    public static boolean isStraight2(int[] nums) {
        int joker = 0;
        Arrays.sort(nums); // 数组排序
        for (int i = 0; i < 4; i++) {
            if (nums[i] == 0) joker++; // 统计大小王数量
            else if (nums[i] == nums[i + 1]) return false; // 若有重复，提前返回 false
        }
        return nums[4] - nums[joker] < 5; // 最大牌 - 最小牌 < 5 则可构成顺子
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int N = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = N - 1; i > 2; i--) {
            if (i == N - 1 || nums[i] != nums[i + 1]) {
                List<List<Integer>> nexts = threeSum(nums, i - 1, target - nums[i]);
                for (List<Integer> cur : nexts) {
                    cur.add(nums[i]); // 效率高，直接添加到结尾
                    ans.add(cur);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 2, 2};
        System.out.println(fourSum(nums, 8));
    }

    public static List<List<Integer>> threeSum(int[] nums, int end, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = end; i > 1; i--) { // 从后往前遍历
            if (i == end || nums[i] != nums[i + 1]) {
                List<List<Integer>> nexts = twoSum(nums, i - 1, target - nums[i]);
                for (List<Integer> cur : nexts) {
                    cur.add(nums[i]); // 效率高，直接添加到结尾
                    ans.add(cur);
                }
            }
        }
        return ans;
    }

    public static List<List<Integer>> twoSum(int[] nums, int end, int target) {
        int L = 0;
        int R = end;
        List<List<Integer>> ans = new ArrayList<>();
        while (L < R) {
            if (nums[L] + nums[R] > target) {
                R--;
            } else if (nums[L] + nums[R] < target) {
                L++;
            } else {
                if (L == 0 || nums[L - 1] != nums[L]) {
                    List<Integer> cur = new ArrayList<>();
                    cur.add(nums[L]);
                    cur.add(nums[R]);
                    ans.add(cur);
                }
                L++;
            }
        }
        return ans;
    }

}
