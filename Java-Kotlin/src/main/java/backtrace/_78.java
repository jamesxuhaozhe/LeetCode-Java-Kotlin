package backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }

        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        helper(0, nums, result, list);
        return result;
    }

    private void helper(int i, int[] nums, List<List<Integer>> result, List<Integer> list) {

        result.add(new ArrayList<>(list));

        for (int start = i; start < nums.length; start++) {
            list.add(nums[start]);
            helper(start + 1, nums, result, list);
            list.remove(list.size() - 1);
        }
    }
}
