package math.number_of_days_in_a_month_1118;

public class Solution {

    private static final int[] LEAP_YEAR = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private static final int[] NON_LEAP_YEAR = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int numberOfDays(int Y, int M) {
        if ((Y % 100 != 0 && Y % 4 == 0) || (Y % 100 == 0 && Y % 400 == 0)) {
            return LEAP_YEAR[M - 1];
        } else {
            return NON_LEAP_YEAR[M - 1];
        }
    }
}
