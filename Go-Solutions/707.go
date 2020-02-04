package main

func main() {

}

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
func Constructor() MyLinkedList {
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
func (this *MyLinkedList) Get(index int) int {
	if index >= 0 && index < this.size {
		return this.getNodeAtIndex(index).val
	}
	return -1
}

/** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
func (this *MyLinkedList) AddAtHead(val int) {
	preHead := this.headDummy.next
	currHead := &myDoublyLinkedList{
		val: val,
	}
	this.headDummy.next = currHead
	currHead.previous = this.headDummy
	currHead.next = preHead
	preHead.previous = currHead
	this.size++
}

/** Append a node of value val to the last element of the linked list. */
func (this *MyLinkedList) AddAtTail(val int) {
	preTail := this.tailDummy.previous
	currTail := &myDoublyLinkedList{
		val: val,
	}
	preTail.next = currTail
	currTail.previous = preTail
	currTail.next = this.tailDummy
	this.tailDummy.previous = currTail
	this.size++
}

/** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
func (this *MyLinkedList) AddAtIndex(index int, val int) {
	if index > this.size {
		return
	}

	if index == this.size {
		this.AddAtTail(val)
	}

	nodeAtIndex := this.getNodeAtIndex(index)
	preNodeAtIndex := nodeAtIndex.previous
	nodeToAdd := &myDoublyLinkedList{
		val: val,
	}
	preNodeAtIndex.next = nodeToAdd
	nodeToAdd.previous = preNodeAtIndex
	nodeToAdd.next = nodeAtIndex
	nodeAtIndex.previous = nodeToAdd
	this.size++
}

func (this *MyLinkedList) getNodeAtIndex(index int) *myDoublyLinkedList {
	currHead := this.headDummy.next
	for i := 0; i < index; i++ {
		currHead = currHead.next
	}
	return currHead
}

/** Delete the index-th node in the linked list, if the index is valid. */
func (this *MyLinkedList) DeleteAtIndex(index int) {
	if index >= 0 && index < this.size {
		nodeAtIndex := this.getNodeAtIndex(index)
		preNodeAtIndex := nodeAtIndex.previous
		nextNodeAtIndex := nodeAtIndex.next
		preNodeAtIndex.next = nextNodeAtIndex
		nextNodeAtIndex.previous = preNodeAtIndex
		this.size--
	}
}
