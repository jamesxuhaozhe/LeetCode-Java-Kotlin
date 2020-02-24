package sort.largest_number_179;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Problem link: https://leetcode-cn.com/problems/largest-number/
 *
 * Time complexity: O(nlogn)
 *
 * Space complexity: O(n)
 */
public class Solution {

    public String largestNumber(int[] nums) {
        String[] numStr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(numStr, (o1, o2) -> {
            String order1 = o1 + o2;
            String order2 = o2 + o1;
            return order2.compareTo(order1);
        });

        if (numStr.length != 0 && numStr[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String str : numStr) {
            sb.append(str);
        }

        return sb.toString();
    }
}
