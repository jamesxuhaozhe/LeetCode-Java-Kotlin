package nowcoder

func Clone(head *RandomListNode) *RandomListNode {
	//write your code here
	if head == nil {
		return head
	}

	// insert a node after each node in the head
	headRunner := head
	//1、复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面；
	for headRunner != nil {
		next := headRunner.Next

		copyNode := &RandomListNode{
			Label:  headRunner.Label,
			Next:   nil,
			Random: nil,
		}

		copyNode.Next = next
		headRunner.Next = copyNode
		headRunner = next
	}

	headRunner = head
	for headRunner != nil {
		copyNode := headRunner.Next
		if headRunner.Random == nil {
			copyNode.Random = nil
		} else {
			copyNode.Random = headRunner.Random.Next
		}
		headRunner = headRunner.Next.Next
	}

	headRunner = head
	cloneHead := head.Next
	for headRunner != nil {
		clonedNode := headRunner.Next
		headRunner.Next = clonedNode.Next
		if clonedNode.Next == nil {
			clonedNode.Next = nil
		} else {
			clonedNode.Next = clonedNode.Next.Next
		}
		headRunner = headRunner.Next
	}

	return cloneHead
}
