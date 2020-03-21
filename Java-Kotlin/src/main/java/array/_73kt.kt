package array

class _73kt {

    fun setZeroes(matrix: Array<IntArray>): Unit {
        val rowFlags = BooleanArray(matrix.size)
        val colFlags = BooleanArray(matrix[0].size)
        for (i in matrix.indices) {
            for (j in matrix[0].indices) {
                if (matrix[i][j] == 0) {
                    rowFlags[i] = true
                    colFlags[j] = true
                }
            }
        }

        for (i in rowFlags.indices) {
            if (rowFlags[i]) {
                nullifyRow(matrix, i)
            }
        }

        for (i in colFlags.indices) {
            if (colFlags[i]) {
                nullifyCol(matrix, i)
            }
        }
    }

    private fun nullifyCol(matrix: Array<IntArray>, col: Int) {
        for (element in matrix) {
            element[col] = 0
        }
    }

    private fun nullifyRow(matrix: Array<IntArray>, row: Int) {
        for (i in matrix[row].indices) {
            matrix[row][i] = 0
        }
    }
}