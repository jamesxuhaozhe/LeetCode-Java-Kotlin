package array

class SetMatrixZerosKt {
    fun setZeroes(matrix: Array<IntArray>): Unit {
        val rowFlags = BooleanArray(matrix.size)
        val colFlags = BooleanArray(matrix[0].size)
        for (i in 0 until matrix.size) {
            for (j in 0 until matrix[0].size) {
                if (matrix[i][j] == 0) {
                    rowFlags[i] = true
                    colFlags[j] = true
                }
            }
        }

        for (i in 0 until rowFlags.size) {
            if (rowFlags[i]) {
                nullifyRow(matrix, i)
            }
        }

        for (i in 0 until colFlags.size) {
            if (colFlags[i]) {
                nullifyCol(matrix, i)
            }
        }
    }

    private fun nullifyCol(matrix: Array<IntArray>, col: Int) {
        for (i in 0 until matrix.size) {
            matrix[i][col] = 0
        }
    }

    private fun nullifyRow(matrix: Array<IntArray>, row: Int) {
        for (i in 0 until matrix[row].size) {
            matrix[row][i] = 0
        }
    }
}