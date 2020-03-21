package array;

import java.util.HashSet;
import java.util.Set;

public class _349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
        }
        Set<Integer> result = new HashSet<>(set1);
        result.retainAll(set2);
        int[] res = new int[result.size()];
        int i = 0;
        for (int num : result) {
            res[i] = num;
            i++;
        }
        return res;
    }
}
