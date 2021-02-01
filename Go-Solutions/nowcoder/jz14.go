package nowcoder

func FindKthToTailjz14(pListHead *ListNode, k int) *ListNode {
	// write code here
	if pListHead == nil {
		return nil
	}

	length := getLenjz14(pListHead)

	if k > length {
		return nil
	}

	node := pListHead
	for i := 0; i < length-k; i++ {
		node = node.Next
	}
	return node
}

func getLenjz14(listHead *ListNode) int {
	count := 0
	head := listHead
	for head != nil {
		count++
		head = head.Next
	}
	return count
}
