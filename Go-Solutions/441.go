package main

// 本质就是二分查找
func arrangeCoins(n int) int {
	if n <= 0 {
		return 0
	}

	if n == 1 {
		return n
	}

	low, high := 1, n
	for low <= high {
		mid := low + (high-low)>>1
		sum := getSum441(mid)
		if sum == n {
			return mid
		} else if sum > n {
			high = mid - 1
		} else {
			if mid == n || getSum441(mid+1) > n {
				return mid
			}
			low = mid + 1
		}
	}
	return 0
}

func getSum441(n int) int {
	return (1 + n) * n / 2
}

//func main() {
//	fmt.Println(arrangeCoins(8))
//}
