package linkedList._24

import common.datastructure.ListNodeKt

class SolutionKt {

    fun swapPairs(head: ListNodeKt?): ListNodeKt? {

        val head = head

        if (head?.next == null) {
            return head
        }

        val second = head.next
        val third = second!!.next
        second.next = head
        head.next = swapPairs(third)
        return second
    }
}