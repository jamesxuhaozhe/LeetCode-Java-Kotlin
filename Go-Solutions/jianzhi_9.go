package main

type CQueue struct {
	stack1 stack
	stack2 stack
}

// ctor
func Constructor() CQueue {
	return CQueue{
		stack1: createStack(),
		stack2: createStack(),
	}
}

func (q *CQueue) AppendTail(value int) {
	q.stack1.push(value)
}

func (q *CQueue) DeleteHead() int {
	for !q.stack1.isEmpty() {
		q.stack2.push(q.stack1.pop())
	}
	return q.stack2.pop()
}

type stack interface {
	len() int
	push(value int)
	pop() int
	peek() int
	isEmpty() bool
}

type stackImpl struct {
	arr []int
}

func createStack() stack {
	return &stackImpl{arr: make([]int, 0)}
}

func (s *stackImpl) len() int {
	return len(s.arr)
}

func (s *stackImpl) push(value int) {
	s.arr = append(s.arr, value)
}

func (s *stackImpl) pop() int {
	if s.isEmpty() {
		return -1
	}
	res := s.arr[0]
	s.arr = s.arr[1:]
	return res
}

func (s *stackImpl) peek() int {
	res := s.arr[0]
	return res
}

func (s *stackImpl) isEmpty() bool {
	return len(s.arr) == 0
}
