package nowcoder;

public class nc128 {

    // see blue book
    public long maxWater(int[] arr) {
        // write code here
        if (!isValid(arr)) {
            return 0;
        }

        int left = 0;
        int right = arr.length - 1;
        long lMax = arr[left];
        long rMax = arr[right];
        long ans = 0;
        while (left <= right) {
            lMax = Math.max(lMax, arr[left]);
            rMax = Math.max(rMax, arr[right]);
            if (lMax < rMax) {
                ans += lMax - arr[left];
                left++;
            } else {
                ans += rMax - arr[right];
                right--;
            }
        }
        return ans;
    }

    private static boolean isValid(int[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        return true;
    }
}
