package nowcoder

import "strings"

func solve114(A string, B string) bool {
	// write code here

	if len(A) == 1 || len(B) == 1 {
		return false
	}

	if len(A) != len(B) {
		return false
	}

	return strings.Index(A+A, B) > 0
}
