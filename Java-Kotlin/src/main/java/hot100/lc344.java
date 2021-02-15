package hot100;

public class lc344 {

    public void reverseString(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }

        int start = 0;
        int end = s.length - 1;
        while (start < end) {
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            start++;
            end--;
        }
    }
}
