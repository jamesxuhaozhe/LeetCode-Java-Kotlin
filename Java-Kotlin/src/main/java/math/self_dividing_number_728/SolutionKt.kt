package math.self_dividing_number_728

class SolutionKt {

    fun selfDividingNumbers(left: Int, right: Int): List<Int> {
        val result = arrayListOf<Int>()
        for (number in left..right) {
            if (isDividingNumber(number)) {
                result.add(number)
            }
        }

        return result
    }

    private fun isDividingNumber(number: Int): Boolean {
        val num = number
        var mutableNum = number
        while (mutableNum != 0) {
            val digit = mutableNum % 10
            if (digit == 0 || num % digit != 0) {
                return false
            }
            mutableNum /= 10
        }

        return true
    }
}