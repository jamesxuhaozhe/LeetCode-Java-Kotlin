package array;

import java.util.ArrayList;
import java.util.List;

public class _1431 {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int max = getMax(candies);
        for (int num : candies) {
            if (num + extraCandies >= max) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        return result;
    }

    private int getMax(int[] candies) {
        int max = Integer.MIN_VALUE;
        for (int num : candies) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
}
