package array.transpose_matrix_867

class SolutionKt {

    fun transpose(A: Array<IntArray>): Array<IntArray> {
        if (A.isEmpty()) {
            return A
        }

        val row = A.size
        val col = A[0].size
        val solution = Array(col) { IntArray(row)}
        for (r in 0 until row) {
            for (c in 0 until col) {
                solution[c][r] = A[r][c]
            }
        }
        return solution
    }
}