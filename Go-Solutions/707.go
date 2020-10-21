package main

type MyLinkedList struct {
	size      int
	headDummy *myDoublyLinkedList
	tailDummy *myDoublyLinkedList
}

type myDoublyLinkedList struct {
	val      int
	previous *myDoublyLinkedList
	next     *myDoublyLinkedList
}

/** Initialize your data structure here. */
func Constructor_707() MyLinkedList {
	var linkedList = MyLinkedList{
		size: 0,
		headDummy: &myDoublyLinkedList{
			val: 0,
		},
		tailDummy: &myDoublyLinkedList{
			val: 0,
		},
	}

	linkedList.headDummy.next = linkedList.tailDummy
	linkedList.tailDummy.previous = linkedList.headDummy
	return linkedList
}

/** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
func (m *MyLinkedList) Get(index int) int {
	if index >= 0 && index < m.size {
		return m.getNodeAtIndex(index).val
	}
	return -1
}

/** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
func (m *MyLinkedList) AddAtHead(val int) {
	preHead := m.headDummy.next
	currHead := &myDoublyLinkedList{
		val: val,
	}
	m.headDummy.next = currHead
	currHead.previous = m.headDummy
	currHead.next = preHead
	preHead.previous = currHead
	m.size++
}

/** Append a node of value val to the last element of the linked list. */
func (m *MyLinkedList) AddAtTail(val int) {
	preTail := m.tailDummy.previous
	currTail := &myDoublyLinkedList{
		val: val,
	}
	preTail.next = currTail
	currTail.previous = preTail
	currTail.next = m.tailDummy
	m.tailDummy.previous = currTail
	m.size++
}

/** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
func (m *MyLinkedList) AddAtIndex(index int, val int) {
	if index > m.size {
		return
	}

	if index == m.size {
		m.AddAtTail(val)
	}

	nodeAtIndex := m.getNodeAtIndex(index)
	preNodeAtIndex := nodeAtIndex.previous
	nodeToAdd := &myDoublyLinkedList{
		val: val,
	}
	preNodeAtIndex.next = nodeToAdd
	nodeToAdd.previous = preNodeAtIndex
	nodeToAdd.next = nodeAtIndex
	nodeAtIndex.previous = nodeToAdd
	m.size++
}

func (m *MyLinkedList) getNodeAtIndex(index int) *myDoublyLinkedList {
	currHead := m.headDummy.next
	for i := 0; i < index; i++ {
		currHead = currHead.next
	}
	return currHead
}

/** Delete the index-th node in the linked list, if the index is valid. */
func (m *MyLinkedList) DeleteAtIndex(index int) {
	if index >= 0 && index < m.size {
		nodeAtIndex := m.getNodeAtIndex(index)
		preNodeAtIndex := nodeAtIndex.previous
		nextNodeAtIndex := nodeAtIndex.next
		preNodeAtIndex.next = nextNodeAtIndex
		nextNodeAtIndex.previous = preNodeAtIndex
		m.size--
	}
}
