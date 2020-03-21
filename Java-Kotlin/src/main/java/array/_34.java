package array;

public class _34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return new int[] {-1, -1};
        }

        int oneKnownIndex = getKnownIndex(nums, target);
        if (oneKnownIndex == -1) {
            return new int[] {-1, -1};
        }

        int left = oneKnownIndex;
        while (left > 0 && nums[left - 1] == nums[left]) {
            left--;
        }
        int right = oneKnownIndex;
        while (right < nums.length - 1 && nums[right] == nums[right + 1]) {
            right++;
        }
        return new int[] {left, right};
    }

    private int getKnownIndex(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
