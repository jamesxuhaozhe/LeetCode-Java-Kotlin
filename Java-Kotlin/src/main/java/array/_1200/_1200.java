package array._1200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _1200 {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        // first sort the array
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        int lastValue = arr[0];
        // 用一个map来记录，每两两之间的绝对差值，key是绝对差值，value是具有该绝对差值的两两对。
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        for (int i = 1; i < arr.length; i++) {
            int currentDiff = arr[i] - lastValue;
            if (map.containsKey(currentDiff)) {
                map.get(currentDiff).add(Arrays.asList(lastValue, arr[i]));
            } else {
                List<List<Integer>> list = new ArrayList<>();
                list.add(Arrays.asList(lastValue, arr[i]));
                map.put(currentDiff, list);
            }
            //找到最小的绝对差值
            minDiff = Math.min(minDiff, arr[i] - lastValue);

            lastValue = arr[i];
        }

        return map.get(minDiff);
    }

}
