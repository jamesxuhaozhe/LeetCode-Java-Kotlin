package backtrace;

import java.util.ArrayList;
import java.util.List;

public class _77 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (n <= 0 || k <= 0 || k > n) {
            return result;
        }

        List<Integer> list = new ArrayList<>();
        helper1(1, n, k, result, list);

        return result;
    }

    private void helper(int start, int n, int k, List<List<Integer>> result, List<Integer> list) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
        } else {
            for (int i = start; i <= n; i++) {
                list.add(i);
                helper(i + 1, n, k, result, list);
                list.remove(list.size() - 1);
            }
        }
    }

    private void helper1(int start, int n, int k, List<List<Integer>> result, List<Integer> list) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
        } else {
            // the condition should be i - 1 + (k - list.size()) <= n
            for (int i = start; i <= n - (k - list.size()) + 1; i++) {
                list.add(i);
                helper(i + 1, n, k, result, list);
                list.remove(list.size() - 1);
            }
        }
    }


}
