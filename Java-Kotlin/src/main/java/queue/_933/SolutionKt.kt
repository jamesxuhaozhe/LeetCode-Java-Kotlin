package queue._933

import java.util.*

class SolutionKt {
    private val queue = ArrayDeque<Int>()

    fun ping(t: Int): Int {
        queue.offer(t)
        while (queue.peek() < (t - 3000)) {
            queue.remove()
        }
        return queue.size
    }
}