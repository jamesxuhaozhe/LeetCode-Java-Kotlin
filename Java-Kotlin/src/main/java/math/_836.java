package math;

public class _836 {

    private static int[][] getPoints(int[] rec) {
        return new int[][]{
                {rec[0], rec[1]},
                {rec[0], rec[3]},
                {rec[2], rec[1]},
                {rec[2], rec[3]}
        };
    }

    private static boolean isWithinRec(int[] rec, int[] point) {
        if (point[0] < rec[2] && point[0] > rec[0]) {
            if (point[1] < rec[3] && point[1] > rec[1]) {
                return true;
            }
        }
        return false;
    }

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int[][] rec1Points = getPoints(rec1);
        for (int[] point : rec1Points) {
            if (isWithinRec(rec2, point)) {
                return true;
            }
        }
        int[][] rec2Points = getPoints(rec2);
        for (int[] point : rec2Points) {
            if (isWithinRec(rec1, point)) {
                return true;
            }
        }
        return false;
    }
}
