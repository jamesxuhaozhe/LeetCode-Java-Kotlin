package heap;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collections.*;

public class _347 {

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            Integer count = map.get(i);
            if (count == null) {
                map.put(i, 1);
            } else {
                map.put(i, count + 1);
            }
        }

        List<Holder> list = map.entrySet().stream().map( entry -> new Holder(entry.getKey(), entry.getValue())).collect(Collectors.toList());
        sort(list, new Comparator<Holder>() {
            @Override
            public int compare(Holder o1, Holder o2) {
                return o2.count - o1.count;
            }
        });

        List<Integer> result = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            result.add(list.get(i).keyNum);
        }

        return result;
    }

    private static class Holder {
        private int keyNum;
        private int count;

        Holder(int keyNum, int count) {
            this.keyNum = keyNum;
            this.count = count;
        }
    }
}
