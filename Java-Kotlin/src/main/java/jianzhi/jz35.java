package jianzhi;

// see jianzhi offer book, todo: use golang
public class jz35 {

    private static final int MOD = 1000000007;

    private int result = 0;

    public int InversePairs(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int[] tmp = new int[array.length];
        mergeSort(array, tmp, 0, array.length - 1);
        return result;
    }

    private void mergeSort(int[] arr, int[] tmp, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        mergeSort(arr, tmp, left, mid);
        mergeSort(arr, tmp, mid + 1, right);
        merge(arr, tmp, left, mid, right);
    }

    private void merge(int[] arr, int[] tmp, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (arr[i] > arr[j]) {
                tmp[k++] = arr[j++];
                result += mid - i + 1;
                result %= MOD;
            } else {
                tmp[k++] = arr[i++];
            }
        }
        while (i <= mid) {
            tmp[k++] = arr[i++];
        }
        while (j <= right) {
            tmp[k++] = arr[j++];
        }

        k = 0;
        for (i = left; i <= right; i++, k++) {
            arr[i] = tmp[k];
        }
    }
}
