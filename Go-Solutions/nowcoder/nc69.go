package nowcoder

func FindKthToTail( pListHead *ListNode ,  k int ) *ListNode {
	// write code here
	length := getLength(pListHead)
	if k > length {
		return nil
	}
	node := pListHead
	steps := length - k
	for i := 0; i < steps; i++ {
		node = node.Next
	}
	return node
}

func getLength(head *ListNode) int {
	cur := head
	count := 0
	for cur != nil {
		count++
		cur = cur.Next
	}
	return count
}