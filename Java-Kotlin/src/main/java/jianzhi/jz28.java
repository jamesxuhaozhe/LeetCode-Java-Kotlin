package jianzhi;

import java.util.Arrays;

public class jz28 {

    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        Arrays.sort(array);
        int mid = array[array.length / 2];
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (mid == array[i]) {
                count++;
            }
        }
        if (count > array.length / 2) {
            return mid;
        }
        return 0;
    }
}
