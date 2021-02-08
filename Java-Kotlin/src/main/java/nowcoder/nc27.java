package nowcoder;

import java.util.ArrayList;

public class nc27 {

    private static void dfs(int[] num, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list, int begin) {
        res.add(new ArrayList<>(list));
        for (int i = begin; i < num.length; i++) {
            list.add(num[i]);
            dfs(num, res, list, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public ArrayList<ArrayList<Integer>> subsets(int[] num) {
        if (num == null || num.length == 0) {
            return new ArrayList<>();
        }

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        dfs(num, res, list, 0);

        return res;
    }
}
