package competition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _5543 {

    public int maxLengthBetweenEqualCharacters(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i);
            if (map.containsKey(ch)) {
                map.get(ch).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(ch, list);
            }
        }

        int result = -1;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            if (list.size() > 1) {
                for (int i = 0; i < list.size(); i++) {
                    for (int j = 0; j < list.size(); j++) {
                        if (i != j) {
                            int dis = Math.abs(list.get(i) - list.get(j)) - 1;
                            result = Math.max(result, dis);
                        }
                    }
                }
            }
        }
        return result;
    }

//    public static void main(String[] args) {
//        String s= "aa";
//        //System.out.println(new _5543().maxLengthBetweenEqualCharacters(s));
//
//        s = "cabbac";
//        System.out.println(new _5543().maxLengthBetweenEqualCharacters(s));
//    }
}
