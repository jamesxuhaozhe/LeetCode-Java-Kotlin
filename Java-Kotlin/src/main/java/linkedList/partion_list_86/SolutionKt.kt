package linkedList.partion_list_86

import datastructure.ListNodeKt

class SolutionKt {

    fun partition(head: ListNodeKt?, x: Int): ListNodeKt? {

        if (head == null || head.next == null) {
            return head
        }
        var head = head
        var less = ListNodeKt(-1)
        var greater = ListNodeKt(-1)

        val left = less
        val right = greater
        less.next = head
        while (head != null) {
            if (head.`val` < x) {
                less.next = head
                less = less.next!!
            } else {
                greater.next = head
                greater = greater.next!!
            }
            head = head.next
        }
        greater.next = null
        less.next = right.next
        return left.next
    }
}