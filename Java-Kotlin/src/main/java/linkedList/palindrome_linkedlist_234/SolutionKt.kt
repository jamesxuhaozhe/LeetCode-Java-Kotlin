package linkedList.palindrome_linkedlist_234

import datastructure.ListNodeKt

class SolutionKt {

    fun isPalindrome(head: ListNodeKt?): Boolean {
        if (head == null) {
            return true
        }

        val list = arrayListOf<Int>()

        var dummy = head
        while (dummy != null) {
            list.add(dummy.`val`)
            dummy = dummy.next
        }

        var first = 0
        var last = list.size - 1
        while (first < last) {
            if (list[first] != list[last]) {
                return false
            }
            first++
            last--
        }

        return true
    }
}