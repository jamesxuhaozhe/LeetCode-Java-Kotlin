package nowcoder

func GetUglyNumber_Solution(index int) int {
	if index <= 0 {
		return 0
	}

	uglyNums := make([]int, index)
	nextIdx := 1
	uglyNums[0] = 1
	p2, p3, p5 := 0, 0, 0
	for nextIdx < index {
		nextUglyNum := min33(uglyNums[p2]*2, min33(uglyNums[p3]*3, uglyNums[p5]*5))
		uglyNums[nextIdx] = nextUglyNum
		for uglyNums[p2]*2 <= nextUglyNum {
			p2++
		}
		for uglyNums[p3]*3 <= nextUglyNum {
			p3++
		}
		for uglyNums[p5]*5 <= nextUglyNum {
			p5++
		}
		nextIdx++
	}
	return uglyNums[index-1]
}

func min33(a, b int) int {
	if a < b {
		return a
	}
	return b
}
