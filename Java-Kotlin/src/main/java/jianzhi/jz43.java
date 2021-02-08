package jianzhi;

public class jz43 {

    private static void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
            start++;
            end--;
        }
    }

    // 看jianzhi offer 书，取巧罢了
    public String LeftRotateString(String str, int n) {
        if (str == null || str.length() == 0 || n == 0 || (n % str.length()) == 0) {
            return str;
        }

        char[] chars = str.toCharArray();
        reverse(chars, 0, n - 1);
        reverse(chars, n, chars.length - 1);
        reverse(chars, 0, chars.length - 1);
        return new String(chars);
    }
}
