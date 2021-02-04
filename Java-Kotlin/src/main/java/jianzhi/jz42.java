package jianzhi;

import java.util.ArrayList;

public class jz42 {

    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        if (array == null || array.length < 2) {
            return new ArrayList<>();
        }

        int i = 0;
        int j = array.length - 1;
        int minProduct = Integer.MAX_VALUE;
        ArrayList<Integer> result = new ArrayList<>();
        while (i < j) {
            int curSum = array[i] + array[j];
            if (curSum < sum) {
                i++;
            } else if (curSum > sum) {
                j--;
            } else {
                int currentProduct = array[i] * array[j];
                if (currentProduct < minProduct) {
                    minProduct = currentProduct;
                    if (result.size() == 2) {
                        result.set(0, array[i]);
                        result.set(1, array[j]);
                    } else {
                        result.add(array[i]);
                        result.add(array[j]);
                    }
                }
                i++;
                j--;
            }
        }
        return result;
    }
}
