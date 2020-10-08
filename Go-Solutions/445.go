package main

// 方法1，是用reverse list的方法，然后用add two numbers的方法，然后再把结果reverse一下，
// https://leetcode-cn.com/problems/add-two-numbers-ii/solution/javakai-fa-by-sweetiee/
// 方法2，可以用两个栈，然后进行计算
func addTwoNumbers445(l1 *ListNode, l2 *ListNode) *ListNode {
	if l1 == nil {
		return l2
	}

	if l2 == nil {
		return l1
	}

	stack1 := createStack445()
	stack2 := createStack445()
	for l1 != nil {
		stack1.push(l1.Val)
		l1 = l1.Next
	}
	for l2 != nil {
		stack2.push(l2.Val)
		l2 = l2.Next
	}

	carry := 0
	tempSum := 0
	var head *ListNode = nil
	for !stack1.isEmpty() || !stack2.isEmpty() || carry > 0 {
		tempSum = carry
		if stack1.isEmpty() {
			tempSum += 0
		} else {
			tempSum += stack1.pop()
		}
		if stack2.isEmpty() {
			tempSum += 0
		} else {
			tempSum += stack2.pop()
		}
		node := &ListNode{
			Val:  tempSum % 10,
			Next: head,
		}
		head = node
		carry = tempSum / 10
	}
	return head
}

func createStack445() stack445 {
	return stack445{arr:make([]int, 0)}
}

type stack445 struct {
	arr []int
}

func (s *stack445) isEmpty() bool {
	return len(s.arr) == 0
}

func (s *stack445) push(val int) {
	s.arr = append(s.arr, val)
}

func (s *stack445) pop() int {
	len := len(s.arr)
	res := s.arr[len - 1]
	s.arr = s.arr[:len - 1]
	return res
}

func addTwoNumbers445_2(l1 *ListNode, l2 *ListNode) *ListNode {
	if l1 == nil {
		return l2
	}

	if l2 == nil {
		return l1
	}

	l1Rev := reverse445(l1)
	l2Rev := reverse445(l2)
	list := addlist445(l1Rev, l2Rev)
	return reverse445(list)
}

func addlist445(l1 *ListNode, l2 *ListNode) *ListNode {
	if l1 == nil {
		return l2
	}
	if l2 == nil {
		return l1
	}

	head := &ListNode{}
	n1, n2, carry, current := 0, 0, 0, head
	for l1 != nil || l2 != nil || carry > 0 {
		if l1 != nil {
			n1 = l1.Val
			l1 = l1.Next
		} else {
			n1 = 0
		}
		if l2 != nil {
			n2 = l2.Val
			l2 = l2.Next
		} else {
			n2 = 0
		}
		current.Next = &ListNode{
			Val:  (n1 + n2 + carry) % 10,
			Next: nil,
		}
		current = current.Next
		carry = (n1 + n2 + carry) / 10
	}
	return head.Next
}

func reverse445(head *ListNode) *ListNode {
	var newHead *ListNode = nil
	var next *ListNode = nil
	cur := head
	for cur != nil {
		next = cur.Next
		cur.Next = newHead
		newHead = cur
		cur = next
	}
	return newHead
}