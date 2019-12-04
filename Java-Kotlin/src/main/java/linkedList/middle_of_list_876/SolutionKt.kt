package linkedList.middle_of_list_876

import datastructure.ListNodeKt

class SolutionKt {

    fun middleNode(head: ListNodeKt?): ListNodeKt? {

        if (head == null || head.next == null) {
            return head
        }

        var len = 0
        var curr = head
        var dummyHead = head
        while (dummyHead != null) {
            dummyHead = dummyHead.next
            len++
        }

        var move = len / 2
        while (move-- > 0) {
            curr = curr!!.next
        }

        return curr
    }
}