package greedy;

import java.util.Arrays;

public class _1029 {
    public int twoCitySchedCost(int[][] costs) {
        // each city needs N people to interview
        int N = costs.length / 2;

        Arrays.sort(costs, (o1, o2) -> o1[0] - o1[1] - (o2[0] - o2[1]));

        int total = 0;
        for (int i = 0; i < N; i++) {
            total += costs[i][0] + costs[i + N][1];
        }

        return total;
    }

}
