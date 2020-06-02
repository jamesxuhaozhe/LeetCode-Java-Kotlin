package main

func kidsWithCandies(candies []int, extraCandies int) []bool {
	ret := make([]bool, 0, len(candies))
	max := max(candies)
	for _, v := range candies {
		if v + extraCandies >= max {
			ret = append(ret, true)
		} else {
			ret = append(ret, false)
		}
	}
	return ret
}

func max(candies []int) int {
	if len(candies) == 1 {
		return candies[0]
	}

	max := candies[0]
	for _, v := range candies {
		if v > max {
			max = v
		}
	}
	return max
}
