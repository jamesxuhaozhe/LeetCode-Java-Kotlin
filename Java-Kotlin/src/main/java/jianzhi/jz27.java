package jianzhi;

import java.util.ArrayList;
import java.util.TreeSet;

public class jz27 {


    private ArrayList<String> result = new ArrayList<>();

    private TreeSet<String> set = new TreeSet<>();

    public ArrayList<String> Permutation(String str) {
        if (str == null || str.length() == 0) {
            return result;
        }

        permutation(str.toCharArray(), 0);
        result.addAll(set);
        return result;
    }

    private void permutation(char[] chars, int begin) {
        if (begin == chars.length - 1) {
            set.add(String.valueOf(chars));
            return;
        }

        for (int i = begin; i < chars.length; i++) {
            swap(chars, begin, i);
            permutation(chars, begin + 1);
            swap(chars, begin, i);
        }
    }

    private void swap(char[] chars, int beginIdx, int endIdx) {
        char tmp = chars[beginIdx];
        chars[beginIdx] = chars[endIdx];
        chars[endIdx] = tmp;
    }
}
