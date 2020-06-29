package offer;

public class _21 {

    public int[] exchange(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int[] result = new int[nums.length];
        int i = 0;
        int j = result.length - 1;
        for (int num : nums) {
            if (num % 2 == 1) {
                result[i] = num;
                i++;
            } else {
                result[j] = num;
                j--;
            }
        }
        return result;
    }
}
