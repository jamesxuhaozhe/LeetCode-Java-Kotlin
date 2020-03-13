package linkedList._92

import common.datastructure.ListNodeKt

class SolutionKt {

    fun reverseBetween(head: ListNodeKt?, m: Int, n: Int): ListNodeKt? {
        val dummy = ListNodeKt(0)
        dummy.next = head
        var pre = dummy
        for (index in 0 until m - 1) {
            pre = pre.next!!
        }
        val start = pre.next
        var end: ListNodeKt? = start
        for (index in 0 until n - m) {
            end = end!!.next
        }
        val headOfRemained: ListNodeKt? = end!!.next
        end.next = null
        pre.next = reverse(start!!)
        start.next = headOfRemained
        return dummy.next
    }

    private fun reverse(head: ListNodeKt): ListNodeKt? {
        var pre: ListNodeKt? = null
        var curr: ListNodeKt? = head
        while (curr != null) {
            val next = curr.next
            curr.next = pre
            pre = curr
            curr = next
        }
        return pre
    }
}