package string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FlipGame {

    public List<String> generatePossibleNextMoves(String s) {
        if (s == null || s.isEmpty() || s.length() == 1) {
            return Collections.emptyList();
        }
        List<String> result = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == '+' && chars[i + 1] == '+') {
                chars[i] = '-';
                chars[i + 1] = '-';
                result.add(new String(chars));
                chars[i] = '+';
                chars[i + 1] = '+';
            }
        }
        return result;
    }
}
