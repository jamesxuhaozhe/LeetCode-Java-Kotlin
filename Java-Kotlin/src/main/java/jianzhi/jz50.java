package jianzhi;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class jz50 {

    // 如果题目不要求返回第一个重复的数，这么做是对的
    public boolean duplicate_1(int numbers[],int length,int [] duplication) {
        if (numbers == null || numbers.length == 0 || numbers.length != length) {
            return false;
        }

        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == numbers[i + 1]) {
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }

    public boolean duplicate_2(int numbers[],int length,int [] duplication) {
        if (numbers == null || numbers.length == 0 || numbers.length != length) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        for (int number : numbers) {
            if (!set.add(number)) {
                duplication[0] = number;
                return true;
            }
        }
        return false;
    }

    // jianzhi offer的方法，但是牛客上每个过，因为返回的不是第一重复的数字
    public boolean duplicate_3(int numbers[],int length,int [] duplication) {
        if (numbers == null || numbers.length == 0 || numbers.length != length) {
            return false;
        }

        for (int i = 0; i < numbers.length; i++) {
            while (i != numbers[i]) {
                int m = numbers[i];
                if (m == numbers[m]) {
                    duplication[0] = m;
                    return true;
                }
                swap(numbers, i, m);
            }
        }
        return false;
    }

    private static void swap(int[] numbers, int i, int m) {
        int tmp = numbers[i];
        numbers[i] = numbers[m];
        numbers[m] = tmp;
    }
}
