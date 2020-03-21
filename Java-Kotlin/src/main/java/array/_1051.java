package array;

import java.util.Arrays;

public class _1051 {

    public int heightChecker(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        int[] helperArray = Arrays.copyOf(heights, heights.length);
        Arrays.sort(helperArray);
        int diff = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != helperArray[i]) {
                diff++;
            }
        }

        return diff;
    }
}
