package array.majority_element_169;

import java.util.Arrays;

public class Solution {

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
