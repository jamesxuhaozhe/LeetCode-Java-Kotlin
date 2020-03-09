package array._997;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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
        for (int[] element : trust) {
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

    public int findJudge2(int N, int[][] trust) {
        Map<Integer, Set<Integer>> map = getMap(trust);

        for (int i = 1; i <= N; i++) {
            //表示i这个人谁都不相信
            if (!map.containsKey(i)) {
                //用来计数相信他的人数，应当是N-1
                int trustCount = 0;
                for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
                    if (entry.getValue().contains(i)) {
                        trustCount++;
                    }
                }
                if (trustCount == N - 1) {
                    return i;
                }
            }
        }

        return -1;
    }

    /**
     * 建立一个map，key是相信别人的人，value是这个人相信的人的集合
     * @param trust
     * @return
     */
    private Map<Integer, Set<Integer>> getMap(int[][] trust) {
        Map<Integer, Set<Integer>> result = new HashMap<>();
        for (int[] cur : trust) {
            if (!result.containsKey(cur[0])) {
                result.put(cur[0], new HashSet<>());
            }
            result.get(cur[0]).add(cur[1]);
        }
        return result;
    }

    public static void main(String[] args) {

        int[][] trust = new int[][]{{1, 8}, {1, 3}, {2, 8}, {2, 3}, {4, 8}, {4, 3}, {5, 8}, {5, 3}, {6, 8}, {6, 3}, {7, 8}, {7, 3}, {9, 8}, {9, 3}, {11, 8}, {11, 3}};
        System.out.println(new _997().findJudge2(11, trust));
    }
}
