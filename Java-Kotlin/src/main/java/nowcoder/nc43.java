package nowcoder;

import java.util.ArrayList;

public class nc43 {

    private static void dfs(int[] num,
                            ArrayList<ArrayList<Integer>> res,
                            ArrayList<Integer> list,
                            boolean[] used) {
        if (num.length == list.size()) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < num.length; i++) {
            if (!used[i]) {
                list.add(num[i]);
                used[i] = true;

                dfs(num, res, list, used);

                list.remove(list.size() - 1);
                used[i] = false;
            }
        }
    }

    // https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (num == null || num.length == 0) {
            return res;
        }
        boolean[] used = new boolean[num.length];
        ArrayList<Integer> list = new ArrayList<>();
        dfs(num, res, list, used);
        return res;
    }
}
