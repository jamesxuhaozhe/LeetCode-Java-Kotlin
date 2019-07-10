package string;

public class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        if (s == null || t == null) {
            return false;
        }

        if (s.isEmpty() && t.isEmpty()) {
            return false;
        }

        if (s.length() == t.length()) {
            return isOneReplaceDistance(s, t);
        }

        if (s.length() + 1 == t.length()) {
            return isOneInsertDistance(s, t);
        }

        if (s.length() - 1 == t.length()) {
            return isOneInsertDistance(t, s);
        }

        return false;
    }

    private boolean isOneInsertDistance(String s, String t) {
        int index1 = 0;
        int index2 = 0;
        while (index1 < s.length() && index2 < t.length()) {
            if (s.charAt(index1) != t.charAt(index2)) {
                if (index1 != index2) {
                    return false;
                }
                index2++;
            } else {
                index1++;
                index2++;
            }
        }
        return true;
    }

    private boolean isOneReplaceDistance(String s, String t) {
        if (s.equals(t)) {
            return false;
        }
        if (s.length() == 1 && (s.charAt(0) != t.charAt(0))) {
            return true;
        }

        boolean foundDifference = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (foundDifference) {
                    return false;
                }
                foundDifference = true;
            }
        }
        return true;
    }
}
