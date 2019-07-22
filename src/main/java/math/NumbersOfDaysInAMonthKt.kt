package math

class NumbersOfDaysInAMonthKt {
    companion object {
        val LEAP_YEAR = intArrayOf(31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)

        val NON_LEAP_YEAR = intArrayOf(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
    }
    fun numberOfDays(Y: Int, M: Int): Int {
        if ((Y % 100 != 0 && Y % 4 == 0) || (Y % 100 == 0 && Y % 400 == 0)) {
            return LEAP_YEAR[M - 1]
        } else {
            return NON_LEAP_YEAR[M - 1]
        }
    }
}