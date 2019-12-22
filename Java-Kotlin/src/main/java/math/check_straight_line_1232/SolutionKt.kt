package math.check_straight_line_1232


/**
 * Time complexity: O(n)
 *
 * Space complexity: O(1)
 */
class SolutionKt {

    fun checkStraightLine(coordinates: Array<IntArray>): Boolean {
        val initialPoint = coordinates[0]
        val secondPoint = coordinates[1]

        val deltaX = secondPoint[0] - initialPoint[0]
        val deltaY = secondPoint[1] - initialPoint[1]

        for (index in 2 until coordinates.size) {
            val currentPoint = coordinates[index]

            val x = currentPoint[0] - initialPoint[0]
            val y = currentPoint[1] - initialPoint[1]

            if (deltaX * y != deltaY * x) {
                return false
            }
        }

        return true
    }
}