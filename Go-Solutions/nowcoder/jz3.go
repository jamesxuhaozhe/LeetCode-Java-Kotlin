package nowcoder

func printListFromTailToHead(head *ListNode) []int {
	// write code here

	if head == nil {
		return []int{}
	}

	stack := make([]int, 0)
	runner := head
	for runner != nil {
		stack = append(stack, runner.Val)
		runner = runner.Next
	}

	res := make([]int, 0)
	for len(stack) != 0 {
		value := stack[len(stack)-1]
		stack = stack[:len(stack)-1]
		res = append(res, value)
	}
	return res
}

func printListFromTailToHead_2(head *ListNode) []int {
	if head == nil {
		return []int{}
	}

	newHead := reversejz3(head)
	res := make([]int, 0)
	for newHead != nil {
		res = append(res, newHead.Val)
		newHead = newHead.Next
	}

	return res
}

func reversejz3(head *ListNode) *ListNode {
	var newHead *ListNode = nil
	var next *ListNode = nil
	runner := head
	for runner != nil {
		next = runner.Next
		runner.Next = newHead
		newHead = runner
		runner = next
	}
	return newHead
}
