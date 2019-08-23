package string.unique_morse_code_words_804;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    private static String[] MORSE_CODE_TABLE = new String[]
            {".-", "-...", "-.-.", "-..", ".", "..-.",
                    "--.", "....", "", ".---", "-.-", ".-..",
                    "--", "-.", "---", ".--.", "--.-", ".-.",
                    "...", "-", "..-", "...-", ".--", "-..-",
                    "-.--", "--.."};

    public int uniqueMorseRepresentations(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }

        Set<String> uniqueMorseCodes = new HashSet<>();

        for (String word : words) {
            if (word == null) {
                continue;
            }
            char[] chars = word.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (char ch : chars) {
                sb.append(MORSE_CODE_TABLE[ch - 'a']);
            }
            uniqueMorseCodes.add(sb.toString());
        }
        return uniqueMorseCodes.size();
    }
}
