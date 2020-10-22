package main

// 这种做法比较弱智一些，理念是这样，每次以固定长度K的窗口进行滑动，用一个map[byte][int]来记录固定窗口内的情况，没有重复的字符，表示，这个map的所有value都是等于1的
func numKLenSubstrNoRepeats(S string, K int) int {
	if K > len(S) {
		return 0
	}

	flag := make(map[byte]int)
	left, right := 0, 0
	count := 0
	for right < len(S) {
		flag[S[right]]++
		// 当窗口的大小第一次等于K的时候，以后每次都是平移K窗口，说明往后left和right都要同步++
		if right-left+1 == K {
			if isValidWindow1100(flag) {
				count++
			}
			flag[S[left]]--
			left++
		}
		right++
	}
	return count
}

func isValidWindow1100(flag map[byte]int) bool {
	for _, v := range flag {
		if v > 1 {
			return false
		}
	}
	return true
}

// https://leetcode-cn.com/problems/find-k-length-substrings-with-no-repeated-characters/solution/1100-chang-du-wei-k-de-wu-zhong-fu-zi-fu-zi-chua-2/
/**
本题解法时间复杂度为 O(N)。

定义左右指针 i 和 j ，初始为 0；定义一个 HashSet 存储 [i,j) 的所有字符（注意左开右闭）。

1、判断 j 所在字符是否已经存在于 set 中，若不存在，则把 s[j] 加入到 set 中，j++，i 不变；

2、如果 s[j] 已经存在 set 中，则把 s[i] 从 set 中删除，i 往右走一步，j 不变；

3、1 或者 2 执行完都要统计 set 中的字符数量是否达到了 K，如果是，说明找到了一个符合要求的字串，于是数目加一，然后从 set 中删除左侧的 s[i]，i++。

当 j == str.length() 时，遍历完毕。

作者：klb
链接：https://leetcode-cn.com/problems/find-k-length-substrings-with-no-repeated-characters/solution/1100-chang-du-wei-k-de-wu-zhong-fu-zi-fu-zi-chua-2/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/
func numKLenSubstrNoRepeats_smart(S string, K int) int {
	if K > len(S) {
		return 0
	}

	count := 0
	chSet := make(map[byte]bool, 26)
	left, right := 0, 0
	for left < len(S) && right < len(S) {
		if _, ok := chSet[S[right]]; !ok {
			chSet[S[right]] = true
			right++
		} else {
			delete(chSet, S[left])
			left++
		}
		if len(chSet) == K {
			count++
			delete(chSet, S[left])
			left++
		}
	}
	return count
}

//func main() {
//	S := "havefunonleetcode"
//	K := 5
//	fmt.Println(numKLenSubstrNoRepeats_smart(S, K))
//}
