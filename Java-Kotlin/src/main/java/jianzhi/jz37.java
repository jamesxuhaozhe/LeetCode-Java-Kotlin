package jianzhi;

public class jz37 {

    private static int getLeftIdx(int[] array, int k) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] < k) {
                left = mid + 1;
            } else if (k < array[mid]) {
                right = mid - 1;
            } else {
                if (mid == 0 || array[mid - 1] != k) {
                    return mid;
                }
                right = mid - 1;
            }
        }
        return -1;
    }

    private static int getRightIdx(int[] array, int k) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] < k) {
                left = mid + 1;
            } else if (k < array[mid]) {
                right = mid - 1;
            } else {
                if (mid == array.length - 1 || array[mid + 1] != k) {
                    return mid;
                }
                left = mid + 1;
            }
        }
        return -1;
    }

    public int GetNumberOfK(int[] array, int k) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int leftIdx = getLeftIdx(array, k);
        if (leftIdx == -1) {
            return 0;
        }
        int rightIdx = getRightIdx(array, k);
        return rightIdx - leftIdx + 1;
    }
}
