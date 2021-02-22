package nowcoder

var stack1jz20 []int
var stack2jz20 []int

func init() {
	stack1jz20 = make([]int, 0)
	stack2jz20 = make([]int, 0)
}

func Pushjz20(node int) {
	// write code here
	stack1jz20 = append(stack1jz20, node)

	if len(stack2jz20) == 0 || stack2jz20[len(stack2jz20)-1] > node {
		stack2jz20 = append(stack2jz20, node)
	} else {
		value := stack2jz20[len(stack2jz20)-1]
		stack2jz20 = append(stack2jz20, value)
	}
}
func Popjz20() {
	// write code here
	if len(stack1jz20) > 0 && len(stack2jz20) > 0 {
		stack1jz20 = stack1jz20[:len(stack1jz20)-1]
		stack2jz20 = stack2jz20[:len(stack2jz20)-1]
	}
}
func Top() int {
	// write code here
	if len(stack1jz20) > 0 {
		return stack1jz20[len(stack1jz20)-1]
	}
	return -1
}
func Min() int {
	// write code here
	if len(stack2jz20) > 0 {
		return stack2jz20[len(stack2jz20)-1]
	}
	return -1

}
