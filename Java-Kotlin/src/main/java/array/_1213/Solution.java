package array._1213;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        int min1 = arr1[0];
        int max1 = arr1[arr1.length - 1];

        int min2 = arr2[0];
        int max2 = arr2[arr2.length - 1];

        int min3 = arr3[0];
        int max3 = arr3[arr3.length - 1];

        int min = Math.max(Math.max(min1, min2), min3);
        int max = Math.min(Math.min(max1, max2), max3);

        Map<Integer, Integer> map1 = getMap(arr1, min, max);
        Map<Integer, Integer> map2 = getMap(arr2, min, max);
        Map<Integer, Integer> map3 = getMap(arr3, min, max);

        Map<Integer, Integer> map12 = new HashMap<>();
        for (Integer key : map1.keySet()) {
            if (map2.get(key) != null) {
                map12.put(key, 2);
            }
        }

        Map<Integer, Integer> map123 = new HashMap<>();
        for (Integer key : map3.keySet()) {
            if (map12.get(key) != null) {
                map123.put(key, 3);
            }
        }

        List<Integer> result = new ArrayList<>(map123.keySet());
        Collections.sort(result);
        return result;

    }

    private static Map<Integer, Integer> getMap(int[] arr, int min, int max) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            if (isInValidRange(num, min, max)) {
                map.put(num, 1);
            }
        }
        return map;
    }

    private static boolean isInValidRange(int num, int min, int max) {
        return num >= min && num <= max;
    }
}
