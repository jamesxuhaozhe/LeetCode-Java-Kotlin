package nowcoder;

public class nc112 {

    private static final String TAB = "0123456789ABCDEF";

    public String solve (int m, int n) {
        // write code here
        if (m == 0) {
            return "0";
        }

        boolean isNeg = false;
        if (m < 0) {
            m = -m;
            isNeg = true;
        }

        StringBuilder sb = new StringBuilder();
        while (m != 0) {
            sb.append(TAB.charAt(m % n));
            m /= n;
        }
        if (isNeg) {
            sb.append('-');
        }
        return sb.reverse().toString();
    }
}
