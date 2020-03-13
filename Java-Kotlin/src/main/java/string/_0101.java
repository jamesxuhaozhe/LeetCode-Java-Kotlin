package string;

public class _0101 {
    public boolean isUnique(String astr) {
        int[] array = new int[26];
        for (int i = 0; i < astr.toCharArray().length; i++) {
            int index = astr.charAt(i) - 'a';
            array[index]++;
            if (array[index] > 1) {
                return false;
            }
        }
        return true;
    }
}
