package queue

import java.util.*

class NumberOfRecentCallsKt {
    private val queue = ArrayDeque<Int>()

    fun ping(t: Int): Int {
        queue.offer(t)
        while (queue.peek() < (t - 3000)) {
            queue.remove()
        }
        return queue.size
    }
}