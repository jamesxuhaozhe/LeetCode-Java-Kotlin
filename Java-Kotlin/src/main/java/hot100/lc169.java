package hot100;

import java.util.Arrays;

public class lc169 {

    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
