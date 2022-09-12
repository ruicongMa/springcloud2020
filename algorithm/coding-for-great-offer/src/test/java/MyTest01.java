
import java.util.*;

/**
 * @author Mark
 * @date 2022/4/20 19:15
 */
public class MyTest01 {

    public class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static class Meet {
        public int start;
        public int end;
        public int val;

        public Meet(int start, int end, int val) {
            this.start = start;
            this.end = end;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        int[][] meeting = {{10, 40}, {20, 50}, {30, 45}, {40, 60}};
        int[] value = {3, 6, 2, 4};
        System.out.println(maxValue(meeting, value));
    }

    public static int maxValue(int[][] meeting, int[] value) {
        if (meeting == null || meeting.length == 0 || meeting[0].length == 0 || value == null || value.length == 0) {
            return 0;
        }
        Meet[] meets = new Meet[meeting.length];
        for (int i = 0; i < meeting.length; i++) {
            meets[i] = new Meet(meeting[i][0], meeting[i][1], value[i]);
        }
        Arrays.sort(meets, Comparator.comparingInt(o -> o.end));
        int max = 0;
        int ans = 0;
        int timeLine = 0;
        for (Meet meet : meets) {
            if (timeLine <= meet.start) {
                ans += meet.val;
                timeLine = meet.end;
            } else {
                max = Math.max(max, meet.val);
            }
        }
        max = Math.max(max, ans);
        return max;
    }

    // 贪心：按照人类自然智慧分析
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return 0;
        }
        if (intervals.size() == 1) {
            return 1;
        }
        // 会议按照开始时间从小到大排序
        Collections.sort(intervals, Comparator.comparingInt(o -> o.start));
        // 准备一个小根堆，按照会议结束时间从小到大排序
        PriorityQueue<Interval> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o.end));
        int max = 0;
        for (Interval meet : intervals) {
            // 之前会议的结束时间小于等于当前会议的开始时间，说明会议能连接起来，把之前的会议弹出
            while (!heap.isEmpty() && heap.peek().end <= meet.start) {
                heap.poll();
            }
            heap.add(meet);
            // 堆中会议的大小就是能安排的会议数量
            max = Math.max(max, heap.size());
        }
        return max;
    }

    // 贪心：利用人类的自然智慧
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals == null || intervals.size() < 2) {
            return true;
        }
        // 会议按照结束时间从小到大排序
        Collections.sort(intervals, Comparator.comparingInt(o -> o.end));
        int timeLine = intervals.get(0).end; // 第一个会议室的结束时间
        for (int i = 1; i < intervals.size(); i++) {
            Interval meet = intervals.get(i);
            int start = meet.start;
            if (start < timeLine) { // 如果后续会议的开始时间小于上次会议的结束时间，直接返回false
                return false;
            } else { // 更新会议的结束时间
                timeLine = meet.end;
            }
        }
        return true;
    }
}
