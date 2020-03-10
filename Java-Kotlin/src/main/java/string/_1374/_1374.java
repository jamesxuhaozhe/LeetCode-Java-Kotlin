package string._1374;

public class _1374 {

    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        if ((n & 1) != 1) {
            sb.append("b");
            for (int i = 0; i < n - 1; i++) {
                sb.append("a");
            }
        } else {
            for (int i = 0; i < n; i++) {
                sb.append("a");
            }
        }
        return sb.toString();
    }
}
