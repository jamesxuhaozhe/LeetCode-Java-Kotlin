package nowcoder

func FindFirstCommonNode( pHead1 *ListNode ,  pHead2 *ListNode ) *ListNode {
	// write code here
	if pHead1 == nil || pHead2 == nil {
		return nil
	}
	runner1, runner2 := pHead1, pHead2
	for runner1 != runner2 {
		if runner1 == nil {
			runner1 = pHead2
		} else {
			runner1 = runner1.Next
		}
		if runner2 == nil {
			runner2 = pHead1
		} else {
			runner2 = runner2.Next
		}
	}
	return runner1
}
