package nowcoder;

public class nc89 {

    private static final int DIFF = 'A' - 'a';

    public static void main(String[] args) {
        System.out.println(new nc89().trans("This is a sample", 16));
    }

    public String trans(String s, int n) {
        // write code here

        if (s == null || s.length() == 0) {
            return s;
        }

        String[] arr = s.split(" ", -1);
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            String temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

        rebaseArr(arr);
        return String.join(" ", arr);
    }

    private void rebaseArr(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rebaseStr(arr[i]);
        }
    }

    private String rebaseStr(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(rebaseCh(str.charAt(i)));
        }
        return sb.toString();
    }

    private char rebaseCh(char ch) {
        if (ch >= 'a' && ch <= 'z') {
            return (char) (ch + DIFF);
        } else if (ch >= 'A' && ch <= 'Z') {
            return (char) (ch - DIFF);
        } else {
            return ch;
        }
    }
}
