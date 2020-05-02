package string;

public class _392 {

    //leverage the Java library string.indexOf(ch, int), it will start from index int, and look for the first ch, if
    // can't find it, then return -1
    public boolean isSubsequence(String s, String t) {
        char[] chars = s.toCharArray();
        int j = -1;
        for (char aChar : chars) {
            j = t.indexOf(aChar, j + 1);
            if (j == -1) {
                return false;
            }
        }
        return true;
    }

    /**
     * Double pointer, one point to the starting index of s, the other pointing to the starting index of t
     * if there is no match, we move j forward until we have a match, once we have a match, we move them both by one step.
     * if s is the subsequence of t, then i should be equal to len(s)
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence1(String s, String t) {
        int i = 0;
        int j = 0;
        int sLen = s.length();
        int tLen = t.length();
        while (i < sLen && j < tLen) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        return i == sLen;
    }


}
