package linkedList.remove_linkedlist_element_203

import datastructure.ListNodeKt

class SolutionKt {

    fun removeElements(head: ListNodeKt?, `val`: Int): ListNodeKt? {

        val dummy = ListNodeKt(-1)
        dummy.next = head
        var curr = head
        var prev = dummy
        while (curr != null) {
            if (curr.`val` == `val`) {
                prev.next = curr.next
            } else {
                prev = prev.next!!
            }
            curr = curr.next
        }
        return dummy.next
    }
}