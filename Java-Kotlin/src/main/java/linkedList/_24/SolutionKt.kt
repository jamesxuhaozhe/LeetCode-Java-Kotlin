package linkedList._24

import common.datastructure.ListNodeKt

class SolutionKt {

    fun swapPairs(head: ListNodeKt?): ListNodeKt? {

        var head = head

        if (head?.next == null) {
            return head
        }

        var second = head.next
        var third = second!!.next
        second.next = head
        head.next = swapPairs(third)
        return second
    }
}