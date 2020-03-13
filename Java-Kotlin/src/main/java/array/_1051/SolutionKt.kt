package array._1051

import java.util.*

class SolutionKt {

    fun heightChecker(heights: IntArray): Int {
        if (heights.isEmpty()) {
            return 0
        }
        val helperArray = heights.copyOf(heights.size)
        Arrays.sort(helperArray)
        var diff = 0
        for (index in heights.indices) {
            if (heights[index] != helperArray[index]) {
                diff++
            }
        }
        return diff
    }
}