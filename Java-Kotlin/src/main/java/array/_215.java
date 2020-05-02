package array;

import java.util.Arrays;
import java.util.PriorityQueue;

public class _215 {

    /**
     * This is actually faster
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int[] n = new int[nums.length];
        int index = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            n[index++] = nums[i];
        }

        return n[k - 1];
    }

    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.poll();
    }
}
