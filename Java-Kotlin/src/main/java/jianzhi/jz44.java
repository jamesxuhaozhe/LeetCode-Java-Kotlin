package jianzhi;

public class jz44 {

    private static void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
            start++;
            end--;
        }
    }

    // jianzhi offer book classic 题目，todo use golang
    public String ReverseSentence(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }

        int length = str.length();
        char[] chars = str.toCharArray();
        reverse(chars, 0, length - 1);

        int i = 0;
        int j = 0;
        while (j <= length) {
            // 当已经结束 或者遇到 空格
            if (j == length || chars[j] == ' ') {
                reverse(chars, i, j - 1);
                i = j + 1;
            }
            j++;
        }
        return new String(chars);
    }
}
