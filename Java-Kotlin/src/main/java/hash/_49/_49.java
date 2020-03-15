package hash._49;

import java.util.*;

public class _49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return Collections.emptyList();
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String basicOrderStr = getBasicOrderStr(str);
            if (map.containsKey(basicOrderStr)) {
                map.get(basicOrderStr).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(basicOrderStr, list);
            }
        }

        List<List<String>> result = new ArrayList<>(map.values());
        return result;
    }

    private static String getBasicOrderStr(String str) {
        if (str.equals("")) {
            return "empty";
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            pq.add((int) aChar);
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            sb.append(pq.poll());
        }

        return sb.toString();
    }


    public List<List<String>> groupAnagrams1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return Collections.emptyList();
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] ca = str.toCharArray();
            Arrays.sort(ca);
            String basicOrderStr = String.valueOf(ca);
            if (!map.containsKey(basicOrderStr)) {
                map.put(basicOrderStr, new ArrayList<>());
            }
            map.get(basicOrderStr).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
