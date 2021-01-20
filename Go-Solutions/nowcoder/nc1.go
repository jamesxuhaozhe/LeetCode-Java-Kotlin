package nowcoder

import "strconv"

func solve(s string, t string) string {
	// write code here
	sp, tp := len(s), len(t)
	ns, nt, carry := 0, 0, 0
	current := 0
	buf := make([]int, 0)
	for sp > 0 || tp > 0 || carry > 0 {
		if sp == 0 {
			ns = 0
		} else {
			ns = getNum(s[sp-1 : sp])
			sp--
		}
		if tp == 0 {
			nt = 0
		} else {
			nt = getNum(t[tp-1 : tp])
			tp--
		}
		sum := nt + ns + carry
		current = sum % 10
		carry = sum / 10
		buf = append(buf, current)
	}
	res := ""
	for len(buf) != 0 {
		num := buf[len(buf)-1]
		buf = buf[:len(buf)-1]
		res += strconv.Itoa(num)
	}
	return res
}

func getNum(s string) int {
	num, err := strconv.Atoi(s)
	if err != nil {
		return -1
	}
	return num
}
