package linkedList._234

import common.datastructure.ListNodeKt

/**
 * Problem link: https://leetcode-cn.com/problems/palindrome-linked-list/
 *
 * Time and Space complexity: O(n)
 *
 * TODO: there got be a better solution
 */
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