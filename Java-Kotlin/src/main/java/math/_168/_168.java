package math._168;

public class _168 {

    private static final String ALPHA = "ZABCDEFGHIJKLMNOPQRSTUVWXY";

    /**
     * https://leetcode-cn.com/problems/excel-sheet-column-title/solution/zhuan-huan-wei-chuan-tong-jin-zhi-fang-shi-ji-suan/
     * @param n
     * @return
     */
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            int remainder = n % 26;
            n /= 26;
            if (remainder == 0) {
                n--;
            }
            sb.append(ALPHA.charAt(remainder));
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new _168().convertToTitle(52));
    }
}
