package main


// just like problem 138
func copyRandomList(head *Node) *Node {
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
