package backtrace;

import java.util.ArrayList;
import java.util.List;

public class _46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        List<Integer> list = new ArrayList<>();
        helper(nums, result, list);
        return result;
    }

    private void helper(int[] nums, List<List<Integer>> result, List<Integer> list) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
        } else {
            for (int num : nums) {
                if (list.contains(num)) {
                    continue;
                }
                list.add(num);
                helper(nums, result, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
