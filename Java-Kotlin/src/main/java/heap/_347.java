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
        list.sort((o1, o2) -> o2.count - o1.count);

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

    public List<Integer> topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            Integer count = map.get(i);
            if (count == null) {
                map.put(i, 1);
            } else {
                map.put(i, count + 1);
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> map.get(o2) - map.get(o1));

        for (int n : map.keySet()) {
            pq.offer(n);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(pq.poll());
        }

        return result;
    }
}
