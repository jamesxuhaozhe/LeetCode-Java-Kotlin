package sort;

import java.util.Arrays;
import java.util.Comparator;

public class _252 {

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{0, 30}, {5, 10}, {15, 20}};
        System.out.println(new _252().canAttendMeetings(intervals));
    }

    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length == 1 || intervals.length == 0) {
            return true;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
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
}
