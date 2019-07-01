package String;

public class RobotReturnToOrigin {
    public boolean judgeCircle(String moves) {
        if (moves == null) {
            return true;
        }
        int Unums = 0;
        int Lnums = 0;
        char[] chars = moves.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'U') {
                Unums++;
            }
            if (chars[i] == 'D') {
                Unums--;
            }
            if (chars[i] == 'L') {
                Lnums++;
            }
            if (chars[i] == 'R') {
                Lnums--;
            }
        }
        return (Unums == 0) && (Lnums == 0);
    }
}
