package backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0 || target <= 0) {
            return result;
        }

        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        helper(0, candidates, target, result, list);
        return result;
    }

    private void helper(int start, int[] candidates, int target, List<List<Integer>> result, List<Integer> list) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        } else {
            for (int i = start; i < candidates.length; i++) {
                // candidates might have dups, so we skip the dup 
                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                list.add(candidates[i]);
                helper(i + 1, candidates, target - candidates[i], result, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
