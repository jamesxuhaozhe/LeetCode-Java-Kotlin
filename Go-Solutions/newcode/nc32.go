package newcode

func sqrt32( x int ) int {
	// write code here
	r := x
	for r*r > x {
		r = (r + x/r)/2
	}
	return r
}
