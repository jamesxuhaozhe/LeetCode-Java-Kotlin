package main

func isValid20( s string ) bool {
	// write code here
	n := len(s)
	if n%2 == 1 {
		return false
	}
	hm := map[byte]byte{
		')': '(',
		'}': '{',
		']': '[',
	}
	stk := newStack20()
	for i := 0; i < n; i++ {
		if _, ok := hm[s[i]]; ok {
			var topElement byte = '.'
			if !stk.isEmpty() {
				topElement = stk.pop()
			}
			if topElement != hm[s[i]] {
				return false
			}
		} else {
			stk.push(s[i])
		}
	}
	return stk.isEmpty()
}

func newStack20() *stack20 {
	return &stack20{arr: make([]byte, 0)}
}

type stack20 struct {
	arr []byte
}

func (s *stack20) push(c byte) {
	s.arr = append(s.arr, c)
}

func (s *stack20) pop() byte {
	res := s.arr[len(s.arr)-1]
	s.arr = s.arr[:len(s.arr)-1]
	return res
}

func (s *stack20) isEmpty() bool {
	return len(s.arr) == 0
}
