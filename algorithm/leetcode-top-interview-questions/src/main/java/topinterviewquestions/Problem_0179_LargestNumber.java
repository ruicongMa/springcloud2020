package topinterviewquestions;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Mark
 * @date 2022/3/26 22:27
 */
public class Problem_0179_LargestNumber {

    // 最大数：https://leetcode.com/problems/largest-number/
    public static class MyComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            // 排序策略：a.b < b.a 则b大
            // 默认是从小到大排序的，应该从大到小排序
            return (o2 + o1).compareTo(o1 + o2);
        }

    }

    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, new MyComparator());
        StringBuilder builder = new StringBuilder();
        for (String str : strs) {
            builder.append(str);
        }
        String ans = builder.toString();
        char[] str = ans.toCharArray();
        int index = -1;
        for (int i = 0; i < str.length; i++) {
            if (str[i] != '0') {
                index = i;
                break;
            }
        }
        return index == -1 ? "0" : ans.substring(index); // 清除前缀0
    }
}
