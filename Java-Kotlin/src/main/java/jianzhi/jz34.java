package jianzhi;

public class jz34 {

    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        int[] flags = new int[256];
        char[] chars = str.toCharArray();
        for (char ch : chars) {
            flags[ch]++;
        }

        for (int i = 0; i < chars.length; i++) {
            if (flags[chars[i]] == 1) {
                return i;
            }
        }
        return -1;
    }
}
