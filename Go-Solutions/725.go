package main


func splitListToParts(head *ListNode, k int) []*ListNode {
	length := getLength725(head)
	avg := length / k
	remainder := length % k

	res := make([]*ListNode, 0)
	cur := head
	for i := 0; i < k; i++ {
		dummy := &ListNode{
			Val:  0,
			Next: nil,
		}
		dummyRunner := dummy
		iterations := avg
		if i < remainder {
			iterations++
		}
		for j := 0; j < iterations; j++ {
			if cur != nil {
				dummyRunner.Next = &ListNode{
					Val:  cur.Val,
					Next: nil,
				}
				dummyRunner = dummyRunner.Next
				cur = cur.Next
			}
		}
		res = append(res, dummy.Next)
	}
	return res
}

func getLength725(head *ListNode) int {
	cur := head
	count := 0
	for cur != nil {
		cur = cur.Next
		count++
	}
	return count
}