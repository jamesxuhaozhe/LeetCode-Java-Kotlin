package array;

import java.util.HashMap;
import java.util.Map;

public class _540 {

    /**
     * https://leetcode-cn.com/problems/single-element-in-a-sorted-array/solution/you-xu-shu-zu-zhong-de-dan-yi-yuan-su-by-leetcode/
     * @param nums
     * @return
     */
    public int singleNonDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }

        int len = nums.length;
        for (int i = 0; i < len - 1; i += 2) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }

        return nums[len - 1];
    }

    public int singleNonDuplicate1(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        throw new IllegalArgumentException();
    }

    /**
     * A^A^C^B^B=C
     * @param nums
     * @return
     */
    public int singleNonDuplicate2(int[] nums) {
        int first = nums[0];
        for (int i = 1; i < nums.length; i++) {
            first = first ^ nums[i];
        }
        return first;
    }

    /**
     * https://leetcode-cn.com/problems/single-element-in-a-sorted-array/solution/you-xu-shu-zu-zhong-de-dan-yi-yuan-su-by-leetcode/
     * @param nums
     * @return
     */
    public int singleNonDuplicate3(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }

        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            boolean isEven = (high - mid) % 2 == 0;
            if (nums[mid + 1] == nums[mid]) {
                if (isEven) {
                    low = mid + 2;
                } else {
                    high = mid - 1;
                }
            } else if (nums[mid - 1] == nums[mid]) {
                if (isEven) {
                    high = mid - 2;
                } else {
                    low = mid + 1;
                }
            } else {
                return nums[mid];
            }
        }

        return nums[low];
    }



}
