package math.number_of_days_in_a_month_1118

class SolutionKt {

    companion object {
        val LEAP_YEAR = intArrayOf(31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)

        val NON_LEAP_YEAR = intArrayOf(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
    }
    fun numberOfDays(Y: Int, M: Int): Int {
        return if ((Y % 100 != 0 && Y % 4 == 0) || (Y % 100 == 0 && Y % 400 == 0)) {
            LEAP_YEAR[M - 1]
        } else {
            NON_LEAP_YEAR[M - 1]
        }
    }
}