package hash._500;


import java.util.ArrayList;
import java.util.List;

public class SolutionGood {

    private static String[] ROWS = new String[]{
            "qwertyuiop",
            "asdfghjkl",
            "zxcvbnmm"
    };

    public String[] findWords(String[] words) {
        if (words == null || words.length == 0) {
            return words;
        }

        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (isValidWord(word.toLowerCase())) {
                res.add(word);
            }
        }
        return res.toArray(new String[res.size()]);

    }

    private boolean isValidWord(String word) {
        boolean isValid = true;
        String applicableRow = null;
        char[] chs = word.toCharArray();
        for (String row : ROWS) {
            if (row.indexOf(chs[0]) > -1) {
                applicableRow = row;
            }
        }

        if (applicableRow == null) {
            isValid = false;
            return isValid;
        }

        for (int i = 1; i < chs.length; i++) {
            if (applicableRow.indexOf(chs[i]) < 0) {
                isValid = false;
                return isValid;
            }
        }
        return isValid;
    }
}
