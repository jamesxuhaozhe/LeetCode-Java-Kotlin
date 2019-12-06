package system_design.logger_rate_limitter_359

class SolutionKt {

    private val map = HashMap<String, Int>()

    fun shouldPrintMessage(timestamp: Int, message: String): Boolean {

        if (message in map) {
            val lastPrintTimestamp = map[message]!!
            if (timestamp - lastPrintTimestamp < 10) {
                return false
            } else {
                map[message] = timestamp
                return true
            }
        }

        map[message] = timestamp
        return true
    }

}