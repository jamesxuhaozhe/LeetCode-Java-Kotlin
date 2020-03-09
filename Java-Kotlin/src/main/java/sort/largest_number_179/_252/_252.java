package sort.largest_number_179._252;

import java.util.Arrays;
import java.util.Comparator;

public class _252 {

    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length == 1 || intervals.length == 0) {
            return true;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int lastEndTime = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int currStartTime = intervals[i][0];
            if (currStartTime < lastEndTime) {
                return false;
            }
            lastEndTime = intervals[i][1];
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{0, 30}, {5, 10}, {15, 20}};
        System.out.println(new _252().canAttendMeetings(intervals));
    }
}
