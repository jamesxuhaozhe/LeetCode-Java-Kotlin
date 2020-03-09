package array._249;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _249 {

    private static final int ALPHA_SIZE = 26;

    public List<List<String>> groupStrings(String[] strings) {
        if (strings == null || strings.length == 0) {
            return Collections.emptyList();
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strings) {
            //每个string 以，第一个char为例，rebase到以z为开头的string作为key
            String key = getKey(str);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }

    private static String getKey(String str) {
        if (str.isEmpty()) {
            return "empty";
        }

        char[] chars = str.toCharArray();
        // string 长度为1的，都是等效的
        if (chars.length == 1) {
            return "single";
        }

        int diff = 'z' - chars[0];
        StringBuilder sb = new StringBuilder("z");
        for (int i = 1; i < chars.length; i++) {
            int targetIndex = (chars[i] + diff) % ALPHA_SIZE;
            char ch = (char) ('a' + targetIndex);
            sb.append(ch);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strings = new String[] {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
        System.out.println(new _249().groupStrings(strings));
    }
}
