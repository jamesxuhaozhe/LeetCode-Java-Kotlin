package nowcoder

/**
如果p1指针遍历完成了但p2指针还没遍历完，此时应该继续遍历p2指针并填入p指针，由于p2是有序的，就直接用复制数组代替了遍历写入。 如果p2指针遍历完了但p1指针还没遍历完，此时应该继续遍历p1并填入p指针，但由于此时p1指针和p指针重合，所以可以省略遍历操作。
 */
func merge( A []int ,  m int, B []int, n int )  {
	// write code here
	p1 := m - 1
	p2 := n - 1
	p := m + n - 1
	for p1 >= 0 && p2 >= 0 {
		if A[p1] > B[p2] {
			A[p] = A[p1]
			p1--
			p--
		} else {
			A[p] = B[p2]
			p2--
			p--
		}
	}
	for p2 >= 0 {
		A[p] = B[p2]
		p2--
		p--
	}
}
