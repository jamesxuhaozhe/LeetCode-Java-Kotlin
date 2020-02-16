package dfs;

import java.util.ArrayList;
import java.util.List;

public class _120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.isEmpty()) {
            return 0;
        }

        int m = triangle.size();
        List<Integer> dp = new ArrayList<>(triangle.get(m - 1));
        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int dpValue = triangle.get(i).get(j) + Math.min(dp.get(j), dp.get(j + 1));
                dp.set(j, dpValue);
            }
        }
        return dp.get(0);
    }
}
