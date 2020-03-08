package string._151;

public class _151 {

    private static final String SPLITTER = " ";

    //Naive solution TODO need better solution
    public String reverseWords(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        String[] strs = s.trim().split(SPLITTER);
        StringBuilder sb = new StringBuilder(strs[strs.length - 1]);
        for (int i = strs.length - 2; i >= 0; i--) {
            if (!strs[i].isEmpty()) {
                sb.append(SPLITTER);
                sb.append(strs[i]);
            }
        }

        return sb.toString();
    }
}
