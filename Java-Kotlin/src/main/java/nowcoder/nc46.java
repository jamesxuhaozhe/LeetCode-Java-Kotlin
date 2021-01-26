package nowcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class nc46 {

    // https://leetcode-cn.com/problems/combination-sum-ii/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-3/
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        if (num == null || num.length == 0) {
            return new ArrayList<>();
        }

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();

        Arrays.sort(num);
        dfs(num, res, list, target, 0);
        return res;
    }

    private void dfs(int[] num, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list, int leftToTarget, int start) {
        if (leftToTarget == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < num.length; i++) {
            if (num[i] > leftToTarget) {
                break;
            }
            // 跟 3sum , nsum 的类似， 同一层的相同的数字需要跳过
            if (i > start && num[i] == num[i - 1]) {
                continue;
            }
            list.add(num[i]);
            dfs(num, res, list, leftToTarget - num[i], i + 1);
            list.remove(list.size() - 1);
        }
    }
}
