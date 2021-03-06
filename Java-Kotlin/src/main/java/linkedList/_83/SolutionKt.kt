package linkedList._83

import common.datastructure.ListNodeKt

class SolutionKt {
    fun deleteDuplicates(head: ListNodeKt?): ListNodeKt? {

        val dummy = ListNodeKt(-1)
        dummy.next = head
        var headDum = head
        while (headDum != null) {
            while (headDum.next != null && headDum.`val` == headDum.next!!.`val`) {
                headDum.next = headDum.next!!.next
            }
            headDum = headDum.next
        }

        return dummy.next
    }
}