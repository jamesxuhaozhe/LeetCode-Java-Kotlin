package array._249;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _249 {

    private static final char[] CHARS = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    private static final int ALPHA_SIZE = 26;

    public List<List<String>> groupStrings(String[] strings) {
        if (strings == null || strings.length == 0) {
            return Collections.emptyList();
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strings) {
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
        if (chars.length == 1) {
            return "single";
        }

        int diff = 'z' - chars[0];
        StringBuilder sb = new StringBuilder("z");
        for (int i = 1; i < chars.length; i++) {
            int targetIndex = (chars[i] + diff) % ALPHA_SIZE;
            sb.append(CHARS[targetIndex]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strings = new String[] {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
        System.out.println(new _249().groupStrings(strings));
    }
}
