package _1704;

public class _1704 {

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int idealSum = (1 + n) * n / 2;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        return idealSum - sum;
    }
}
