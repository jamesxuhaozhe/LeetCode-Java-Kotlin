package string;

import java.util.*;

public class LetterCombinationOfAPhoneNumber {

    private static Map<String, List<String>> KEY_BOARDS = new HashMap<>();

    static {
        KEY_BOARDS.put("2", Arrays.asList("a", "b", "c"));
        KEY_BOARDS.put("3", Arrays.asList("d", "e", "f"));
        KEY_BOARDS.put("4", Arrays.asList("g", "h", "i"));
        KEY_BOARDS.put("5", Arrays.asList("j", "k", "l"));
        KEY_BOARDS.put("6", Arrays.asList("m", "n", "o"));
        KEY_BOARDS.put("7", Arrays.asList("p", "q", "r", "s"));
        KEY_BOARDS.put("8", Arrays.asList("t", "u", "v"));
        KEY_BOARDS.put("9", Arrays.asList("w", "x", "y", "z"));
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return Collections.emptyList();
        }

        if (digits.length() == 1) {
            return KEY_BOARDS.get(String.valueOf(digits.charAt(0)));
        }
        int digitLen = digits.length();
        List<String> previousResult = letterCombinations(digits.substring(0, digitLen - 1));
        List<String> current = KEY_BOARDS.get(String.valueOf(digits.charAt(digitLen - 1)));
        List<String> result = new ArrayList<>();
        for (String str : previousResult) {
            for (String cur : current) {
                result.add(str + cur);
            }
        }
        return result;
    }
}
