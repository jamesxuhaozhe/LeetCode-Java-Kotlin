package jianzhi

import "strings"

func replaceSpace(s string) string {
	return strings.ReplaceAll(s, " ", "%20")
}


func replaceSpace1(s string) string {
	var result strings.Builder
	for i := range s {
		if s[i] == ' ' {
			result.WriteString("%20")
		} else {
			result.WriteByte(s[i])
		}
	}
	return result.String()
}