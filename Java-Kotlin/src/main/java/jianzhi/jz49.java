package jianzhi;

public class jz49 {

    // jianzhi offer
    public int StrToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        boolean isNeg = str.charAt(0) == '-';
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i == 0 && (c == '+' || c == '-')) {
                continue;
            }
            if (c < '0' || c > '9') {
                return 0;
            }
            result = result * 10 + (c - '0');
        }
        if (isNeg) {
            return -result;
        }
        return result;
    }
}
