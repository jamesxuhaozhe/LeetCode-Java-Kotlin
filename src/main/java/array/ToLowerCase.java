package array;

public class ToLowerCase {

    public String toLowerCase(String str) {
        int offset = 'A' - 'a';
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] <= 'Z' && chars[i] >= 'A') {
                chars[i] = (char) (chars[i] - offset);
            }
        }
        return new String(chars);
    }
}
