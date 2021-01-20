package nowcoder

func isValid( s string ) bool {
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
	stk := newStack()
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

func newStack() *stack {
	return &stack{arr: make([]byte, 0)}
}

type stack struct {
	arr []byte
}

func (s *stack) push(c byte) {
	s.arr = append(s.arr, c)
}

func (s *stack) pop() byte {
	res := s.arr[len(s.arr)-1]
	s.arr = s.arr[:len(s.arr)-1]
	return res
}

func (s *stack) isEmpty() bool {
	return len(s.arr) == 0
}
