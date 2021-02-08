package nowcoder;

import java.util.ArrayList;
import java.util.List;

public class nc26 {

    private static void dfs(String str, int left, int right, List<String> res) {
        if (left == 0 && right == 0) {
            res.add(str);
            return;
        }

        if (left > right) {
            return;
        }

        if (left > 0) {
            dfs(str + "(", left - 1, right, res);
        }

        if (right > 0) {
            dfs(str + ")", left, right - 1, res);
        }
    }

    //https://leetcode-cn.com/problems/generate-parentheses/solution/hui-su-suan-fa-by-liweiwei1419/
    public ArrayList<String> generateParenthesis(int n) {
        // write code here
        if (n < 1) {
            return new ArrayList<>();
        }

        ArrayList<String> res = new ArrayList<>();
        dfs("", n, n, res);
        return res;
    }
}
