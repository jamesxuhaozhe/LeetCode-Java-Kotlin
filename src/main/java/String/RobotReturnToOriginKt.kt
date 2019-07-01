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
        var L = moves.count { ch -> ch == 'L' }
        var R = moves.count { ch -> ch == 'R' }
        var U = moves.count { ch -> ch == 'U' }
        var D = moves.count { ch -> ch == 'D' }
        return (L == R) && (U == D)
    }
}