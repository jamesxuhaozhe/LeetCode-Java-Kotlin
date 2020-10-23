package string._1108;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().defangIPaddr("139.168.34.56"));
    }

    public String defangIPaddr(String address) {
        if (address == null || address.isEmpty()) {
            return null;
        }

        char[] chars = address.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char ch : chars) {
            if (ch == '.') {
                sb.append("[.]");
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
