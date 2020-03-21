package array;

import java.util.ArrayList;
import java.util.List;

public class _118 {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();
        for (int currRow = 0; currRow < numRows; currRow++) {
            List<Integer> rowList = getInitialRowList(currRow + 1);
            for (int j = 0; j < rowList.size(); j++) {
                if (currRow > 1 && (j > 0 && j < rowList.size() - 1)) {
                    List<Integer> preList = result.get(currRow - 1);
                    rowList.set(j, preList.get(j - 1) + preList.get(j));
                }
            }
            result.add(rowList);
        }

        return result;
    }

    private List<Integer> getInitialRowList(int capacity) {
        List<Integer> result = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            result.add(1);
        }
        return result;
    }
}
