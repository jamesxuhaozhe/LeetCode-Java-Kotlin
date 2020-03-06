package array.largest_unique_number_1133

import kotlin.math.max


class SolutionKt {

    fun largestUniqueNumber(A: IntArray): Int {
        val map = HashMap<Int, Int>()
        for (num in A) {
            if (map.containsKey(num)) {
                map[num] = map[num]!!.plus(1)
            } else {
                map[num] = 1
            }
        }

        var max = Integer.MIN_VALUE
        for ((key, value) in map) {
            if (value == 1) {
                max = max(key, max)
            }
        }

        return if (max == Integer.MIN_VALUE) -1 else max
    }
}