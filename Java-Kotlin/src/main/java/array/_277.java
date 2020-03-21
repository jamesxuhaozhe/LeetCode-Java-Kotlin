package array;

public class _277 extends _277_Relation {

    /**
     * The naive brute force solution, knows(i, j) = true, it means two thing, i cannot be celebrity, j could be
     * knows(i, j) = false, i could be celebrity, j can not be.
     *
     * @param n
     * @return
     */
    public int findCelebrity(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("Invalid input");
        }

        if (n == 1) {
            return n;
        }

        for (int i = 0; i < n; i++) {
            boolean find = true;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                // 检查这个人是不是非名人
                if (knows(i, j) || !knows(j, i)) {
                    find = false;
                    break;
                }
            }
            if (find) {
                return i;
            }
        }

        return -1;
    }

    /**
     *
     * @param n
     * @return
     */
    public int findCelebrity1(int n) {
        int l = 0;
        int r = n - 1;
        while (l != r) {
            if (knows(l, r)) {
                l++;
            } else {
                r--;
            }
        }
        // 最终如果l == r ， l就是我们可能的候选答案

        for (int i = 0; i < n; i++) {
            if (i == l) {
                continue;
            }

            if (knows(l, i) || !knows(i, l)) {
                return -1;
            }
        }
        return l;
    }
}
