package design._359

class SolutionKt {

    private val map = HashMap<String, Int>()

    fun shouldPrintMessage(timestamp: Int, message: String): Boolean {

        if (message in map) {
            val lastPrintTimestamp = map[message]!!
            return if (timestamp - lastPrintTimestamp < 10) {
                false
            } else {
                map[message] = timestamp
                true
            }
        }

        map[message] = timestamp
        return true
    }

}