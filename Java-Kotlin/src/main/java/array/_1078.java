package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem link: https://leetcode-cn.com/problems/occurrences-after-bigram/
 * <p>
 * Time complexity: O(n)
 * <p>
 * Space complexity: O(n)
 */
public class _1078 {

    public String[] findOcurrences(String text, String first, String second) {
        if (text == null || first == null || second == null) {
            return new String[0];
        }
        String[] textArray = text.split(" ");
        if (textArray.length < 3) {
            return new String[0];
        }
        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < textArray.length - 2; i++) {
            int secondIndex = i + 1;
            if (first.equalsIgnoreCase(textArray[i]) && second.equalsIgnoreCase(textArray[secondIndex])) {
                resultList.add(textArray[i + 2]);
            }
        }

        String[] result = new String[resultList.size()];
        int idx = 0;
        for (String str : resultList) {
            result[idx] = str;
            idx++;
        }

        return result;
    }
}
