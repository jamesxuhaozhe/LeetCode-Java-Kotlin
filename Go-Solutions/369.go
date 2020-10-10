package main

type stack469 struct {
	arr []int
}

func (s *stack469) push(val int) {
	s.arr = append(s.arr, val)
}

func (s *stack469) pop() int {
	length := len(s.arr)
	res := s.arr[length-1]
	s.arr = s.arr[:length-1]
	return res
}

func (s *stack469) isEmpty() bool {
	return len(s.arr) == 0
}

func getStack() stack469 {
	return stack469{arr: make([]int, 0)}
}

// like problem 445
func plusOne(head *ListNode) *ListNode {
	if head == nil {
		return head
	}

	stack := getStack()
	cur := head
	for cur != nil {
		stack.push(cur.Val)
		cur = cur.Next
	}

	var newHead *ListNode = nil
	carry := 1
	for !stack.isEmpty() || carry > 0 {
		sum := carry
		if !stack.isEmpty() {
			sum += stack.pop()
		}
		node := &ListNode{
			Val:  sum % 10,
			Next: newHead,
		}
		newHead = node
		carry = sum / 10
	}
	return newHead
}
