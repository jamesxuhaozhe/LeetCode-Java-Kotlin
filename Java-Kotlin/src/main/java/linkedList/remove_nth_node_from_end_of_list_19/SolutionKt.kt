package linkedList.remove_nth_node_from_end_of_list_19

import datastructure.ListNodeKt

class SolutionKt {

    fun removeNthFromEnd(head: ListNodeKt?, n: Int): ListNodeKt? {
        var temp = head
        var len = 0
        while (temp != null) {
            temp = temp.next
            len++
        }

        if (n == len) {
            return head!!.next
        }

        var moves = len - n
        temp = head
        while (moves-- > 1) {
            temp = temp!!.next
        }

        if (temp!!.next != null) {
            temp.next = temp.next!!.next
            return head
        }

        return null
    }
}