package main

func copyRandomList_138(head *Node) *Node {
	if head == nil {
		return head
	}

	// 第一步是在原始的每个node之后都建立一个新node，然后插在原来的node之后
	cur := head
	for cur != nil {
		next := cur.Next
		copyNode := &Node{
			Val:    cur.Val,
			Next:   next,
			Random: nil,
		}
		cur.Next = copyNode
		cur = next
	}

	// 因为第一步的原因，建立random链接就很方便
	cur = head
	for cur != nil {
		copyNode := cur.Next
		if cur.Random != nil {
			copyNode.Random = cur.Random.Next
		}
		cur = copyNode.Next
	}

	originDummy, resDummy := &Node{}, &Node{}
	originRunner, resRunner := originDummy, resDummy
	count := 1

	// 最后一步是进行拆分，同时需要还原原有链表
	cur = head
	for cur != nil {
		if count%2 == 1 {
			originRunner.Next = cur
			originRunner = originRunner.Next
		} else {
			resRunner.Next = cur
			resRunner = resRunner.Next
		}
		count++
		cur = cur.Next
	}

	resRunner.Next = nil
	originRunner.Next = nil
	head = originDummy.Next
	return resDummy.Next
}

//func main() {
//	first := &Node{
//		Val:    7,
//		Next:   nil,
//		Random: nil,
//	}
//
//	second := &Node{
//		Val:    13,
//		Next:   nil,
//		Random: nil,
//	}
//
//	third := &Node{
//		Val:    11,
//		Next:   nil,
//		Random: nil,
//	}
//
//	fourth := &Node{
//		Val:    10,
//		Next:   nil,
//		Random: nil,
//	}
//
//	fifth := &Node{
//		Val:    1,
//		Next:   nil,
//		Random: nil,
//	}
//
//	first.Next = second
//	second.Next = third
//	third.Next = fourth
//	fourth.Next = fifth
//
//	first.Random = nil
//	second.Random = first
//	third.Random = fifth
//	fourth.Random = third
//	fifth.Random = first
//
//	head := copyRandomList(first)
//
//	for head != nil {
//		fmt.Println(head.Val)
//		head = head.Next
//	}
//
//	fmt.Println("--------------------")
//	for first != nil {
//		fmt.Println(first.Val)
//		first = first.Next
//	}
//}
