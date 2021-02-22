package nowcoder

func getMinStack(op [][]int) []int {
	// write code here
	mStack := newMinStack()
	res := make([]int, 0)
	for _, v := range op {
		if len(v) == 2 {
			if v[0] == 1 {
				mStack.push(v[1])
			}
		} else if len(v) == 1 {
			if v[0] == 2 {
				mStack.pop()
			} else if v[0] == 3 {
				res = append(res, mStack.min())
			}
		}
	}
	return res
}

type stack90 struct {
	data []int
}

func newStack90() *stack90 {
	return &stack90{data: make([]int, 0),}
}

func (s *stack90) push(value int) {
	s.data = append(s.data, value)
}

func (s *stack90) pop() int {
	res := s.data[len(s.data)-1]
	s.data = s.data[:len(s.data)-1]
	return res
}

func (s *stack90) peek() int {
	res := s.data[len(s.data)-1]
	return res
}

func (s *stack90) size() int {
	return len(s.data)
}

type minStack struct {
	data1  *stack90
	assist *stack90
}

func newMinStack() *minStack {
	return &minStack{data1: newStack90(), assist: newStack90(),}
}

func (s *minStack) push(value int) {
	s.data1.push(value)
	if s.assist.size() == 0 || value < s.assist.peek() {
		s.assist.push(value)
	} else {
		s.assist.push(s.assist.peek())
	}
}

func (s *minStack) pop() int {
	res := s.data1.pop()
	s.assist.pop()
	return res
}

func (s *minStack) min() int {
	return s.assist.peek()
}
