package hot100;

import java.util.ArrayList;
import java.util.List;

public class lc9 {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        List<Integer> list = new ArrayList<>();
        while (x != 0) {
            int digit = x % 10;
            list.add(digit);
            x /= 10;
        }

        int start = 0;
        int end = list.size() - 1;
        while (start < end) {
            if (list.get(start) != list.get(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
