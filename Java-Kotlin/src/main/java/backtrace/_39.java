package backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _39 {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 6, 7};
        int target = 7;
        System.out.println(new _39().combinationSum(nums, target));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0 || target < 0) {
            return result;
        }

        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        helper(0, candidates, result, target, list);
        return result;
    }

    private void helper(int start, int[] candidates, List<List<Integer>> result, int target, List<Integer> list) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            result.add(new ArrayList<>(list));
        } else {
            for (int i = start; i < candidates.length; i++) {
                list.add(candidates[i]);
                helper(i, candidates, result, target - candidates[i], list);
                list.remove(list.size() - 1);
            }
        }
    }
}
