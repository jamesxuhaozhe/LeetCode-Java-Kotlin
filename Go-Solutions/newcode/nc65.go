package newcode

func Fibonacci( n int ) int {
	// write code here
	if n == 0 || n == 1 {
		return n
	}
	arr := make([]int, n+1)
	arr[0], arr[1] = 0, 1
	for i := 2; i < n+1; i++ {
		arr[i] = arr[i-1] + arr[i-2]
	}
	return arr[n]
}
