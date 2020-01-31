package main

func main() {
	
}

func moveZeroes(nums []int)  {
	j := 0
	for i, _ := range nums {
		if nums[i] != 0 {
			nums[j] = nums[i]
			j++
		}
	}

	for ; j < len(nums); j++ {
		nums[j] = 0
	}
}
