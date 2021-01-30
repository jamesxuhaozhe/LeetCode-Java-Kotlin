package nowcoder;

import java.util.ArrayList;

public class nc18 {

    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }


    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if (intervals == null || intervals.size() < 2) {
            return intervals;
        }

        intervals.sort(((o1, o2) -> {
            //按照start、end从小到大进行排序；
            if (o1.start == o2.start) {
                return o1.end - o2.end;
            } else {
                return o1.start - o2.start;
            }
        }));

        ArrayList<Interval> result = new ArrayList<>();
        result.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            Interval lastOneInRes = result.get(result.size() - 1);
            if (cur.start <= lastOneInRes.end) {//区间相交
                lastOneInRes.end = Math.max(cur.end, lastOneInRes.end);
                //合并两个区间成为新的区间，剔除原来的区间，将新区间加入到结果集中
                result.remove(result.size() - 1);
                result.add(lastOneInRes);
            } else {
                //区间不相交，直接加入
                result.add(cur);
            }
        }

        return result;
    }
}
