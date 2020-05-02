package hash._500;

import java.util.*;

public class SolutionBad {

    private static Set<Integer> row1 = new HashSet<>();
    private static Set<Integer> row2 = new HashSet<>();
    private static Set<Integer> row3 = new HashSet<>();
    private static List<Set<Integer>> rows = Arrays.asList(row1, row2, row3);

    static {
        row1.add((int) 'q');
        row1.add((int) 'w');
        row1.add((int) 'e');
        row1.add((int) 'r');
        row1.add((int) 't');
        row1.add((int) 'y');
        row1.add((int) 'u');
        row1.add((int) 'i');
        row1.add((int) 'o');
        row1.add((int) 'p');

        row2.add((int) 'a');
        row2.add((int) 's');
        row2.add((int) 'd');
        row2.add((int) 'f');
        row2.add((int) 'g');
        row2.add((int) 'h');
        row2.add((int) 'j');
        row2.add((int) 'k');
        row2.add((int) 'l');

        row3.add((int) 'z');
        row3.add((int) 'x');
        row3.add((int) 'c');
        row3.add((int) 'v');
        row3.add((int) 'b');
        row3.add((int) 'n');
        row3.add((int) 'm');

    }

    public String[] findWords(String[] words) {
        if (words == null || words.length == 0) {
            return words;
        }
        List<String> result = new ArrayList<>();
        for (String word : words) {
            String allLowerWord = word.toLowerCase();
            char[] chars = allLowerWord.toCharArray();
            char firstChaToTest = chars[0];
            for (Set<Integer> row : rows) {
                if (row.contains((int) firstChaToTest)) {
                    boolean areCharactersAllinThisRow = true;
                    for (int i = 1; i < chars.length; i++) {
                        areCharactersAllinThisRow &= row.contains((int) chars[i]);
                    }
                    if (areCharactersAllinThisRow) {
                        result.add(word);
                    }
                }
            }
        }
        String[] results = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            results[i] = result.get(i);
        }
        return results;
    }

    public static void main(String[] args) {
        String[] results = new SolutionBad().findWords(new String[]{"Alaska", "Dad"});
        for (String word : results) {
            System.out.println(word);
        }
    }
}
