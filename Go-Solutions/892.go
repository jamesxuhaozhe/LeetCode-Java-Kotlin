package main

func surfaceArea(grid [][]int) int {
	if grid == nil || len(grid) == 0 {
		return 0
	}

	area := 0
	row := len(grid)
	col := len(grid[0])
	for i := 0; i < row; i++ {
		for j := 0; j < col; j++ {
			if grid[i][j] > 0 {
				area += 2
				area += checkLeft(grid, row, col, i, j)
				area += checkUp(grid, row, col, i, j)
				area += checkRight(grid, row, col, i, j)
				area += checkDown(grid, row, col, i, j)
			}
		}
	}
	return area
}

func checkDown(grid [][]int, row int, col int, i int, j int) int {
	if i < row-1 {
		downNeighbor := grid[i+1][j]
		if downNeighbor > 0 {
			if downNeighbor > grid[i][j] {
				return 0
			} else {
				return grid[i][j] - downNeighbor
			}
		} else {
			return grid[i][j]
		}

	} else {
		return grid[i][j]
	}
}

func checkRight(grid [][]int, row int, col int, i int, j int) int {
	if j < col-1 {
		rightNeighbor := grid[i][j+1]
		if rightNeighbor > 0 {
			if rightNeighbor > grid[i][j] {
				return 0
			} else {
				return grid[i][j] - rightNeighbor
			}
		} else {
			return grid[i][j]
		}

	} else {
		return grid[i][j]
	}
}

func checkUp(grid [][]int, row int, col int, i int, j int) int {
	if i > 0 {
		upNeighbor := grid[i-1][j]
		if upNeighbor > 0 {
			if upNeighbor > grid[i][j] {
				return 0
			} else {
				return grid[i][j] - upNeighbor
			}
		} else {
			return grid[i][j]
		}
	} else {
		return grid[i][j]
	}
}

func checkLeft(grid [][]int, row int, col int, i int, j int) int {
	if j > 0 {
		leftNeib := grid[i][j-1]
		if leftNeib > 0 {
			if leftNeib > grid[i][j] {
				return 0
			} else {
				return grid[i][j] - leftNeib
			}
		} else {
			return grid[i][j]
		}
	} else {
		return grid[i][j]
	}
}
