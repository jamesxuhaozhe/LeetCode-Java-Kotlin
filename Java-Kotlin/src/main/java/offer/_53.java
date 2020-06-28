package offer;

public class _53 {

    public int missingNumber(int[] nums) {
        int n = nums.length + 1;
        int last = n - 1;
        int expected = last * n / 2;
        int actual = 0;
        for (int i : nums) {
            actual += i;
        }
        return expected - actual;
    }
}
