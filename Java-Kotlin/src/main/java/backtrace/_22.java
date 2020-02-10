package backtrace;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _22 {

    public List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return Collections.emptyList();
        }

        List<String> result = new ArrayList<>();

        helper("", result, n, n);

        return result;
    }

    private void helper(String subStr, List<String> result, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(subStr);
        }

        if (left > 0) {
            helper(subStr + "(", result, left - 1, right);
        }

        if (right > left) {
            helper(subStr + ")", result, left, right - 1);
        }
    }
}
