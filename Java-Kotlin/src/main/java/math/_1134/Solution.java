package math._1134;

/**
 * Problem link: https://leetcode-cn.com/problems/armstrong-number/
 *
 * Time complexity: O(n)
 *
 * Space complexity: O(1)
 */
public class Solution {

    public boolean isArmstrong(int N) {
        String number = Integer.toString(N);
        int n = number.length();

        int result = 0;
        int Ndup = N;
        while (Ndup != 0) {
            int digit = Ndup % 10;
            result += Math.pow(digit, n);
            Ndup = Ndup / 10;
        }

        return N == result;
    }
}
