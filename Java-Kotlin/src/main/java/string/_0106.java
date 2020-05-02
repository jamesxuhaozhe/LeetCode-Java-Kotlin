package string;

public class _0106 {
    //TODO: to understand it better
    public String compressString(String S) {
        if (S == null || S.length() <= 2) {
            return S;
        }
        StringBuilder sb = new StringBuilder().append(S.charAt(0));
        int cnt = 1;
        for (int i = 1; i < S.length(); i++) {
            // 如果i与i-1相同，cnt累加
            if (S.charAt(i) == S.charAt(i - 1)) {
                cnt++;
            } else {
                // 否则拼接上i-1的次数，从i开始重新计数
                sb.append(cnt).append(S.charAt(i));
                cnt = 1;
            }
        }
        return sb.append(cnt).length() < S.length() ? sb.toString() : S;
    }
}
