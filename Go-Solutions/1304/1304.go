package main

func main() {
	
}

func sumZero(n int) []int {
	if n == 1 {
		return []int{0}
	}
	list := make([]int, 0)
	start := 0
	sum := 0
	for i := 0; i < n - 1; i++ {
		sum += start
		list = append(list, start)
		start++
	}
	list = append(list, -sum)
	result := make([]int, n)
	i := 0
	for _, v := range list {
		result[i] = v
		i++
	}
	return result
}