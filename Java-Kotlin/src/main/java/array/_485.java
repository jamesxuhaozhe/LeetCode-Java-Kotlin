package array;

public class _485 {

    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int macCount = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num == 1) {
                count++;
            } else {
                macCount = Math.max(count, macCount);
                count = 0;
            }
        }
        return Math.max(count, macCount);
    }
}
