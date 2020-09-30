package jianzhi

// https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
func deleteNode(head *ListNode, val int) *ListNode {
	dummy := &ListNode{
		Val:  0,
		Next: head,
	}
	pre := dummy
	cur := head
	for cur != nil {
		if cur.Val == val {
			pre.Next = cur.Next
			break
		}
		pre = cur
		cur = cur.Next
	}
	return dummy.Next
}
