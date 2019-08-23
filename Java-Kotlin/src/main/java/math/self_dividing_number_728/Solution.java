package math.self_dividing_number_728;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isDividingNumber(i)) {
                result.add(i);
            }
        }

        return result;
    }

    private boolean isDividingNumber(int i) {
        int number = i;
        while (i != 0) {
            int digit = i % 10;
            if (digit == 0 ||number % digit != 0) {
                return false;
            }
            i = i / 10;
        }

        return true;
    }
}
