package array._16;

import java.util.Arrays;

public class _16 {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            int start = i + 1;
            int end = len - 1;
            while (start < end) {
               int localSum = nums[i] + nums[start] + nums[end];
               if (Math.abs(localSum - target) < Math.abs(ans - target)) {
                   ans = localSum;
               }
               if (localSum > target) {
                   end--;
               } else if (localSum < target) {
                   start++;
               } else {
                   return ans;
               }
            }
        }
        return ans;
    }
}
