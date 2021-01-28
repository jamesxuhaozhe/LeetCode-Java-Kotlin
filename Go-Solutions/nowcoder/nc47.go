package nowcoder

func solveSudoku(board [][]byte) {
	// write code here
	if !isValidBoard(board) {
		return
	}

	dfs47(board, 0, 0, len(board), len(board[0]))
}

func dfs47(board [][]byte, i int, j int, m int, n int) bool {
	if j == n {
		return dfs47(board, i+1, 0, m, n)
	}

	if i == m {
		return true
	}

	if board[i][j] != '.' {
		return dfs47(board, i, j+1, m, n)
	}

	for ch := byte('1'); ch <= '9'; ch++ {
		if !isValid47(board, i, j, ch) {
			continue
		}
		board[i][j] = ch
		if dfs47(board, i, j+1, m, n) {
			return true
		}
		board[i][j] = '.'
	}

	return false
}

func isValid47(board [][]byte, x int, y int, ch byte) bool {
	for i := 0; i < 9; i++ {
		if board[x][i] == ch {
			return false
		}
		if board[i][y] == ch {
			return false
		}
		if board[(x/3)*3+i/3][(y/3)*3+i%3] == ch {
			return false
		}
	}
	return true
}

func isValidBoard(board [][]byte) bool {
	if board == nil || len(board) == 0 || len(board[0]) == 0 {
		return false
	}
	return true
}
