package linkedList._206

import common.datastructure.ListNodeKt

/**
 * Problem link: https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * Time complexity: O(n)
 *
 * Space complexity: O(1)
 */
class SolutionKt {

    fun reverseList(head: ListNodeKt?): ListNodeKt? {
        var headNode = head
        var newHead: ListNodeKt? = null
        while (headNode != null) {
            val next = headNode.next
            headNode.next = newHead
            newHead = headNode
            headNode = next

        }

        return newHead
    }
}