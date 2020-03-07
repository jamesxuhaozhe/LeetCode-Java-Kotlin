package array._997;

import java.util.HashSet;
import java.util.Set;

public class _997 {

    public int findJudge(int N, int[][] trust) {
        Set<String> relation = transfer(trust);
        for (int i = 1; i <= N; i++) {
            boolean find = true;
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    continue;
                }
                if (relation.contains(i + ":" + j) || !relation.contains(j + ":" + i)) {
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

    private Set<String> transfer(int[][] trust) {
        Set<String> result = new HashSet<>();
        for (int i = 0; i < trust.length; i++) {
            int[] element = trust[i];
            result.add(element[0] + ":" + element[1]);
        }
        return result;
    }

    public int findJudge1(int N, int[][] trust) {
        Set<String> relation = transfer(trust);
        int l = 1;
        int r = N;
        while (l != r) {
            if (relation.contains(l + ":" + r)) {
                l++;
            } else {
                r--;
            }
        }

        for (int i = 1; i <= N; i++) {
            if (i == l) {
                continue;
            }
            if (relation.contains(l + ":" + i) || !relation.contains(i + ":" + l)) {
                return -1;
            }
        }

        return l;
    }
}
