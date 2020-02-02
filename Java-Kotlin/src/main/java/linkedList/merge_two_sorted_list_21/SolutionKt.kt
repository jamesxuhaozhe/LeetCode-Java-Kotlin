package linkedList.merge_two_sorted_list_21

import common.datastructure.ListNodeKt

class SolutionKt {

    fun mergeTwoLists(l1: ListNodeKt?, l2: ListNodeKt?): ListNodeKt? {
        if (l1 == null) {
            return l2
        }

        if (l2 == null) {
            return l1
        }

        return if (l1.`val` < l2.`val`) {
            l1.next = mergeTwoLists(l1.next, l2)
            l1
        } else {
            l2.next = mergeTwoLists(l1, l2.next)
            l2
        }
    }
}