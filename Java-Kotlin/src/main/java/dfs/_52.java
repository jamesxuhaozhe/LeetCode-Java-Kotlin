package dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _52 {

    private Set<Integer> cols = new HashSet<>();

    private Set<Integer> pies = new HashSet<>();

    private Set<Integer> nas = new HashSet<>();

    public int totalNQueens(int n) {
        if (n < 1) {
            return 0;
        }

        List<List<Integer>> resultColIndices = new ArrayList<>();
        List<Integer> colIndices = new ArrayList<>();
        dfs(0, n, resultColIndices, colIndices);

        return resultColIndices.size();
    }

    private void dfs(int row, int n, List<List<Integer>> resultColIndices, List<Integer> colIndices) {
        if (row >= n) {
            resultColIndices.add(new ArrayList<>(colIndices));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (cols.contains(col) || pies.contains(row + col) || nas.contains(row - col)) {
                continue;
            }

            cols.add(col);
            pies.add(row + col);
            nas.add(row - col);

            colIndices.add(col);
            dfs(row + 1, n, resultColIndices, colIndices);

            cols.remove(col);
            pies.remove(row + col);
            nas.remove(row - col);
            colIndices.remove(colIndices.size() - 1);
        }
    }
}
