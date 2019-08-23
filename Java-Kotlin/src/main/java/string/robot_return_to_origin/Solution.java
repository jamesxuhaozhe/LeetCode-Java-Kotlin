package string.robot_return_to_origin;

public class Solution {

    public boolean judgeCircle(String moves) {
        if (moves == null) {
            return true;
        }
        int Unums = 0;
        int Lnums = 0;
        char[] chars = moves.toCharArray();
        for (char aChar : chars) {
            if (aChar == 'U') {
                Unums++;
            }
            if (aChar == 'D') {
                Unums--;
            }
            if (aChar == 'L') {
                Lnums++;
            }
            if (aChar == 'R') {
                Lnums--;
            }
        }
        return (Unums == 0) && (Lnums == 0);
    }
}
