package dfs;

import java.util.*;

public class _51 {

    private Set<Integer> cols = new HashSet<>();

    private Set<Integer> pies = new HashSet<>();

    private Set<Integer> nas = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
        // obviously, just return empty list
        if (n < 1) {
            return Collections.emptyList();
        }

        List<List<Integer>> resultColIndices = new ArrayList<>();
        List<Integer> colIndices = new ArrayList<>();
        dfs(0, n, resultColIndices, colIndices);

        return postProcess(resultColIndices, n);
    }

    private List<List<String>> postProcess(List<List<Integer>> resultColIndices, int n) {
        List<List<String>> result = new ArrayList<>(resultColIndices.size());

        for (List<Integer> colIndices : resultColIndices) {
            List<String> resultSutList = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                int colIndex = colIndices.get(i);
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (j == colIndex) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                resultSutList.add(sb.toString());
            }
            result.add(resultSutList);
        }
        return result;
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

    public static void main(String[] args) {
        System.out.println(new _51().solveNQueens(4));
    }
}
