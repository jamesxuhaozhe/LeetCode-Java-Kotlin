package string._344;

public class Solution {

    public void reverseString(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }

        int i = 0;
        int j = s.length - 1;
        char middle = 'a';
        while (i < j) {
            middle = s[j];
            s[j] = s[i];
            s[i] = middle;
            i++;
            j--;
        }
    }
}
