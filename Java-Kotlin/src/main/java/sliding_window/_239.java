package sliding_window;

import java.util.*;

public class _239 {
    // this is the brute force solution.
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return nums;
        }
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < nums.length - (k - 1); i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            resultList.add(max);
        }
        int[] res = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            res[i] = resultList.get(i);
        }

        return res;
    }

    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums.length == 0) {
            return nums;
        }
        List<Integer> resultList = new ArrayList<>();
        Queue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < nums.length - (k - 1); i++) {
            priorityQueue.clear();
            for (int j = i; j < i + k; j++) {
                priorityQueue.offer(nums[j]);
            }
            resultList.add(priorityQueue.poll());
        }
        int[] res = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            res[i] = resultList.get(i);
        }

        return res;
    }
}
