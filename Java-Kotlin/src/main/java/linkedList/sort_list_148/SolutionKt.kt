package linkedList.sort_list_148

import datastructure.ListNodeKt

class SolutionKt {

    fun sortList(head: ListNodeKt?): ListNodeKt? {

        var prev: ListNodeKt? = null
        var slow = head
        var fast = head

        while (fast != null && fast.next != null) {
            prev = slow
            fast = fast.next!!.next
            slow = slow!!.next
        }

        prev!!.next = null

        val l1 = sortList(head)
        val l2 = sortList(slow)

        return merge(l1, l2)
    }

    private fun merge(l1: ListNodeKt?, l2: ListNodeKt?): ListNodeKt? {
        val result = ListNodeKt(-1)
        var tmp = result

        var l1 = l1
        var l2 = l2

        while (l1 != null && l2 != null) {
            if (l1.`val` < l2.`val`) {
                tmp.next = l1
                l1 = l1.next
            } else {
                tmp.next = l2
                l2 = l2.next
            }

            tmp = tmp.next!!
        }

        if (l1 != null) {
            tmp.next = l1
        }

        if (l2 != null) {
            tmp.next = l2
        }

        return result.next
    }
}