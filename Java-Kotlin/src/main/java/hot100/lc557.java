package hot100;

public class lc557 {

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        char[] chars = s.toCharArray();
        int i = 0;
        while (i < chars.length) {
            int start = i;
            while (i < chars.length && chars[i] != ' ') {
                i++;
            }
            swap(chars, start, i - 1);
            while(i < chars.length && chars[i] == ' ') {
                i++;
            }
        }
        return new String(chars);
    }

    private static void swap(char[] chars, int start, int end) {
        while (start < end) {
            char tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
            start++;
            end--;
        }
    }
}
