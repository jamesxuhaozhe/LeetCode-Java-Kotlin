package nowcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class nc42 {
    private static void dfs(int[] num, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list, boolean[] used) {
        if (num.length == list.size()) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < num.length; i++) {
            if (used[i]) {
                continue;
            }

            if (i > 0 && num[i] == num[i - 1] && !used[i - 1]) {
                continue;
            }

            list.add(num[i]);
            used[i] = true;
            dfs(num, res, list, used);

            list.remove(list.size() - 1);
            used[i] = false;
        }
    }

    // https://leetcode-cn.com/problems/permutations-ii/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liwe-2/
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (num == null || num.length == 0) {
            return res;
        }

        ArrayList<Integer> list = new ArrayList<>();
        boolean[] used = new boolean[num.length];
        Arrays.sort(num);
        dfs(num, res, list, used);
        return res;
    }
}
