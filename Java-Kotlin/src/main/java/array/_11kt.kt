package array

import kotlin.math.max
import kotlin.math.min

class _11kt {

    fun maxArea(height: IntArray): Int {
        var maxArea = Int.MIN_VALUE
        var i = 0
        var j = height.size - 1
        while (i < j) {
            maxArea = max(maxArea, min(height[i], height[j]) * (j - i))
            if (height[i] <= height[j]) {
                i++
            } else {
                j--
            }
        }
        return maxArea
    }
}