package array;

public class FixedPoint {

    public int fixedPoint(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] == i) {
                return i;
            }
        }
        return -1;
    }
}
