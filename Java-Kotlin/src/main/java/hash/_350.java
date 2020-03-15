package hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _350 {

    /**
     * Solution that just works, TODO: find better one
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums2.length < nums1.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> map1 = getMap(nums1);
        Map<Integer, Integer> map2 = getMap(nums2);

        List<Integer> result = new ArrayList<>();
        for (Integer key : map1.keySet()) {
            if (map2.containsKey(key)) {
                int count = Math.min(map1.get(key), map2.get(key));
                for (int i = 0; i < count; i++) {
                    result.add(key);
                }
            }
        }

        int index = 0;
        int[] arr = new int[result.size()];
        for (Integer num : result) {
            arr[index++] = num;
        }

        return arr;
    }

    private static Map<Integer, Integer> getMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        return map;
    }

    public static void main(String[] args) {

        int[] nums1 = new int[] {4, 9, 5};
        int[] nums2 = new int[] {9, 4, 9, 8, 4};

        int[] result = new _350().intersect(nums1, nums2);
        for (int num : result) {
            System.out.println(num);
        }
    }
}
