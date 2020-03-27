package array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/find-n-unique-integers-sum-up-to-zero/
 */
public class _1304 {

    public int[] sumZero(int n) {
        if (n == 1) {
            return new int[] {0};
        }
        List<Integer> list = new ArrayList<>();
        int start = 0;
        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            sum += start;
            list.add(start++);
        }
        list.add(-sum);
        int[] result = new int[n];
        int i = 0;
        for (Integer num : list) {
            result[i++] = num;
        }
        return result;
    }
}
