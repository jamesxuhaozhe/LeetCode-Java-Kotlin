package newcode

var stack1 []int
var stack2 []int

func Push(node int) {
	stack1 = append(stack1, node)
}

func Pop() int {
	if len(stack1) == 0 && len(stack2) == 0 {
		return -1
	}
	if len(stack2) != 0 {
		res := stack2[len(stack2)-1]
		stack2 = stack2[:len(stack2)-1]
		return res
	}
	for len(stack1) != 0 {
		popNode := stack1[len(stack1)-1]
		stack1 = stack1[:len(stack1)-1]
		stack2 = append(stack2, popNode)
	}
	res := stack2[len(stack2)-1]
	stack2 = stack2[:len(stack2)-1]
	return res
}
