package array;

import java.util.HashMap;
import java.util.Map;

public class _760 {

    public int[] anagramMappings(int[] A, int[] B) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < B.length; i++) {
            map.put(B[i], i);
        }
        int[] p = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            p[i] = map.get(A[i]);
        }
        return p;
    }
}
