package array.two_sum_i_1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution_test {

    @Test
    public void testTwoSum() {
        int[] nums = new int[] {2, 7, 11, 15};
        int target = 9;
        int[] result = new Solution().twoSum(nums, target);
        assertEquals(1, result[0]);
        assertEquals(0, result[1]);
    }
}
