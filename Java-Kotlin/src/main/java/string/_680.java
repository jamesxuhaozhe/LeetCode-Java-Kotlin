package string;

public class _680 {

    private static boolean isPalindrome(String str) {
        if (str.isEmpty()) {
            return true;
        }

        int left = 0;
        int right = str.length() - 1;
        while (left <= right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new _680().validPalindrome("abca"));
    }

    /**
     * Bad solution, there should be a better one. TODO: get a better solution
     *
     * @param s
     * @return
     */
    public boolean validPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        if (isPalindrome(s)) {
            return true;
        }

        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s.substring(0, i) + s.substring(i + 1))) {
                return true;
            }
        }

        return false;
    }
}
