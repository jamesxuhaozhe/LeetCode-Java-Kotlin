package linkedList.delete_dup_nodes_82

import common.datastructure.ListNodeKt

class SolutionKt {

    fun deleteDuplicates(head: ListNodeKt?): ListNodeKt? {

        if (head == null) {
            return head
        }

        val fakeHead = ListNodeKt(-1)
        fakeHead.next = head
        var pre = fakeHead
        var curr = head
        while (curr != null) {
            while (curr!!.next != null && curr.`val` == curr.next!!.`val`) {
                curr = curr.next
            }
            if (pre.next == curr) {
                pre = pre.next!!
            } else {
                pre.next = curr.next
            }
            curr = curr.next
        }

        return fakeHead.next
    }
}