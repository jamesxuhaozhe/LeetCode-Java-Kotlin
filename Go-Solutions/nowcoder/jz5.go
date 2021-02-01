package nowcoder

var stack1jz5 [] int
var stack2jz5 [] int

func init() {
	stack1jz5 = make([]int, 0)
	stack2jz5 = make([]int, 0)
}

func Pushjz5(node int) {
	stack1jz5 = append(stack1jz5, node)
}

func Popjz5() int {
	if len(stack2jz5) > 0 {
		value := stack2jz5[len(stack2jz5)-1]
		stack2jz5 = stack2jz5[:len(stack2jz5)-1]
		return value
	}

	for len(stack1jz5) != 0 {
		value := stack1jz5[len(stack1jz5)-1]
		stack1jz5 = stack1jz5[:len(stack1jz5)-1]
		stack2jz5 = append(stack2jz5, value)
	}

	if len(stack2jz5) > 0 {
		value := stack2jz5[len(stack2jz5)-1]
		stack2jz5 = stack2jz5[:len(stack2jz5)-1]
		return value
	}
	return -1
}
