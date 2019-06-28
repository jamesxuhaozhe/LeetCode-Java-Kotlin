package Array

import java.util.*

class SquaresOfSortedArrayKt {
    fun sortedSquares(A: IntArray): IntArray {
        val n = A.size
        val result = IntArray(n) // Creates an int array of fixed size n, default elements are all 0
        for (index in A.indices) {
            result[index] = A[index] * A[index]
        }
        Arrays.sort(result)
        return result
    }
}