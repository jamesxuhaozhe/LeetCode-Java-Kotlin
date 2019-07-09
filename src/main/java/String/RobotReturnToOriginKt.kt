package String

class RobotReturnToOriginKt {
    fun judgeCircle(moves: String): Boolean {
        if (moves.isBlank()) {
            return true
        }
        var L = 0
        var U = 0
        val chars = moves.toCharArray()
        for (char in chars) {
            if (char == 'L') {
                L++
            }
            if (char == 'R') {
                L--
            }
            if (char == 'D') {
                U--
            }
            if (char == 'U') {
                U++
            }
        }

        return (L == 0) && (U == 0)
    }

    fun judgeCircleAnotherSolution(moves: String): Boolean {
        if (moves.isBlank()) {
            return true
        }
        val L = moves.count { ch -> ch == 'L' }
        val R = moves.count { ch -> ch == 'R' }
        val U = moves.count { ch -> ch == 'U' }
        val D = moves.count { ch -> ch == 'D' }
        return (L == R) && (U == D)
    }
}