package array;

public class _1470 {

    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[2 * n];
        for (int i = 0; i < n; i++) {
            int cur = 2 * i;
            int next = cur + 1;
            result[cur] = nums[i];
            result[next] = nums[i + n];
        }
        return result;
    }
}
